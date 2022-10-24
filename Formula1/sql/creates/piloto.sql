-- Table: public.piloto

-- DROP TABLE public.piloto;

CREATE TABLE public.piloto
(
    nombre character varying(30) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(60) COLLATE pg_catalog."default" NOT NULL,
    siglas character varying(3) COLLATE pg_catalog."default" NOT NULL,
    dorsal integer NOT NULL,
    foto bytea,
    pais character varying(3) COLLATE pg_catalog."default" NOT NULL,
    twitter character varying(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT piloto_pkey PRIMARY KEY (siglas),
    CONSTRAINT siglas_unique UNIQUE (siglas)
        INCLUDE(siglas)
)

TABLESPACE pg_default;

ALTER TABLE public.piloto
    OWNER to postgres;