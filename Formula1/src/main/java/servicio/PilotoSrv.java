package servicio;

import db.PostgreParrilla;
import db.PostgrePiloto;
import entidad.Piloto;

public class PilotoSrv
{
    private static PilotoSrv pilotoSrv;
    
    static {
        PilotoSrv.pilotoSrv = null;
    }
    
    private PilotoSrv() {
    }
    
    public static PilotoSrv getInstance() {
        if (PilotoSrv.pilotoSrv == null) {
            PilotoSrv.pilotoSrv = new PilotoSrv();
        }
        return PilotoSrv.pilotoSrv;
    }
    
    public boolean alta(final Piloto piloto) {
        final Integer iAlta = PostgrePiloto.getInstance().alta(piloto);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Piloto piloto) {
        final Integer iModificacion = PostgrePiloto.getInstance().modificar(piloto);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Piloto getById(final String siglas) {
        final Piloto piloto = PostgrePiloto.getInstance().recuperar(siglas);
        final String nombreEquipo = PostgreParrilla.getInstance().recuperarNombreEquipo(siglas, 2022);
        piloto.setEquipo(EquipoSrv.getInstance().getById(nombreEquipo));
        return piloto;
    }
}