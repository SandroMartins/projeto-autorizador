PGDMP                      	    w            sistema-autorizador    11.3    11.3     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    32971    sistema-autorizador    DATABASE     �   CREATE DATABASE "sistema-autorizador" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
 %   DROP DATABASE "sistema-autorizador";
             postgres    false            �            1259    32996    autorizador    TABLE     �   CREATE TABLE public.autorizador (
    id_autorizador integer NOT NULL,
    nr_procedimento integer NOT NULL,
    idade integer NOT NULL,
    sexo character varying(50) NOT NULL,
    ativo boolean DEFAULT true
);
    DROP TABLE public.autorizador;
       public         postgres    false            �            1259    32994    autorizador_id_autorizador_seq    SEQUENCE     �   CREATE SEQUENCE public.autorizador_id_autorizador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.autorizador_id_autorizador_seq;
       public       postgres    false    197                       0    0    autorizador_id_autorizador_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.autorizador_id_autorizador_seq OWNED BY public.autorizador.id_autorizador;
            public       postgres    false    196            }
           2604    32999    autorizador id_autorizador    DEFAULT     �   ALTER TABLE ONLY public.autorizador ALTER COLUMN id_autorizador SET DEFAULT nextval('public.autorizador_id_autorizador_seq'::regclass);
 I   ALTER TABLE public.autorizador ALTER COLUMN id_autorizador DROP DEFAULT;
       public       postgres    false    196    197    197            �
          0    32996    autorizador 
   TABLE DATA               Z   COPY public.autorizador (id_autorizador, nr_procedimento, idade, sexo, ativo) FROM stdin;
    public       postgres    false    197   �                  0    0    autorizador_id_autorizador_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.autorizador_id_autorizador_seq', 10, true);
            public       postgres    false    196            �
           2606    33002    autorizador autorizador_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.autorizador
    ADD CONSTRAINT autorizador_pkey PRIMARY KEY (id_autorizador);
 F   ALTER TABLE ONLY public.autorizador DROP CONSTRAINT autorizador_pkey;
       public         postgres    false    197            �
   T   x�=���0�S1�k ��T@��l1\����E�v\x���.x�c�3I�Ϊ��^��39�-��F���Wh�plD���1     