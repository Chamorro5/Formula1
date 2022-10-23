package entidad;

public class Piloto extends Entidad
{
    public String nombre;
    public String apellidos;
    public String siglas;
    public int dorsal;
    public byte[] foto;
    public String pais;
    public String twitter;
    public Equipo equipo;
    
    public Piloto() {
        this.nombre = "";
        this.apellidos = "";
        this.siglas = "";
        this.dorsal = 0;
        this.foto = null;
        this.pais = "";
        this.twitter = "";
        this.equipo = null;
    }
    
    public Piloto(final String nombre, final String apellidos, final String siglas, final int dorsal, final byte[] foto, final String pais, final String twitter, final Equipo equipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.siglas = siglas;
        this.dorsal = dorsal;
        this.foto = foto;
        this.pais = pais;
        this.twitter = twitter;
        this.equipo = equipo;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getSiglas() {
        return this.siglas;
    }
    
    public void setSiglas(final String siglas) {
        this.siglas = siglas;
    }
    
    public int getDorsal() {
        return this.dorsal;
    }
    
    public void setDorsal(final int dorsal) {
        this.dorsal = dorsal;
    }
    
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(final byte[] foto) {
        this.foto = foto;
    }
    
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(final String pais) {
        this.pais = pais;
    }
    
    public String getTwitter() {
        return this.twitter;
    }
    
    public void setTwitter(final String twitter) {
        this.twitter = twitter;
    }
    
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(final Equipo equipo) {
        this.equipo = equipo;
    }
}