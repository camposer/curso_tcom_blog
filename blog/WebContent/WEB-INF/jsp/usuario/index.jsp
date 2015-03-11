<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<script src="${contextPath}/js/sha1.js"></script>
	<script>
		var ingresar = function() {
			// Calculando HASH de la clave
			var claveLimpia = document.getElementById("claveLimpia").value;
			var hash = CryptoJS.SHA1(claveLimpia);
			document.getElementById("clave").value = hash;
			
			document.forms[0].submit();
		};
	</script>
</head>
<body>
	<div class="errores">
		<c:forEach var="e" items="${errores}">
			${e}<br>
		</c:forEach>
	</div>

	<h1>Autenticar</h1>
	<form action="${contextPath}/action/usuario/autenticar" method="post">
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="nombreUsuario"></td>
			</tr>		
			<tr>
				<td>Contraseña</td>
				<td>
					<input type="hidden" id="clave" name="clave">
					<input type="password" id="claveLimpia">
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="button" value="Ingresar" onclick="ingresar()">
				</td>
			</tr>		
		</table>
	</form>
	
	<hr>
	
	<h1>Darse de alta</h1>
	<form action="${contextPath}/action/usuario/agregar" method="post">
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="nombreUsuario"></td>
			</tr>		
			<tr>
				<td>Contraseña</td>
				<td><input type="text" name="clave"></td>
			</tr>		
			<tr>
				<td>Repita contraseña</td>
				<td><input type="text" name="claveRepetida"></td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="button" value="Dar de alta" onclick="darAlta()">
				</td>
			</tr>		
		</table>
	</form>
	
</body>
</html>
