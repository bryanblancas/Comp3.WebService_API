<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html>

<html>
	<head>
	  	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title>Iniciar sesión - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
	</head>
	<body class='grey lighten-2'>

		${idUser}
		
		<a href='/logout'>Cerrar Sesión</a>


		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init.js'></script>

	</body>
</html>