package web;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import entidad.UsuarioRegistrado;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;

@WebFilter({ "/*" })
public class UserCheckFilter implements Filter
{
    public void destroy() {
    }
    
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        request.setAttribute("origin", (Object)httpServletRequest.getRequestURI());
        final HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") == null) {
            httpServletRequest.getSession().invalidate();
        }
        if (httpServletRequest.getRequestURI().contains("NoticiaWeb")) {
            chain.doFilter(request, response);
            return;
        }
        if (httpServletRequest.getRequestURI().contains("Logged") && httpServletRequest.getSession(false) == null) {
            final RequestDispatcher dispatcher = httpServletRequest.getServletContext().getRequestDispatcher("/PaginaLogin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
    
    public void init(final FilterConfig fConfig) throws ServletException {
    }
}