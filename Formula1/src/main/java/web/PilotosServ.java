package web;

import entidad.UsuarioRegistrado;
import javax.servlet.RequestDispatcher;
import enums.EnumRol;
import servicio.UsuarioRegistradoSrv;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/PilotosServ" })
public class PilotosServ extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String usuario = request.getParameter("usuario");
        final String rol = request.getParameter("rol");
        if (usuario.isEmpty() || rol.isEmpty()) {
            final RequestDispatcher req = request.getRequestDispatcher("/LoggedGestionUsuarios.jsp");
            req.include((ServletRequest)request, (ServletResponse)response);
        }
        else {
            try {
                final UsuarioRegistrado usuarioRegistro = UsuarioRegistradoSrv.getInstance().getById(usuario);
                usuarioRegistro.setRol(EnumRol.getByCodigo(rol));
                UsuarioRegistradoSrv.getInstance().modificacion(usuarioRegistro);
                response.sendRedirect("/Formula1/LoggedGestionUsuarios.jsp");
            }
            catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", (Object)e.getMessage());
                final RequestDispatcher req2 = request.getRequestDispatcher("/LoggedGestionUsuarios.jsp");
                req2.include((ServletRequest)request, (ServletResponse)response);
            }
        }
    }
}