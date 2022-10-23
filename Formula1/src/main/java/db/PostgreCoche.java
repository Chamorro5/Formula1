package db;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entidad.Coche;
import java.sql.Connection;

public class PostgreCoche extends PostgreConexion
{
    private static PostgreCoche postgreCoche;
    public Connection conn;
    
    static {
        PostgreCoche.postgreCoche = null;
    }
    
    private PostgreCoche() {
        this.conn = this.connect();
    }
    
    public static PostgreCoche getInstance() {
        if (PostgreCoche.postgreCoche == null) {
            PostgreCoche.postgreCoche = new PostgreCoche();
        }
        return PostgreCoche.postgreCoche;
    }
    
    public int alta(final Coche coche) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.coche (codigo, nombre, ersslowturns, ersmediumturns, ersfastturns, consumo) VALUES (?, ?, ?, ?, ?, ?);");
            stmt.setString(1, coche.getCodigo());
            stmt.setString(2, coche.getNombre());
            stmt.setDouble(3, coche.getErsSlowTurns());
            stmt.setDouble(4, coche.getErsMediumTurns());
            stmt.setDouble(5, coche.getErsFastTurns());
            stmt.setDouble(6, coche.getConsumo());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Coche recuperar(final String codigo) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT nombre, ersslowturns, ersmediumturns, ersfastturns, consumo FROM public.coche WHERE codigo = ?;");
            stmt.setString(1, codigo);
            final ResultSet rs = stmt.executeQuery();
            final Coche coche = new Coche();
            if (rs.next()) {
                coche.setNombre(rs.getString(1));
                coche.setErsSlowTurns(rs.getDouble(2));
                coche.setErsMediumTurns(rs.getDouble(3));
                coche.setErsFastTurns(rs.getDouble(4));
                coche.setConsumo(rs.getDouble(5));
                coche.setCodigo(codigo);
                System.out.println(String.valueOf(codigo) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return coche;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public int modificar(final Coche coche) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.coche SET nombre=?, ersslowturns=?, ersmediumturns=?, ersfastturns=?, consumo=? WHERE codigo=?;");
            stmt.setString(1, coche.getNombre());
            stmt.setDouble(2, coche.getErsSlowTurns());
            stmt.setDouble(3, coche.getErsMediumTurns());
            stmt.setDouble(4, coche.getErsFastTurns());
            stmt.setDouble(5, coche.getConsumo());
            stmt.setString(6, coche.getCodigo());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}