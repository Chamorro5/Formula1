package db;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import enums.EnumRol;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import entidad.UsuarioRegistrado;
import java.sql.Connection;

public class PostgreUsuario extends PostgreConexion
{
    private static PostgreUsuario postgreUsuario;
    public Connection conn;
    
    static {
        PostgreUsuario.postgreUsuario = null;
    }
    
    private PostgreUsuario() {
        this.conn = this.connect();
    }
    
    public static PostgreUsuario getInstance() {
        if (PostgreUsuario.postgreUsuario == null) {
            PostgreUsuario.postgreUsuario = new PostgreUsuario();
        }
        return PostgreUsuario.postgreUsuario;
    }
    
    public int alta(final UsuarioRegistrado usuario) throws SQLException {
        int numFilas = -1;
        final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.usuarioregistrado(idusuario, nombrepublico, email, password, rol) VALUES (?, ?, ?, ?, ?);");
        stmt.setString(1, usuario.getUsuario());
        stmt.setString(2, usuario.getNombre());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getContraseña());
        stmt.setString(5, usuario.getRol().getCodigo());
        numFilas = stmt.executeUpdate();
        System.out.println(String.valueOf(numFilas) + " records inserted");
        return numFilas;
    }
    
    public UsuarioRegistrado recuperar(final String id) {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT nombrepublico, email, password, rol FROM public.usuarioregistrado where idusuario = ?");
            stmt.setString(1, id);
            final ResultSet rs = stmt.executeQuery();
            final UsuarioRegistrado usu = new UsuarioRegistrado();
            if (rs.next()) {
                usu.setUsuario(id);
                usu.setNombre(rs.getString(1));
                usu.setEmail(rs.getString(2));
                usu.setContraseña(rs.getString(3));
                final EnumRol eRol = EnumRol.getByCodigo(rs.getString(4));
                usu.setRol(eRol);
                System.out.println(String.valueOf(rs.getString(1)) + " " + rs.getString(2) + rs.getString(3) + rs.getString(4));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return usu;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public List<UsuarioRegistrado> recuperarTodos() throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT nombrepublico, email, password, rol, idusuario FROM public.usuarioregistrado");
            final ResultSet rs = stmt.executeQuery();
            final List<UsuarioRegistrado> lUsuario = new ArrayList<UsuarioRegistrado>();
            while (rs.next()) {
                final UsuarioRegistrado usu = new UsuarioRegistrado();
                usu.setNombre(rs.getString(1));
                usu.setEmail(rs.getString(2));
                usu.setContraseña(rs.getString(3));
                final EnumRol eRol = EnumRol.getByCodigo(rs.getString(4));
                usu.setRol(eRol);
                usu.setUsuario(rs.getString(5));
                lUsuario.add(usu);
                System.out.println(String.valueOf(rs.getString(5)) + " " + rs.getString(1) + " " + rs.getString(2) + rs.getString(3) + rs.getString(4));
            }
            return lUsuario;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public int modificar(final UsuarioRegistrado usuario) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("UPDATE public.usuarioregistradotSET nombrepublico=, email=, password=, rol= WHERE idusuario = ?;");
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getRol().getCodigo());
            stmt.setString(5, usuario.getUsuario());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
}