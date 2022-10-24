-- Table: public.equipo

-- DROP TABLE public.equipo;

CREATE TABLE public.equipo
(
    nombre character varying(75) COLLATE pg_catalog."default" NOT NULL,
    logo bytea,
    twitter character varying(16) COLLATE pg_catalog."default",
    CONSTRAINT equipo_pkey PRIMARY KEY (nombre)
)

TABLESPACE pg_default;

ALTER TABLE public.equipo
    OWNER to postgres;