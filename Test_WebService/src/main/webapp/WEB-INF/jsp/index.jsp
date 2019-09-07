<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Inicio</title>
	</head>
	<body>
		
		<h1>Ejemplo de página de bienvenida</h1>
		
		<form method="POST" action="/login/byChaffing">
			<button type="submit">Iniciar sesión con chaffing</button>
		</form>
		 
		<form method="GET" action="/login/byForm">
			<button type="submit">Iniciar sesión con credenciales</button>
		</form>
       	
	</body>
</html>