PGDMP     *                    z            progettofilm    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    25173    progettofilm    DATABASE     h   CREATE DATABASE progettofilm WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE progettofilm;
                postgres    false            ?            1259    25175    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    25174    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    25175    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   ?       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 9, true);
          public          postgres    false    209            ]           2606    25181    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?   ?  x?U?Mw?0E??W8?8B(?C?SQ?j]o???@?~??????f?N?>?( ɲ^~Q????lsM̷e^5??	cK???????)????Vy?*۸???̦	??d?K\???҆6??
??f?n%?-?$1Y?>?ۘ{?Y??????b???[????????Dw?ت[o??=91?$??F8?ʉS?3Ï?J*P?s?G???])U?r?>?P?k???CP??-?&???˾?M=?aB???	?N>?
??÷??͝Kڣ??,Q??Z???]6I1CX?vF??F:?~3&Q??O*?:K?j?]j12^S?Մ^?㔌o?쇾??nHNo'?????????5W4=ݮg'??r??إ???6??<?[??׬????fX?=虿ݖ4fA??#??Q%:S^a_??<??M?????}y??B?i?~?????%m???TH??????????kj?)?gMk??r?ܙ5K?n?q?ܹ?̝?o?S??????o?,??(I?_???d     