package entidad;

public class OpcionVotacion<Entidad>
{
    private int id;
    private Votacion votacion;
    private Entidad opcion;
    private int cantidad;
    
    public OpcionVotacion() {
        this.setId(0);
        this.votacion = null;
        this.opcion = null;
        this.cantidad = 0;
    }
    
    public OpcionVotacion(final int id, final Votacion votacion, final Entidad opcion, final int cantidad) {
        this.setId(id);
        this.votacion = votacion;
        this.opcion = opcion;
        this.cantidad = cantidad;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public Votacion getVotacion() {
        return this.votacion;
    }
    
    public void setVotacion(final Votacion votacion) {
        this.votacion = votacion;
    }
    
    public Entidad getOpcion() {
        return this.opcion;
    }
    
    public void setOpcion(Entidad opcion) {
        this.opcion = opcion;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}