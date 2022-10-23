<%@page import="servicio.CircuitoSrv"%>
<%@page import="entidad.Circuito"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
// Create an ArrayList with test data
List<Circuito> lCircuito = CircuitoSrv.getInstance().getAll();
pageContext.setAttribute("circuitos", lCircuito);
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
<title>Gestionar Circuitos F1</title>
</head>
<body>
	<h1>Gestionar Circuitos</h1>
	<br>

	<table width="100%">
		<th>Nombre</th>
		<th>Ciudad</th>
		<th>Pais</th>
		<th>Num. Vueltas</th>
		<th>Longitud</th>
		<th>Curvas Lentas</th>
		<th>Curvas Medias</th>
		<th>Curvas Rapidas</th>
		<c:forEach items="${circuitos}" var="circuito">
			<tr>
				<td>${circuito.nombre}</td>
				<td>${circuito.ciudad}</td>
				<td>${circuito.pais}</td>
				<td>${circuito.numVueltas}</td>
				<td>${circuito.longitud}</td>
				<td>${circuito.cuvLentas}</td>
				<td>${circuito.cuvMedias}</td>
				<td>${circuito.cuvRapidas}</td>
			</tr>

		</c:forEach>
	</table>
	<br>
	<h1>Formulario de Registro</h1>
	<br>
	<c:if test="${not empty error}"> * error: ${error} </c:if>
	<form action="CircuitoServ" method="post" enctype = "multipart/form-data">

		<table style="with: 90%">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" /></td>
				<td>Ciudad</td>
				<td><input type="text" name="ciudad" /></td>
				<td>Pais</td>
				<td><input type="text" name="pais" /></td>
				<td>Imagen Trazado</td>
				<td><input type = "file" name = "imagenTrazado" size = "50" /></td>
				
			</tr>
			<tr>
				<td>Numero Vueltas</td>
				<td><input type="text" name="numVueltas" /></td>
				<td>Longitud</td>
				<td><input type="text" name="longitud" /></td>
				<td>Curvas Lentas</td>
				<td><input type="text" name="cuvLentas" /></td>
				<td>Curvas Medias</td>
				<td><input type="text" name="cuvMedias" /></td>
				<td>Curvas Rapidas</td>
				<td><input type="text" name="cuvRapidas" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
	</form>
</body>
</html>