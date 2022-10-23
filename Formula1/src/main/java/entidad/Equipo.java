package entidad;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Entidad
{
    public String nombre;
    public byte[] logo;
    public String twitter;
    public List<Piloto> pilotos;
    
    public Equipo() {
        this.nombre = "";
        this.logo = null;
        this.twitter = "";
        this.pilotos = new ArrayList<Piloto>();
    }
    
    public Equipo(final String nombre, final byte[] logo, final String twitter, final List<Piloto> pilotos) {
        this.nombre = nombre;
        this.logo = logo;
        this.twitter = twitter;
        this.pilotos = pilotos;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(final byte[] logo) {
        this.logo = logo;
    }
    
    public String getTwitter() {
        return this.twitter;
    }
    
    public void setTwitter(final String twitter) {
        this.twitter = twitter;
    }
    
    public List<Piloto> getPilotos() {
        return this.pilotos;
    }
    
    public void setPilotos(final List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
}