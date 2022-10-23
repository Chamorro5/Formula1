package db;

import java.sql.ResultSet;
import entidad.Votacion;
import entidad.OpcionVotacion;
import entidad.UsuarioRegistrado;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import entidad.Voto;
import java.sql.Connection;

public class PostgreVoto extends PostgreConexion
{
    private static PostgreVoto PostgreVoto;
    public Connection conn;
    
    static {
        db.PostgreVoto.PostgreVoto = null;
    }
    
    private PostgreVoto() {
        this.conn = this.connect();
    }
    
    public static PostgreVoto getInstance() {
        if (db.PostgreVoto.PostgreVoto == null) {
            db.PostgreVoto.PostgreVoto = new PostgreVoto();
        }
        return db.PostgreVoto.PostgreVoto;
    }
    
    public int alta(final Voto voto) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.voto(idusuario, permalink, idvotacionopcion) VALUES (?, ?, ?);");
            stmt.setString(1, voto.getUsuario().getUsuario());
            stmt.setString(2, voto.getOpVotacion().getVotacion().getPermalink());
            stmt.setInt(3, voto.getOpVotacion().getId());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public List<Voto> recuperar(final String permalink) throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT idusuario, , idvotacionopcion FROM public.voto WHERE permalink = ?;");
            stmt.setString(1, permalink);
            final ResultSet rs = stmt.executeQuery();
            final List<Voto> lVotos = new ArrayList<Voto>();
            while (rs.next()) {
                final Voto voto = new Voto();
                final UsuarioRegistrado usu = new UsuarioRegistrado();
                usu.setUsuario(rs.getString(1));
                voto.setUsuario(usu);
                final OpcionVotacion<Object> opVotacion = (OpcionVotacion<Object>)new OpcionVotacion();
                final Votacion votacion = new Votacion();
                votacion.setPermalink(permalink);
                opVotacion.setId(rs.getInt(3));
                voto.setOpVotacion((OpcionVotacion)opVotacion);
                lVotos.add(voto);
                System.out.println(String.valueOf(permalink) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return lVotos;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public int modificar(final Voto voto) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.voto SET idvotacionopcion = ? WHERE idusuario = ? AND permalink = ?;");
            stmt.setInt(1, voto.getOpVotacion().getId());
            stmt.setString(2, voto.getUsuario().getUsuario());
            stmt.setString(3, voto.getOpVotacion().getVotacion().getPermalink());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}