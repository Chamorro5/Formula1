package db;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;
import entidad.Votacion;
import java.sql.Connection;

public class PostgreVotacion extends PostgreConexion
{
    private static PostgreVotacion postgreVotacion;
    public Connection conn;
    
    static {
        PostgreVotacion.postgreVotacion = null;
    }
    
    private PostgreVotacion() {
        this.conn = this.connect();
    }
    
    public static PostgreVotacion getInstance() {
        if (PostgreVotacion.postgreVotacion == null) {
            PostgreVotacion.postgreVotacion = new PostgreVotacion();
        }
        return PostgreVotacion.postgreVotacion;
    }
    
    public int alta(final Votacion votacion) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.votacion(permalink, titulo, descripcion, limite) VALUES (?, ?, ?, ?);");
            stmt.setString(1, votacion.getPermalink());
            stmt.setString(2, votacion.getTitulo());
            stmt.setString(3, votacion.getDescripcion());
            stmt.setDate(4, new Date(votacion.getFecha().getTime()));
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Votacion recuperar(final String permalink) throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT titulo, descripcion, limite FROM public.votacion WHERE permalink = ?;");
            stmt.setString(1, permalink);
            final ResultSet rs = stmt.executeQuery();
            final Votacion votacion = new Votacion();
            if (rs.next()) {
                votacion.setTitulo(rs.getString(1));
                votacion.setDescripcion(rs.getString(2));
                votacion.setFecha((java.util.Date)rs.getDate(3));
                votacion.setPermalink(permalink);
                System.out.println(String.valueOf(permalink) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return votacion;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public int modificar(final Votacion votacion) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.votacion SET titulo=?, descripcion=?, limite=? WHERE permalink=?;");
            stmt.setString(1, votacion.getTitulo());
            stmt.setString(2, votacion.getDescripcion());
            stmt.setDate(3, new Date(votacion.getFecha().getTime()));
            stmt.setString(4, votacion.getPermalink());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}