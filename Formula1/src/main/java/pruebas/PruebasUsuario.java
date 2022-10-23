package pruebas;

import db.PostgreUsuario;

public class PruebasUsuario
{
    public static void main(final String[] args) {
        try {
            PostgreUsuario.getInstance().recuperar("Usuario Prueba");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}