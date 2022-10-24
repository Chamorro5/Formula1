-- Table: public.coche

-- DROP TABLE public.coche;

CREATE TABLE public.coche
(
    codigo character varying(10) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    ersslowturns numeric(3,2) NOT NULL,
    ersmediumturns numeric(3,2) NOT NULL,
    ersfastturns numeric(3,2) NOT NULL,
    consumo numeric(3,1) NOT NULL,
    CONSTRAINT coche_pkey PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE public.coche
    OWNER to postgres;