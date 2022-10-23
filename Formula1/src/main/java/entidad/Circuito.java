package entidad;

public class Circuito
{
    private String nombre;
    private String ciudad;
    private String pais;
    private byte[] trazado;
    private int numVueltas;
    private int longitud;
    private int cuvLentas;
    private int cuvMedias;
    private int cuvRapidas;
    
    public Circuito() {
        this.nombre = "";
        this.ciudad = "";
        this.pais = "";
        this.trazado = null;
        this.numVueltas = -1;
        this.longitud = -1;
        this.cuvLentas = -1;
        this.cuvMedias = -1;
        this.cuvRapidas = -1;
    }
    
    public Circuito(final String nombre, final String ciudad, final String pais, final byte[] trazado, final int numVueltas, final int longitud, final int cuvLentas, final int cuvMedias, final int cuvRapidas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.trazado = trazado;
        this.numVueltas = numVueltas;
        this.longitud = longitud;
        this.cuvLentas = cuvLentas;
        this.cuvMedias = cuvMedias;
        this.cuvRapidas = cuvRapidas;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(final String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(final String pais) {
        this.pais = pais;
    }
    
    public byte[] getTrazado() {
        return this.trazado;
    }
    
    public void setTrazado(final byte[] trazado) {
        this.trazado = trazado;
    }
    
    public int getNumVueltas() {
        return this.numVueltas;
    }
    
    public void setNumVueltas(final int numVueltas) {
        this.numVueltas = numVueltas;
    }
    
    public int getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(final int longitud) {
        this.longitud = longitud;
    }
    
    public int getCuvLentas() {
        return this.cuvLentas;
    }
    
    public void setCuvLentas(final int cuvLentas) {
        this.cuvLentas = cuvLentas;
    }
    
    public int getCuvMedias() {
        return this.cuvMedias;
    }
    
    public void setCuvMedias(final int cuvMedias) {
        this.cuvMedias = cuvMedias;
    }
    
    public int getCuvRapidas() {
        return this.cuvRapidas;
    }
    
    public void setCuvRapidas(final int cuvRapidas) {
        this.cuvRapidas = cuvRapidas;
    }
}