-- Table: public.circuito

-- DROP TABLE public.circuito;

CREATE TABLE public.circuito
(
    nombre character varying(60) COLLATE pg_catalog."default" NOT NULL,
    ciudad character varying(30) COLLATE pg_catalog."default" NOT NULL,
    pais character varying(3) COLLATE pg_catalog."default" NOT NULL,
    trazado bytea,
    numlaps integer NOT NULL,
    longitud integer NOT NULL,
    slowturns integer NOT NULL,
    mediumturns integer NOT NULL,
    fastturns integer NOT NULL,
    CONSTRAINT circuito_pkey PRIMARY KEY (nombre)
)

TABLESPACE pg_default;

ALTER TABLE public.circuito
    OWNER to postgres;