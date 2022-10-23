package web;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import entidad.Noticia;
import javax.servlet.http.HttpSession;
import servicio.NoticiaSrv;
import entidad.UsuarioRegistrado;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/Noticia" })
public class NoticiaWeb extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final UsuarioRegistrado user = (UsuarioRegistrado)session.getAttribute("user");
        request.setAttribute("user", (Object)user);
        final String idNoticia = request.getParameter("id");
        Noticia noticia = null;
        try {
            noticia = NoticiaSrv.getInstance().getById(idNoticia);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final PrintWriter out = response.getWriter();
        this.inicioWeb(noticia, out);
        if (noticia != null) {
            out.write("<body> ");
            if (user != null) {
                out.write("Sesion actual:" + user.getNombre() + "\r\n" + "\r\n" + "<br>    <a href=\"logout\">logout</a>" + "<br>    <a href=\"LoggedIndex.jsp\">Volver</a>");
            }
            else {
                out.write("<a href=\"Principal.jsp\">Volver</a>");
            }
            out.write("<h1>" + noticia.getTitulo() + "</h1>" + "<div class=\"square\">\r\n" + "    <div>\r\n" + "     <img src=\"data:image/jpeg;base64," + new String(noticia.getImagen()) + "\"/>" + "    </div>\r\n" + "      \r\n" + "<p>" + noticia.getTexto() + "</p>\r\n" + "  \r\n" + "  </div>");
        }
        else {
            out.write("<body><h1> No se ha podido recuperar correctamente la noticia.</h1>");
        }
        this.cerrarWeb(out);
    }
    
    private void inicioWeb(final Noticia noticia, final PrintWriter out) {
        final String titulo = (noticia != null) ? noticia.getTitulo() : "Error al recuperar noticia";
        out.write("<!DOCTYPE html>\r\n<html>\r\n<head>\r\n  <title>" + titulo + "</title>\r\n" + "  <style>\r\n" + "    body {\r\n" + "      margin: 1em;\r\n" + "      text-align: center;\r\n" + "    }\r\n" + "  \r\n" + "    h1 {\r\n" + "      color: red;\r\n" + "    }\r\n" + "  \r\n" + "    img {\r\n" + "      float: left;\r\n" + "      margin: 0.8em;\r\n" + "\t\t max-height:45em;\r\n" + "      max-width:45em;\r\n" + "      height:auto;\r\n" + "      width:auto;" + "    }\r\n" + "  \r\n" + "    p {\r\n" + "      text-align: justify;\r\n" + "      font-size: 25px;\r\n" + "    }\r\n" + "  </style>\r\n" + "</head>");
    }
    
    private void cerrarWeb(final PrintWriter out) {
        out.write("</body>\r\n</html>");
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}