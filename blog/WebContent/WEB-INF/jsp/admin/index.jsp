<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Panel de Administración</title>
</head>
<body>
	Hola: ${sessionScope.usuario.nombreUsuario}
	<h1>Artículos</h1>
	
	<c:forEach var="a" items="${articulos}">
		<div>${a}</div>
	</c:forEach>
</body>
</html>