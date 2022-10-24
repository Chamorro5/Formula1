-- Table: public.parrilla

-- DROP TABLE public.parrilla;

CREATE TABLE public.parrilla
(
    siglas character varying(3) COLLATE pg_catalog."default" NOT NULL,
    nombreequipo character varying(75) COLLATE pg_catalog."default" NOT NULL,
    temporada integer NOT NULL,
    CONSTRAINT parrilla_pkey PRIMARY KEY (siglas, nombreequipo, temporada),
    CONSTRAINT nombreequipo_fk FOREIGN KEY (nombreequipo)
        REFERENCES public.equipo (nombre) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT siglas_fk FOREIGN KEY (siglas)
        REFERENCES public.piloto (siglas) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.parrilla
    OWNER to postgres;