-- Table: public.noticia

-- DROP TABLE public.noticia;

CREATE TABLE public.noticia
(
    permalink character varying(100) COLLATE pg_catalog."default" NOT NULL,
    titulo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    imagen bytea,
    texto character varying(2000) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT noticia_pkey PRIMARY KEY (permalink)
)

TABLESPACE pg_default;

ALTER TABLE public.noticia
    OWNER to postgres;