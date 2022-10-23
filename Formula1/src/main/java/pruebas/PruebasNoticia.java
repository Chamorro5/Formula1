package pruebas;

import java.util.Iterator;
import java.util.List;
import entidad.Noticia;
import servicio.NoticiaSrv;

public class PruebasNoticia
{
    public static void main(final String[] args) {
        try {
            final List<Noticia> lNoticia = (List<Noticia>)NoticiaSrv.getInstance().getAll();
            for (final Noticia noticia : lNoticia) {
                System.out.println(noticia.getPermalink());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}