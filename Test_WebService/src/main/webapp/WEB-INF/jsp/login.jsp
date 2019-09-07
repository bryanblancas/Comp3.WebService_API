<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Inicio</title>
	</head>
	<body>
		
		<h1>Inicia sesión</h1>
				
		<font color="red">${errorMessage}</font>
		<form method="POST" action="/login/byForm">
	        Name : <input type="text" name="name" />
	        Password : <input type="password" name="password" /> 
        	<input type="submit" />
    	</form>
		      
	</body>
</html>
