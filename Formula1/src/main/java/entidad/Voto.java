package entidad;

public class Voto
{
    private UsuarioRegistrado usuario;
    private OpcionVotacion<?> opVotacion;
    
    public Voto() {
        this.usuario = null;
        this.opVotacion = null;
    }
    
    public Voto(final UsuarioRegistrado usuario, final OpcionVotacion<?> opVotacion) {
        this.usuario = usuario;
        this.opVotacion = opVotacion;
    }
    
    public UsuarioRegistrado getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(final UsuarioRegistrado usuario) {
        this.usuario = usuario;
    }
    
    public OpcionVotacion<?> getOpVotacion() {
        return this.opVotacion;
    }
    
    public void setOpVotacion(final OpcionVotacion<?> opVotacion) {
        this.opVotacion = opVotacion;
    }
}