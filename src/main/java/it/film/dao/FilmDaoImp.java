package it.film.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.film.entity.Film;

public class FilmDaoImp implements FilmDao {

private EntityManager em = null;
	
	public EntityManager getEm() {
		if (em == null) {
		em = EntityManagerHelper.getEntityManager();  
		}
		return em;
	}
	
	
	/**
	 *  Salva un film nella piattaforma
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  f = Film da salvare
	 *  @return  void
	 */
	public void salva(Film f) {
		//criptazione one way
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		getEm().getTransaction().begin();
		getEm().persist(f);
		getEm().getTransaction().commit();
	}

	/**
	 *  Modifica i dati di un film nella piattaforma
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  f = Film da aggiornare
	 *  @return  void
	 * @throws Exception 
	 */
	public void aggiorna(Film f) throws Exception {
		Film cmp = getEm().find(Film.class, f.getId());
		if (cmp == null){
			throw new Exception("Film non trovato");
		}
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		getEm().getTransaction().begin();
		getEm().merge(f);
		getEm().getTransaction().commit();
	}

	/**
	 *  Cancella un film dalla piattaforma
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  f = Film da cancellare
	 *  @return  void
	 */
	public void cancella(int id) {
		try {
			getEm().getTransaction().begin();
			getEm().remove(getEm().find(Film.class, id)); //dobbiamo prima cercare il cittadino e su quello facciamo il remove
			
				
			} catch (Exception e) {
				em.getTransaction().rollback();
			}
			finally {
				getEm().getTransaction().commit();
			}
		
	}

	/**
	 *  Restituisce una lista dei film del regista
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  regista = nome e cognome del regista
	 *  @return  List di Film
	 */
	@SuppressWarnings("unchecked")
	public List<Film> trovaByRegista(String regista) {
		return getEm().createNamedQuery("film.trovaperregista").setParameter(1, regista).getResultList();
		
		
	}

	/**
	 *  Restituisce una lista di tutti i film presenti nella piattaforma
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  
	 *  @return  List di Film
	 */
	@SuppressWarnings("unchecked")
	public List<Film> trovaTutti() {
		
		return getEm().createNamedQuery("film.trovatutti").getResultList();
	}


	/**
	 *  Restituisce un film dall id
	 * 
	 *  @author Antonello Pagnozzi 
	 *  @param  id = id del film da cercare
	 *  @return  Film con l id corrispondente
	 */
	public Film trovaById(int id) {
		
		return getEm().find(Film.class, id);
	}

}
