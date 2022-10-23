package entidad;

import enums.EnumRol;

public class UsuarioRegistrado
{
    String nombre;
    String usuario;
    String email;
    String contrase\u00f1a;
    EnumRol rol;
    
    public UsuarioRegistrado() {
        this.nombre = "";
        this.usuario = "";
        this.email = "";
        this.contrase\u00f1a = "";
        this.rol = null;
    }
    
    public UsuarioRegistrado(final String nombre, final String usuario, final String email, final String contrase\u00f1a, final EnumRol rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.contrase\u00f1a = contrase\u00f1a;
        this.rol = rol;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getContrase\u00f1a() {
        return this.contrase\u00f1a;
    }
    
    public void setContrase\u00f1a(final String contrase\u00f1a) {
        this.contrase\u00f1a = contrase\u00f1a;
    }
    
    public EnumRol getRol() {
        return this.rol;
    }
    
    public void setRol(final EnumRol rol) {
        this.rol = rol;
    }
}