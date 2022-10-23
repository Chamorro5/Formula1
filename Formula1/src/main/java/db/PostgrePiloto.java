package db;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entidad.Piloto;
import java.sql.Connection;

public class PostgrePiloto extends PostgreConexion
{
    private static PostgrePiloto postgrePiloto;
    public Connection conn;
    
    static {
        PostgrePiloto.postgrePiloto = null;
    }
    
    private PostgrePiloto() {
        this.conn = this.connect();
    }
    
    public static PostgrePiloto getInstance() {
        if (PostgrePiloto.postgrePiloto == null) {
            PostgrePiloto.postgrePiloto = new PostgrePiloto();
        }
        return PostgrePiloto.postgrePiloto;
    }
    
    public int alta(final Piloto piloto) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.piloto (nombre, apellidos, siglas, dorsal, foto, pais, twitter) VALUES (?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, piloto.getNombre());
            stmt.setString(2, piloto.getApellidos());
            stmt.setString(3, piloto.getSiglas());
            stmt.setInt(4, piloto.getDorsal());
            stmt.setBytes(5, piloto.getFoto());
            stmt.setString(6, piloto.getPais());
            stmt.setString(7, piloto.getTwitter());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) +  " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Piloto recuperar(final String siglas) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT nombre, apellidos, dorsal, foto, pais, twitter FROM public.piloto WHERE siglas = ?;");
            stmt.setString(1, siglas);
            final ResultSet rs = stmt.executeQuery();
            final Piloto piloto = new Piloto();
            if (rs.next()) {
                piloto.setSiglas(siglas);
                piloto.setNombre(rs.getString(1));
                piloto.setApellidos(rs.getString(2));
                piloto.setDorsal(rs.getInt(3));
                piloto.setFoto(rs.getBytes(4));
                piloto.setPais(rs.getString(5));
                piloto.setTwitter(rs.getString(6));
                System.out.println(String.valueOf(siglas) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return piloto;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public int modificar(final Piloto piloto) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.piloto SET nombre=, apellidos=, dorsal=, foto=, pais=, twitter= WHERE siglas = ?;");
            stmt.setString(1, piloto.getNombre());
            stmt.setString(2, piloto.getApellidos());
            stmt.setInt(3, piloto.getDorsal());
            stmt.setBytes(4, piloto.getFoto());
            stmt.setString(5, piloto.getPais());
            stmt.setString(6, piloto.getTwitter());
            stmt.setString(7, piloto.getSiglas());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) +  " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}