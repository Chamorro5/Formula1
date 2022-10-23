package enums;

public enum EnumRol
{
    AFICIONADOS("AFICIONADOS", 0, "AFICI", "Aficionados"), 
    RESPONSABLE_EQUIPOS("RESPONSABLE_EQUIPOS", 1, "RESEQ", "Responsable equipos"), 
    ADMINISTRADOR("ADMINISTRADOR", 2, "ADMIN", "Administrador");
    
    String codigo;
    String descripcion;
    
    private EnumRol(final String name, final int ordinal, final String codigo, final String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public static EnumRol getByCodigo(final String id) {
        EnumRol[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final EnumRol e = values[i];
            if (e.codigo.equals(id)) {
                return e;
            }
        }
        return EnumRol.AFICIONADOS;
    }
}