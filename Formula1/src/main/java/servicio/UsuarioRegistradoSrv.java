package servicio;

import java.util.List;
import java.sql.SQLException;
import db.PostgreUsuario;
import entidad.UsuarioRegistrado;

public class UsuarioRegistradoSrv
{
    private static UsuarioRegistradoSrv usuarioSrv;
    
    static {
        UsuarioRegistradoSrv.usuarioSrv = null;
    }
    
    private UsuarioRegistradoSrv() {
    }
    
    public static UsuarioRegistradoSrv getInstance() {
        if (UsuarioRegistradoSrv.usuarioSrv == null) {
            UsuarioRegistradoSrv.usuarioSrv = new UsuarioRegistradoSrv();
        }
        return UsuarioRegistradoSrv.usuarioSrv;
    }
    
    public boolean alta(final UsuarioRegistrado usuario) throws SQLException {
        final Integer iAlta = PostgreUsuario.getInstance().alta(usuario);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final UsuarioRegistrado usuario) {
        final Integer iModificacion = PostgreUsuario.getInstance().modificar(usuario);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public UsuarioRegistrado getById(final String id) {
        return PostgreUsuario.getInstance().recuperar(id);
    }
    
    public List<UsuarioRegistrado> getAll() throws Exception {
        return PostgreUsuario.getInstance().recuperarTodos();
    }
}