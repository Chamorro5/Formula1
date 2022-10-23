package servicio;

import db.PostgreCoche;
import entidad.Coche;

public class CocheSrv
{
    private static CocheSrv cocheSrv;
    
    static {
        CocheSrv.cocheSrv = null;
    }
    
    private CocheSrv() {
    }
    
    public static CocheSrv getInstance() {
        if (CocheSrv.cocheSrv == null) {
            CocheSrv.cocheSrv = new CocheSrv();
        }
        return CocheSrv.cocheSrv;
    }
    
    public boolean alta(final Coche coche) {
        final Integer iAlta = PostgreCoche.getInstance().alta(coche);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Coche coche) {
        final Integer iModificacion = PostgreCoche.getInstance().modificar(coche);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Coche getById(final String codigo) {
        return PostgreCoche.getInstance().recuperar(codigo);
    }
}