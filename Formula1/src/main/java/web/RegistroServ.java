package web;

import javax.servlet.RequestDispatcher;
import servicio.UsuarioRegistradoSrv;
import entidad.UsuarioRegistrado;
import enums.EnumRol;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/RegistroServ" })
public class RegistroServ extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String nombre = request.getParameter("nombre");
        final String nombrePublico = request.getParameter("nombrePublico");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        if (nombre.isEmpty() || nombrePublico.isEmpty() || email.isEmpty() || password.isEmpty()) {
            final RequestDispatcher req = request.getRequestDispatcher("/Registro.jsp");
            req.include((ServletRequest)request, (ServletResponse)response);
        }
        else {
            try {
                final UsuarioRegistrado usuarioRegistro = new UsuarioRegistrado(nombre, nombrePublico, email, password, EnumRol.AFICIONADOS);
                UsuarioRegistradoSrv.getInstance().alta(usuarioRegistro);
                response.sendRedirect("/Formula1/PaginaLogin.jsp");
            }
            catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", (Object)e.getMessage());
                final RequestDispatcher req2 = request.getRequestDispatcher("/Registro.jsp");
                req2.include((ServletRequest)request, (ServletResponse)response);
            }
        }
    }
}