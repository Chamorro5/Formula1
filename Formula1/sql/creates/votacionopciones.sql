-- Table: public.votacionopciones

-- DROP TABLE public.votacionopciones;

CREATE TABLE public.votacionopciones
(
    permalink character varying(100) COLLATE pg_catalog."default" NOT NULL,
    tabladato character varying(20) COLLATE pg_catalog."default" NOT NULL,
    referencia character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cantidad integer NOT NULL DEFAULT 0,
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    CONSTRAINT votacionopciones_pkey PRIMARY KEY (id),
    CONSTRAINT permalink_fk FOREIGN KEY (permalink)
        REFERENCES public.votacion (permalink) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.votacionopciones
    OWNER to postgres;

COMMENT ON CONSTRAINT permalink_fk ON public.votacionopciones
    IS 'Se relaciona con la tabla de votaciones';