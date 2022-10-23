package db;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entidad.Equipo;
import java.sql.Connection;

public class PostgreEquipo extends PostgreConexion
{
    private static PostgreEquipo postgreEquipo;
    public Connection conn;
    
    static {
        PostgreEquipo.postgreEquipo = null;
    }
    
    private PostgreEquipo() {
        this.conn = this.connect();
    }
    
    public static PostgreEquipo getInstance() {
        if (PostgreEquipo.postgreEquipo == null) {
            PostgreEquipo.postgreEquipo = new PostgreEquipo();
        }
        return PostgreEquipo.postgreEquipo;
    }
    
    public int alta(final Equipo equipo) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.equipo(nombre, logo, twitter) VALUES (?, ?, ?);");
            stmt.setString(1, equipo.getNombre());
            stmt.setBytes(2, equipo.getLogo());
            stmt.setString(3, equipo.getTwitter());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Equipo recuperar(final String nombre) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT logo, twitter FROM public.equipo WHERE nombre = ?;");
            stmt.setString(1, nombre);
            final ResultSet rs = stmt.executeQuery();
            final Equipo equipo = new Equipo();
            if (rs.next()) {
                equipo.setNombre(nombre);
                equipo.setLogo(rs.getBytes(1));
                equipo.setTwitter(rs.getString(2));
                System.out.println(String.valueOf(nombre) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return equipo;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public int modificar(final Equipo equipo) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.equipo SET logo=?, twitter=? WHERE nombre=?;");
            stmt.setBytes(1, equipo.getLogo());
            stmt.setString(2, equipo.getTwitter());
            stmt.setString(3, equipo.getNombre());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}