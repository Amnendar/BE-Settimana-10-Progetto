PGDMP     -                    z            progettofilm    14.1    14.1 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25173    progettofilm    DATABASE     h   CREATE DATABASE progettofilm WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE progettofilm;
                postgres    false            �            1259    25175    film    TABLE     �   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            �            1259    25174    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �          0    25175    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   �       �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 4, true);
          public          postgres    false    209            ]           2606    25181    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            �     x�5ͻv�0  �9|�sL�A����(
T��K��` �߷�w��0#t��̝&����o��D$�2���3�ր�!-u-����gL��y
,�����C��\�
�T5��ͼ��^#������>��Tx��N1�:�C�ⱺ�r��]��a�h�E��2�C)H��2�H�����饢�ε����]`���/����΄_�M� ���׭]�C����4�.l��7&���bW&��h�h�|5����~��i�\�     