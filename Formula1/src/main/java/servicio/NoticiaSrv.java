package servicio;

import java.util.List;
import db.PostgreNoticia;
import entidad.Noticia;

public class NoticiaSrv
{
    private static NoticiaSrv noticiaSrv;
    
    static {
        NoticiaSrv.noticiaSrv = null;
    }
    
    private NoticiaSrv() {
    }
    
    public static NoticiaSrv getInstance() {
        if (NoticiaSrv.noticiaSrv == null) {
            NoticiaSrv.noticiaSrv = new NoticiaSrv();
        }
        return NoticiaSrv.noticiaSrv;
    }
    
    public boolean alta(final Noticia noticia) {
        final Integer iAlta = PostgreNoticia.getInstance().alta(noticia);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Noticia noticia) {
        final Integer iModificacion = PostgreNoticia.getInstance().modificar(noticia);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Noticia getById(final String id) throws Exception {
        return (id != null) ? PostgreNoticia.getInstance().recuperar(id) : null;
    }
    
    public List<Noticia> getAll() throws Exception {
        return PostgreNoticia.getInstance().recuperarTodos();
    }
}