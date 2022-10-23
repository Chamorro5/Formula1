package db;

import entidad.Noticia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class PostgreParrilla extends PostgreConexion
{
    private static PostgreParrilla postgreParrilla;
    public Connection conn;
    
    static {
        PostgreParrilla.postgreParrilla = null;
    }
    
    private PostgreParrilla() {
        this.conn = this.connect();
    }
    
    public static PostgreParrilla getInstance() {
        if (PostgreParrilla.postgreParrilla == null) {
            PostgreParrilla.postgreParrilla = new PostgreParrilla();
        }
        return PostgreParrilla.postgreParrilla;
    }
    
    public int anyadirPilotoAEquipo(final String siglasPiloto, final String nombreEquipo, final int temporada) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.parrilla(siglas, nombreequipo, temporada) VALUES (?, ?, ?);");
            stmt.setString(1, siglasPiloto);
            stmt.setString(2, nombreEquipo);
            stmt.setInt(3, temporada);
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public List<String> recuperarSiglasPilotos(final String nombreEquipo, final int temporada) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT siglas FROM public.parrilla WHERE nombreequipo = ? AND temporada = ?;");
            stmt.setString(1, nombreEquipo);
            stmt.setInt(2, temporada);
            final ResultSet rs = stmt.executeQuery();
            final List<String> lPilotos = new ArrayList<String>();
            while (rs.next()) {
                lPilotos.add(rs.getString(1));
                System.out.println(String.valueOf(nombreEquipo) + " " + temporada + " " + rs.getString(1));
            }
            return lPilotos;
        }
        catch (Exception e) {
            return new ArrayList<String>();
        }
    }
    
    public String recuperarNombreEquipo(final String siglasPiloto, final int temporada) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT nombreequipo FROM public.parrilla WHERE siglas = ? AND temporada = ?;");
            stmt.setString(1, siglasPiloto);
            stmt.setInt(2, temporada);
            final ResultSet rs = stmt.executeQuery();
            String nombreEquipo = "";
            while (rs.next()) {
                nombreEquipo = rs.getString(1);
                System.out.println(String.valueOf(siglasPiloto) + " " + temporada + " " + rs.getString(1));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return nombreEquipo;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public int modificar(final Noticia noticia) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.noticia SET titulo=?, imagen=?, texto=? WHERE permalink=?;");
            stmt.setString(1, noticia.getTitulo());
            stmt.setBytes(2, noticia.getImagen());
            stmt.setString(3, noticia.getTexto());
            stmt.setString(4, noticia.getPermalink());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}