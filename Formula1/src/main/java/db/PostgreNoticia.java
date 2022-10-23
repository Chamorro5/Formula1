package db;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import entidad.Noticia;
import java.sql.Connection;

public class PostgreNoticia extends PostgreConexion
{
    private static PostgreNoticia postgreNoticia;
    public Connection conn;
    
    static {
        PostgreNoticia.postgreNoticia = null;
    }
    
    private PostgreNoticia() {
        this.conn = this.connect();
    }
    
    public static PostgreNoticia getInstance() {
        if (PostgreNoticia.postgreNoticia == null) {
            PostgreNoticia.postgreNoticia = new PostgreNoticia();
        }
        return PostgreNoticia.postgreNoticia;
    }
    
    public int alta(final Noticia noticia) {
        int numFilas = -1;
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO public.noticia (permalink, titulo, imagen, texto) VALUES (?, ?, ?, ?);");
            stmt.setString(1, noticia.getPermalink());
            stmt.setString(2, noticia.getTitulo());
            stmt.setBytes(3, noticia.getImagen());
            stmt.setString(4, noticia.getTexto());
            numFilas = stmt.executeUpdate();
            System.out.println(String.valueOf(numFilas) + " records inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return numFilas;
    }
    
    public Noticia recuperar(final String permalink) throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT titulo, imagen, texto FROM public.noticia WHERE permalink = ?;");
            stmt.setString(1, permalink);
            final ResultSet rs = stmt.executeQuery();
            final Noticia noticia = new Noticia();
            if (rs.next()) {
                noticia.setTitulo(rs.getString(1));
                noticia.setImagen(rs.getBytes(2));
                noticia.setTexto(rs.getString(3));
                noticia.setPermalink(permalink);
                System.out.println(String.valueOf(permalink) + " " + rs.getString(1) + " " + rs.getString(2));
            }
            if (rs.next()) {
                throw new Exception("Se han encontrado mas resultados que los esperados.");
            }
            return noticia;
        }
        catch (Exception e) {
            throw e;
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
    
    public List<Noticia> recuperarTodos() throws Exception {
        try {
            final PreparedStatement stmt = this.conn.prepareStatement("SELECT titulo, imagen, texto, permalink FROM public.noticia;");
            final ResultSet rs = stmt.executeQuery();
            final List<Noticia> lNoticia = new ArrayList<Noticia>();
            while (rs.next()) {
                final Noticia noticia = new Noticia();
                noticia.setTitulo(rs.getString(1));
                noticia.setImagen(rs.getBytes(2));
                noticia.setTexto(rs.getString(3));
                noticia.setPermalink(rs.getString(4));
                lNoticia.add(noticia);
                System.out.println(String.valueOf(rs.getString(4)) + " " + rs.getString(1) + " " + rs.getString(2));
                System.out.println(new String(noticia.getImagen()));
            }
            return lNoticia;
        }
        catch (Exception e) {
            throw e;
        }
    }
}