<%@page import="servicio.NoticiaSrv"%>
<%@page import="entidad.Noticia"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
// Create an ArrayList with test data
List<Noticia> lNoticia = NoticiaSrv.getInstance().getAll();
pageContext.setAttribute("noticias", lNoticia);
Map<String, String> lImagenes = new HashMap<>();
for (Noticia noti : lNoticia) {
	lImagenes.put(noti.getPermalink(), new String(noti.getImagen()));
	pageContext.setAttribute(noti.getPermalink(), new String(noti.getImagen()));
}
pageContext.setAttribute("imagenes", lImagenes);
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.row {
  display: flex; /* equal height of the children */
}

.col {
  flex: 1; /* additionally, equal width */
  
  padding: 1em;
  border: solid;
}

#cabecera {
	display: flex;
	justify-content: center;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Principal</title>
</head>
<body>
	
	<div id="cabecera">
		<img src="img/logo.jpg" alt="Logo F1" align="middle" width="700"
			height="400">
	</div>
	<div class="row">
		<div style="background-color: #BCC6CC; width: 66%; display: inline-block;" class="row">
			<table width="100%">
				<c:forEach items="${noticias}" var="noticia">

					<tr>
						<td><a href="Noticia?id=${noticia.permalink}">
								<h2>${noticia.titulo}</h2>
						</a></td>
					</tr>
					<tr>
						<td><img alt="img" style="width: 500px;"
							src="data:image/jpeg;base64,${imagenes[noticia.permalink]}" /></td>
						<td> ${noticia.texto} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="background-color: #E5E4E2; width: 33%; display: inline-block;" class="row">
			<form action="login" method="POST">
				<input type="hidden" name="origin" value="${origin}">
				<c:if test="${not empty error}"> * error: ${error} 
				</c:if>
				<c:choose>
    				<c:when test="${not empty user}">
        				Esta conectado actualmente como : ${user.nombre}
        				<br>
        				<c:choose>
        					<c:when test="${user.rol.codigo == 'ADMIN'}">
        						SOY ADMIN
        						<h5><a href="LoggedGestionUsuarios.jsp">Gestionar Usuarios</a></h5>
        						<h5><a href="LoggedGestionCircuitos.jsp">Gestionar Circuitos</a></h5>
        						<h5><a href="LoggedGestionNoticias.jsp">Gestionar Noticias</a></h5>
        						<h5><a href="LoggedGestionVotaciones.jsp">Gestionar Votaciones</a></h5>
        						<h5><a href="LoggedVisualizarInfo.jsp">Gestionar Votaciones</a></h5>
        					</c:when>
        					<c:when test="${user.rol.codigo == 'RESEQ'}">
        						SOY RESEQ
        						<h5><a href="LoggedGestionEquipos.jsp">Gestionar Equipos</a></h5>
        						<h5><a href="LoggedGestionPilotos.jsp">Gestionar Pilotos</a></h5>
        						<h5><a href="LoggedGestionCoches.jsp">Gestionar Coches</a></h5>
        						<h5><a href="LoggedSimularCircuitos.jsp">Simular Circuitos</a></h5>
        					</c:when>
        					<c:otherwise>
        						SOY AFICIONADO
        					</c:otherwise>
        				</c:choose>
        				<br>
        				<a href="logout">Logout</a>
    				</c:when>
    				<c:otherwise>
    					<a href="PaginaLogin.html">Haz logging</a>
    				</c:otherwise>
				</c:choose>
				
				
			</form>
			<br /> <br />
		</div>
	</div>
</body>
</html>