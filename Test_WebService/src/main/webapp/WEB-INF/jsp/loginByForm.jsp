<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Inicio</title>
	</head>
	<body>
		<h1>Introduce tus credenciales</h1>
						
		<font color="red">${errorMessage}</font>
		<form method="POST" action="/login/byForm/check">
	        Name : <input type="text" name="name" />
	        Password : <input type="password" name="password" /> 
        	<input type="submit" />
    	</form>
		      
	</body>
</html>
