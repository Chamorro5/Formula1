<%@page import="servicio.NoticiaSrv"%>
<%@page import="entidad.Noticia"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Registro F1</title>
</head>
<body>
	<h1>Formulario de Registro</h1>
	<br>
	<c:if test="${not empty error}"> * error: ${error} </c:if>
	<form action="RegistroServ" method="post">
		
		<table style="with: 50%">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td>Nombre publico</td>
				<td><input type="text" name="nombrePublico" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>