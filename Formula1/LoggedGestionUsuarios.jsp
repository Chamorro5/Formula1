<%@page import="servicio.UsuarioRegistradoSrv"%>
<%@page import="entidad.UsuarioRegistrado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
// Create an ArrayList with test data
List<UsuarioRegistrado> lUsuario = UsuarioRegistradoSrv.getInstance().getAll();
pageContext.setAttribute("usuarios", lUsuario);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar Usuarios F1</title>
</head>
<body>
	<h1>Gestionar Usuarios</h1>
	<br>
	<c:if test="${not empty error}"> * error: ${error} </c:if>


	<form action="UsuarioServ" method="post">
		<table width="100%">
			<th>Nombre</th>
			<th>Nombre publico</th>
			<th>Email</th>
			<th>Rol</th>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nombre}</td>
					<td>${usuario.usuario}</td>
					<td>${usuario.email}</td>
					<td>${usuario.rol.descripcion}</td>
				</tr>

			</c:forEach>
		</table>
		<br>
		<h3>Cambiar Rol de Usuario</h3>
		<select name="usuario">
			<c:forEach var="usuario" items="${usuarios}">
				<option value="${usuario.nombre}">${usuario.nombre}</option>
			</c:forEach>
		</select> 
		<select name="rol">
			<option value="ADMIN">Administrador</option>
			<option value="RESEQ">Responsable de equipo</option>
			<option value="AFICI">Aficionado</option>
		</select> 
		<input type="submit" value="Cambiar">
	</form>
</body>
</html>