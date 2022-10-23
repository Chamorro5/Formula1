package servicio;

import entidad.Entidad;
import entidad.OpcionVotacion;
import db.PostgreOpcionVotacion;
import db.PostgreVoto;
import entidad.Voto;
import db.PostgreVotacion;
import entidad.Votacion;

public class VotacionSrv
{
    private static VotacionSrv votacionSrv;
    
    static {
        VotacionSrv.votacionSrv = null;
    }
    
    private VotacionSrv() {
    }
    
    public static VotacionSrv getInstance() {
        if (VotacionSrv.votacionSrv == null) {
            VotacionSrv.votacionSrv = new VotacionSrv();
        }
        return VotacionSrv.votacionSrv;
    }
    
    public boolean alta(final Votacion votacion) {
        final Integer iAlta = PostgreVotacion.getInstance().alta(votacion);
        return iAlta > 0 && iAlta != -1;
    }
    
    public boolean modificacion(final Votacion votacion) {
        final Integer iModificacion = PostgreVotacion.getInstance().modificar(votacion);
        return iModificacion > 0 && iModificacion != -1;
    }
    
    public Votacion getById(final String id) throws Exception {
        return PostgreVotacion.getInstance().recuperar(id);
    }
    
    public boolean anyadirVoto(final Voto voto) {
        final boolean bVotos = PostgreVoto.getInstance().alta(voto) == 1;
        final boolean bVotacion = PostgreOpcionVotacion.getInstance().sumarVoto(voto) == 1;
        return bVotos && bVotacion;
    }
    
    public boolean anaydirOpcion(final OpcionVotacion<Entidad> opVotacion) {
        return PostgreOpcionVotacion.getInstance().alta(opVotacion) == 1;
    }
}