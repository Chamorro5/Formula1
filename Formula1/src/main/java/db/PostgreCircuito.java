package db;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entidad.Circuito;
import java.sql.Connection;

public class PostgreCircuito extends PostgreConexion
{
    private static PostgreCircuito postgreCircuito;
    public Connection conn;
    
    static {
        PostgreCircuito.postgreCircuito = null;
    }
    
    private PostgreCircuito() {
        this.conn = this.connect();
    }
    
    public static PostgreCircuito getInstance() {
        if (PostgreCircuito.postgreCircuito == null) {
            PostgreCircuito.postgreCircuito = new PostgreCircuito();
        }
        return PostgreCircuito.postgreCircuito;
    }
    
    public int alta(final Circuito circuito) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.circuito (nombre, ciudad, pais, trazado, numlaps, longitud, slowturns, mediumturns, fastturns) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, circuito.getNombre());
            stmt.setString(2, circuito.getCiudad());
            stmt.setString(3, circuito.getPais());
            stmt.setBytes(4, circuito.getTrazado());
            stmt.setInt(5, circuito.getLongitud());
            stmt.setInt(6, circuito.getNumVueltas());
            stmt.setInt(7, circuito.getCuvLentas());
            stmt.setInt(8, circuito.getCuvMedias());
            stmt.setInt(9, circuito.getCuvRapidas());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Circuito recuperar(final String siglas) throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT ciudad, pais, trazado, numlaps, longitud, slowturns, mediumturns, fastturns FROM public.circuito WHERE nombre=?;");
            stmt.setString(1, siglas);
            final ResultSet rs = stmt.executeQuery();
            final Circuito circuito = new Circuito();
            if (rs.next()) {
                circuito.setCiudad(rs.getString(1));
                circuito.setPais(rs.getString(2));
                circuito.setTrazado(rs.getBytes(3));
                circuito.setNumVueltas(rs.getInt(4));
                circuito.setLongitud(rs.getInt(5));
                circuito.setCuvLentas(rs.getInt(6));
                circuito.setCuvMedias(rs.getInt(7));
                circuito.setCuvRapidas(rs.getInt(8));
                circuito.setNombre(siglas);
                System.out.println(String.valueOf(siglas) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return circuito;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public List<Circuito> recuperarTodos() throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT ciudad, pais, trazado, numlaps, longitud, slowturns, mediumturns, fastturns, nombre FROM public.circuito;");
            final ResultSet rs = stmt.executeQuery();
            final List<Circuito> lCircuito = new ArrayList<Circuito>();
            while (rs.next()) {
                final Circuito circuito = new Circuito();
                circuito.setCiudad(rs.getString(1));
                circuito.setPais(rs.getString(2));
                circuito.setTrazado(rs.getBytes(3));
                circuito.setNumVueltas(rs.getInt(4));
                circuito.setLongitud(rs.getInt(5));
                circuito.setCuvLentas(rs.getInt(6));
                circuito.setCuvMedias(rs.getInt(7));
                circuito.setCuvRapidas(rs.getInt(8));
                circuito.setNombre(rs.getString(9));
                lCircuito.add(circuito);
                System.out.println(String.valueOf(rs.getString(9)) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            return lCircuito;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public int modificar(final Circuito circuito) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.circuito SET ciudad=?, pais=?, trazado=?, numlaps=?, longitud=?, slowturns=?, mediumturns=?, fastturns=? WHERE nombre=?;");
            stmt.setString(1, circuito.getCiudad());
            stmt.setString(2, circuito.getPais());
            stmt.setBytes(3, circuito.getTrazado());
            stmt.setInt(4, circuito.getLongitud());
            stmt.setInt(5, circuito.getNumVueltas());
            stmt.setInt(6, circuito.getCuvLentas());
            stmt.setInt(7, circuito.getCuvMedias());
            stmt.setInt(8, circuito.getCuvRapidas());
            stmt.setString(9, circuito.getNombre());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}