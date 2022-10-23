package db;

import entidad.Voto;
import java.sql.ResultSet;
import entidad.Votacion;
import java.util.ArrayList;
import java.util.List;
import entidad.Coche;
import entidad.Equipo;
import entidad.Piloto;
import java.sql.PreparedStatement;
import entidad.Entidad;
import entidad.OpcionVotacion;
import java.sql.Connection;

public class PostgreOpcionVotacion extends PostgreConexion
{
    private static PostgreOpcionVotacion PostgreOpcionVotacion;
    public Connection conn;
    
    static {
        db.PostgreOpcionVotacion.PostgreOpcionVotacion = null;
    }
    
    private PostgreOpcionVotacion() {
        this.conn = this.connect();
    }
    
    public static PostgreOpcionVotacion getInstance() {
        if (db.PostgreOpcionVotacion.PostgreOpcionVotacion == null) {
            db.PostgreOpcionVotacion.PostgreOpcionVotacion = new PostgreOpcionVotacion();
        }
        return db.PostgreOpcionVotacion.PostgreOpcionVotacion;
    }
    
    public int alta(final OpcionVotacion<Entidad> opcionVotacion) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.votacionopciones (permalink, tabladato, referencia, cantidad, id) VALUES (?, ?, ?, ?, ?);");
            stmt.setString(1, opcionVotacion.getVotacion().getPermalink());
            stmt.setString(2, this.obtenerTablaDato(opcionVotacion));
            stmt.setString(3, this.obtenerReferenciaTablaDato(opcionVotacion));
            stmt.setInt(4, opcionVotacion.getCantidad());
            stmt.setInt(5, opcionVotacion.getId());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    private String obtenerTablaDato(final OpcionVotacion<Entidad> opcionVotacion) {
        String sTablaDato;
        if (opcionVotacion.getOpcion() instanceof Piloto) {
            sTablaDato = "piloto";
        }
        else if (opcionVotacion.getOpcion() instanceof Equipo) {
            sTablaDato = "equipo";
        }
        else if (opcionVotacion.getOpcion() instanceof Coche) {
            sTablaDato = "coche";
        }
        else {
            sTablaDato = "";
        }
        return sTablaDato;
    }
    
    private String obtenerReferenciaTablaDato(final OpcionVotacion<Entidad> opcionVotacion) {
        String sReferenciaTablaDato;
        if (opcionVotacion.getOpcion() instanceof Piloto) {
            sReferenciaTablaDato = ((Piloto)opcionVotacion.getOpcion()).getSiglas();
        }
        else if (opcionVotacion.getOpcion() instanceof Equipo) {
            sReferenciaTablaDato = ((Equipo)opcionVotacion.getOpcion()).getNombre();
        }
        else if (opcionVotacion.getOpcion() instanceof Coche) {
            sReferenciaTablaDato = ((Coche)opcionVotacion.getOpcion()).getNombre();
        }
        else {
            sReferenciaTablaDato = "";
        }
        return sReferenciaTablaDato;
    }
    
    public List<OpcionVotacion<Entidad>> recuperar(final String permalink) throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT tabladato, referencia, cantidad, id FROM public.votacionopciones WHERE permalink = ?;");
            stmt.setString(1, permalink);
            final ResultSet rs = stmt.executeQuery();
            final List<OpcionVotacion<Entidad>> lOpcionVotacion = new ArrayList<OpcionVotacion<Entidad>>();
            while (rs.next()) {
                final OpcionVotacion<Entidad> opVotacion = this.crearOpcionVotacion(rs.getString(1), rs.getString(2));
                opVotacion.setCantidad(rs.getInt(3));
                final Votacion votacion = new Votacion();
                votacion.setPermalink(permalink);
                opVotacion.setVotacion(votacion);
                opVotacion.setId(rs.getInt(5));
                lOpcionVotacion.add(opVotacion);
                System.out.println(String.valueOf(permalink) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return lOpcionVotacion;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    private OpcionVotacion<Entidad> crearOpcionVotacion(final String tabladato, final String id) {
        switch (tabladato) {
            case "equipo": {
                final OpcionVotacion<Entidad> opVotacion = (OpcionVotacion<Entidad>)new OpcionVotacion();
                final Equipo equipo = new Equipo();
                equipo.setNombre(id);
                opVotacion.setOpcion(equipo);
                return opVotacion;
            }
            case "piloto": {
                final OpcionVotacion<Entidad> opVotacion = (OpcionVotacion<Entidad>)new OpcionVotacion();
                final Piloto piloto = new Piloto();
                piloto.setSiglas(id);
                opVotacion.setOpcion(piloto);
                return opVotacion;
            }
            case "coche": {
                final OpcionVotacion<Entidad> opVotacion = (OpcionVotacion<Entidad>)new OpcionVotacion();
                final Coche coche = new Coche();
                coche.setCodigo(id);
                opVotacion.setOpcion(coche);
                return opVotacion;
            }
            default:
                break;
        }
        final OpcionVotacion<Entidad> opVotacion = null;
        return opVotacion;
    }
    
    public int modificar(final OpcionVotacion<Entidad> opcionVotacion) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.votacionopciones SET permalink=?, tabladato=?, referencia=?, cantidad=? WHERE id=?;");
            stmt.setString(1, opcionVotacion.getVotacion().getPermalink());
            stmt.setString(2, this.obtenerTablaDato(opcionVotacion));
            stmt.setString(3, this.obtenerReferenciaTablaDato(opcionVotacion));
            stmt.setInt(4, opcionVotacion.getCantidad());
            stmt.setInt(5, opcionVotacion.getId());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public int sumarVoto(final Voto voto) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.votacionopciones SET cantidad = cantidad + 1 WHERE id = ?;");
            stmt.setInt(1, voto.getOpVotacion().getId());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}