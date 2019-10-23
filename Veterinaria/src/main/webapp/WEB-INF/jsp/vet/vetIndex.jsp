<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title> Vet - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='../css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='../css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
	</head>
	<body class='grey lighten-2'>

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='/index' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'><li>
					<li><a href='/welcome'>Inicio</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li><a href='/welcome'>Inicio</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>
		

		<div id='index-banner' class='parallax-container'>
			<div class='parallax'><img src='/images/vet_background.jpg' alt='vet'></div>
		</div>


		<br>
		<div class="container">
			
			<div class="row">
				<div class="col s12">
					<div class="row">
						<h1 class='header center teal-text text-lighten-2'>Bienvenido doctor ${user_data_session.getUser().getName()}</h1>
					</div>
					<div class="row">
						<h5 class='header center'>Aquí tienes tu información personal</h5>
					</div>
				</div>	
			</div>

			
			<div class="row">
				<div class="col s12 m6 offset-m4">
					Nombre:
					<blockquote>${user_data_session.getUser().getName()} ${user_data_session.getUser().getFirst_lastname()} ${user_data_session.getUser().getSecond_lastname()}</blockquote>
					
					Nombre de usuario:
					<blockquote>${user_data_session.getUser().getIdUser()}</blockquote>

					Fecha de nacimiento:
					<blockquote>${user_data_session.getUser().getDay_birth()}/${user_data_session.getUser().getMonth_birth()}/${user_data_session.getUser().getYear_birth()}</blockquote>

					Correo:
					<blockquote>${user_data_session.getUser().getEmail()}</blockquote>
				</div>
			</div>

		</div>
		


		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='../js/materialize.js'></script>
		<script src='../js/init.js'></script>
		<script src='../js/actions.js'></script>
	</body>
</html>