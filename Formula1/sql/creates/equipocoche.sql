-- Table: public.equipocoche

-- DROP TABLE public.equipocoche;

CREATE TABLE public.equipocoche
(
    codigocoche character varying(10) COLLATE pg_catalog."default" NOT NULL,
    nombreequipo character varying(75) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT codigocoche_fk FOREIGN KEY (codigocoche)
        REFERENCES public.coche (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT nombreequipo_fk FOREIGN KEY (nombreequipo)
        REFERENCES public.equipo (nombre) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.equipocoche
    OWNER to postgres;