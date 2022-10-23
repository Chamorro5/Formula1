package web;

import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;
import servicio.CircuitoSrv;
import entidad.Circuito;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/CircuitoServ" })
public class CircuitoServ extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String nombre = request.getParameter("nombre");
        final String ciudad = request.getParameter("ciudad");
        final String pais = request.getParameter("pais");
        final String sNumVueltas = request.getParameter("numVueltas");
        final String sLongitud = request.getParameter("longitud");
        final String sCuvLentas = request.getParameter("cuvLentas");
        final String sCuvMedias = request.getParameter("cuvMedias");
        final String sCuvRapidas = request.getParameter("usuario");
        final Part pTrazado = request.getPart("imagenTrazado");
        if (nombre.isEmpty() || ciudad.isEmpty() || pais.isEmpty() || sNumVueltas.isEmpty() || sLongitud.isEmpty() || sCuvLentas.isEmpty() || sCuvMedias.isEmpty() || sCuvRapidas.isEmpty() || pTrazado.getSize() == 0L || pTrazado.getSize() > 500000L) {
            final RequestDispatcher req = request.getRequestDispatcher("/LoggedGestionCircuitos.jsp");
            req.include((ServletRequest)request, (ServletResponse)response);
        }
        else {
            try {
                final Circuito circuito = new Circuito();
                circuito.setNombre(nombre);
                circuito.setCiudad(ciudad);
                circuito.setPais(pais);
                circuito.setNumVueltas(Integer.parseInt(sNumVueltas));
                circuito.setLongitud(Integer.parseInt(sLongitud));
                circuito.setCuvLentas(Integer.parseInt(sCuvLentas));
                circuito.setCuvMedias(Integer.parseInt(sCuvMedias));
                circuito.setCuvRapidas(Integer.parseInt(sCuvRapidas));
                final InputStream isTrazado = pTrazado.getInputStream();
                circuito.setTrazado(null);
                CircuitoSrv.getInstance().alta(circuito);
                response.sendRedirect("/Formula1/LoggedGestionCircuitos.jsp");
            }
            catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", (Object)e.getMessage());
                final RequestDispatcher req2 = request.getRequestDispatcher("/LoggedGestionCircuitos.jsp");
                req2.include((ServletRequest)request, (ServletResponse)response);
            }
        }
    }
}