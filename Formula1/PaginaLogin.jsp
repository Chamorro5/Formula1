<%@page import="servicio.NoticiaSrv"%>
<%@page import="entidad.Noticia"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#cabecera {
	display: flex;
	justify-content: center;
}

.centrado {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 15%;
	text-align: center;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Login</title>
</head>
<body>

	<div id="cabecera">
		<img src="img/logo.jpg" alt="Logo F1" align="middle" width="700"
			height="400">
	</div>

	<div style="background-color: #E5E4E2;" class="centrado">
		<form action="login" method="POST">
			<%@page import="java.util.*" session="false"%>
			<input type="hidden" name="origin" value="${origin}">
			<h3>Login de Usuario</h3>
			<table>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Contraseña:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<br> 
			<input type="submit"/> 
			<br> 
			<input type="button" > <a
				href="Registro.jsp">Registrarse</a> </input>
				
			<br>
			<a href="Principal.jsp">Volver</a>

		</form>
		<br /> <br />
	</div>
</body>
</html>