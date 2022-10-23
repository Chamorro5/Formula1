package servicio;

import java.util.List;
import db.PostgreCircuito;
import entidad.Circuito;

public class CircuitoSrv
{
    private static CircuitoSrv circuitoSrv;
    
    static {
        CircuitoSrv.circuitoSrv = null;
    }
    
    private CircuitoSrv() {
    }
    
    public static CircuitoSrv getInstance() {
        if (CircuitoSrv.circuitoSrv == null) {
            CircuitoSrv.circuitoSrv = new CircuitoSrv();
        }
        return CircuitoSrv.circuitoSrv;
    }
    
    public boolean alta(final Circuito circuito) {
        final Integer iAlta = PostgreCircuito.getInstance().alta(circuito);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Circuito circuito) {
        final Integer iModificacion = PostgreCircuito.getInstance().modificar(circuito);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Circuito getById(final String nombre) throws Exception {
        return PostgreCircuito.getInstance().recuperar(nombre);
    }
    
    public List<Circuito> getAll() throws Exception {
        return PostgreCircuito.getInstance().recuperarTodos();
    }
}