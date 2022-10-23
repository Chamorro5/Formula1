package web;

import javax.servlet.http.HttpSession;
import entidad.UsuarioRegistrado;
import servicio.UsuarioRegistradoSrv;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/login" })
public class UserCheckLoginServlet extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String referer = (String)request.getAttribute("origin");
        request.setAttribute("origin", (Object)referer);
        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaLogin.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String key = request.getParameter("name");
        final String pass = request.getParameter("password");
        final UsuarioRegistrado user = UsuarioRegistradoSrv.getInstance().getById(key);
        if (!user.getContrase\u00f1a().equals(pass)) {
            request.setAttribute("error", (Object)"invalid login");
            final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaLogin.jsp");
            dispatcher.forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        final HttpSession session = request.getSession(true);
        session.setAttribute("user", (Object)user);
        session.setAttribute("idUser", (Object)user.getNombre());
        response.sendRedirect("/Formula1/LoggedIndex.jsp");
    }
}