package entidad;

public class Coche extends Entidad
{
    private String nombre;
    private String codigo;
    private double ersSlowTurns;
    private double ersMediumTurns;
    private double ersFastTurns;
    private double consumo;
    
    public Coche() {
        this.nombre = "";
        this.codigo = "";
        this.ersSlowTurns = -1.0;
        this.ersMediumTurns = -1.0;
        this.ersFastTurns = -1.0;
        this.consumo = -1.0;
    }
    
    public Coche(final String nombre, final String codigo, final double ersSlowTurns, final double ersMediumTurns, final double ersFastTurns, final double consumo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ersSlowTurns = ersSlowTurns;
        this.ersMediumTurns = ersMediumTurns;
        this.ersFastTurns = ersFastTurns;
        this.consumo = consumo;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
    
    public double getErsSlowTurns() {
        return this.ersSlowTurns;
    }
    
    public void setErsSlowTurns(final double ersSlowTurns) {
        this.ersSlowTurns = ersSlowTurns;
    }
    
    public double getErsMediumTurns() {
        return this.ersMediumTurns;
    }
    
    public void setErsMediumTurns(final double ersMediumTurns) {
        this.ersMediumTurns = ersMediumTurns;
    }
    
    public double getErsFastTurns() {
        return this.ersFastTurns;
    }
    
    public void setErsFastTurns(final double ersFastTurns) {
        this.ersFastTurns = ersFastTurns;
    }
    
    public double getConsumo() {
        return this.consumo;
    }
    
    public void setConsumo(final double consumo) {
        this.consumo = consumo;
    }
}