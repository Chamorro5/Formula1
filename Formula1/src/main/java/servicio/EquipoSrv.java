package servicio;

import java.util.stream.Collectors;
import db.PostgrePiloto;
import entidad.Piloto;
import java.util.List;
import db.PostgreParrilla;
import db.PostgreEquipo;
import entidad.Equipo;

public class EquipoSrv
{
    private static EquipoSrv equipoSrv;
    
    static {
        EquipoSrv.equipoSrv = null;
    }
    
    private EquipoSrv() {
    }
    
    public static EquipoSrv getInstance() {
        if (EquipoSrv.equipoSrv == null) {
            EquipoSrv.equipoSrv = new EquipoSrv();
        }
        return EquipoSrv.equipoSrv;
    }
    
    public boolean alta(final Equipo equipo) {
        final Integer iAlta = PostgreEquipo.getInstance().alta(equipo);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Equipo equipo) {
        final Integer iModificacion = PostgreEquipo.getInstance().modificar(equipo);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Equipo getById(final String nombre) {
        final Equipo equipo = PostgreEquipo.getInstance().recuperar(nombre);
        final List<String> lSiglasPilotos = PostgreParrilla.getInstance().recuperarSiglasPilotos(nombre, 2022);
        final List<Piloto> lPilotos = lSiglasPilotos.stream().map(p -> PostgrePiloto.getInstance().recuperar(p)).collect(Collectors.toList());
        equipo.setPilotos(lPilotos);
        return equipo;
    }
    
    public Equipo getById(final String nombre, final int temporada) {
        final Equipo equipo = PostgreEquipo.getInstance().recuperar(nombre);
        final List<String> lSiglasPilotos = PostgreParrilla.getInstance().recuperarSiglasPilotos(nombre, temporada);
        final List<Piloto> lPilotos = lSiglasPilotos.stream().map(p -> PilotoSrv.getInstance().getById(p)).collect(Collectors.toList());
        equipo.setPilotos(lPilotos);
        return equipo;
    }
}