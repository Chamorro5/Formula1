-- Table public.votacion

-- DROP TABLE public.votacion;

CREATE TABLE public.votacion
(
    permalink character varying(100) COLLATE pg_catalog.default NOT NULL,
    titulo character varying(100) COLLATE pg_catalog.default NOT NULL,
    descripcion character varying(500) COLLATE pg_catalog.default NOT NULL,
    limite timestamp without time zone NOT NULL,
    CONSTRAINT votacion_pkey PRIMARY KEY (permalink)
)

TABLESPACE pg_default;

ALTER TABLE public.votacion
    OWNER to postgres;