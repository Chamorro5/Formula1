package entidad;

public class Noticia
{
    private String permalink;
    private String titulo;
    private byte[] imagen;
    private String texto;
    
    public Noticia() {
        this.permalink = "";
        this.titulo = "";
        this.imagen = null;
        this.texto = "";
    }
    
    public Noticia(final String permalink, final String titulo, final byte[] imagen, final String texto) {
        this.permalink = permalink;
        this.titulo = titulo;
        this.imagen = imagen;
        this.texto = texto;
    }
    
    public String getPermalink() {
        return this.permalink;
    }
    
    public void setPermalink(final String permalink) {
        this.permalink = permalink;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }
    
    public byte[] getImagen() {
        return this.imagen;
    }
    
    public void setImagen(final byte[] imagen) {
        this.imagen = imagen;
    }
    
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(final String texto) {
        this.texto = texto;
    }
}