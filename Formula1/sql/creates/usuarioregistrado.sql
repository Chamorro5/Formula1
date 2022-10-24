-- Table: public.usuarioregistrado

-- DROP TABLE public.usuarioregistrado;

CREATE TABLE public.usuarioregistrado
(
    idusuario character varying(30) COLLATE pg_catalog."default" NOT NULL,
    nombrepublico character varying(60) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(75) COLLATE pg_catalog."default" NOT NULL,
    rol character varying(5) COLLATE pg_catalog."default",
    CONSTRAINT usuarioregistrado_pkey PRIMARY KEY (idusuario),
    CONSTRAINT email_unique UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE public.usuarioregistrado
    OWNER to postgres;