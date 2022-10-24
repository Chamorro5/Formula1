-- Table: public.voto

-- DROP TABLE public.voto;

CREATE TABLE public.voto
(
    idusuario character varying(30) COLLATE pg_catalog."default" NOT NULL,
    permalink character varying(100) COLLATE pg_catalog."default" NOT NULL,
    idvotacionopcion integer NOT NULL,
    CONSTRAINT votos_pk PRIMARY KEY (idusuario, permalink),
    CONSTRAINT idusuario_fk FOREIGN KEY (idusuario)
        REFERENCES public.usuarioregistrado (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT idvotacionopciones_fk FOREIGN KEY (idvotacionopcion)
        REFERENCES public.votacionopciones (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT permalink_fk FOREIGN KEY (permalink)
        REFERENCES public.votacion (permalink) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.voto
    OWNER to postgres;