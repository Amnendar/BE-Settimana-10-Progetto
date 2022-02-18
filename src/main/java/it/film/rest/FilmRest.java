package it.film.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import it.film.dao.FilmDao;
import it.film.dao.FilmDaoImp;
import it.film.entity.Film;

//link di accesso a Swagger http://localhost:8080/progettosettimana10-0.0.1-SNAPSHOT/swagger-ui.html

@RestController
@RequestMapping("/film")
@Api(value = "FilmRest", tags = "Gestione piattaforma film")
public class FilmRest {
	
	FilmDao fd = new FilmDaoImp();
	
	
	@PostMapping
	@ApiOperation(value = "Inserimento film", notes = "Permette di inserire un film in piattaforma")
	public ResponseEntity<String> inserisciFilm(@RequestBody Film f){
		try {
			fd.salva(f);
			return new ResponseEntity<String>("Film inserito con successo!", HttpStatus.OK);
		} catch (Exception e) {
			
		} 
		return new ResponseEntity<String>("ERRORE! Inserimento film non riuscito!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Aggiorna film", notes = "Aggiorna i dati di un determinato film")
	public ResponseEntity<String> aggiornaFilm(@PathVariable int id, @RequestBody Film f){
		f.setId(id);
		try {
			fd.aggiorna(f);
			return new ResponseEntity<String>("Film aggiornato correttamente!", HttpStatus.ACCEPTED);
			
		} 
		catch (Exception e) {
			return new ResponseEntity<String>("ERRORE! aggiornamento film non riuscito!", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Cancella film", notes = "Cancella il film dalla piattaforma")
	public ResponseEntity<String> cancellaCittadino(@PathVariable int id){
		try {
			fd.cancella(id);
			return new ResponseEntity<String>("Film cancellato correttamente!", HttpStatus.ACCEPTED);
			
		} 
		catch (Exception e) {
			return new ResponseEntity<String>("ERRORE! cancellamento film non riuscito!", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/{regista}")
	@ApiOperation(value = "Cerca film per regista", notes = "Restituisce tutti i film di un determinato regista")
	public ResponseEntity<List<Film>> trovaPerRegista(@PathVariable String regista){
		try {
			return new ResponseEntity<List<Film>>(fd.trovaByRegista(regista), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping
	@ApiOperation(value = "Lista film", notes = "Visualizza la lista di tutti i film presenti in piattaforma")
	public ResponseEntity<List<Film>> getAllFilm(){
		try {
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	

}
