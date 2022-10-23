package entidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Votacion
{
    private String permalink;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private List<Piloto> lPilotos;
    private List<Votacion> lVotacion;
    
    public Votacion() {
        this.permalink = "";
        this.titulo = "";
        this.descripcion = "";
        this.fecha = null;
        this.lPilotos = new ArrayList<Piloto>();
        this.lVotacion = new ArrayList<Votacion>();
    }
    
    public Votacion(final String permalink, final String titulo, final String descripcion, final Date fecha, final List<Piloto> lPilotos, final List<Votacion> lVotacion) {
        this.permalink = permalink;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lPilotos = lPilotos;
        this.lVotacion = lVotacion;
    }
    
    public String getPermalink() {
        return this.permalink;
    }
    
    public void setPermalink(final String permalink) {
        this.permalink = permalink;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
    
    public List<Piloto> getlPilotos() {
        return this.lPilotos;
    }
    
    public void setlPilotos(final List<Piloto> lPilotos) {
        this.lPilotos = lPilotos;
    }
    
    public List<Votacion> getlVotacion() {
        return this.lVotacion;
    }
    
    public void setlVotacion(final List<Votacion> lVotacion) {
        this.lVotacion = lVotacion;
    }
}