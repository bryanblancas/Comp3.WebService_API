<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title>User - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
	</head>
	<body class='grey lighten-2'>

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='#' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'><li>
					<li class='active'><a href='#'>Inicio</a></li>
					<li><a href='/client/account'>Cuenta</a></li>
					<li><a href='/client/pets'>Mascotas</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li class='active'><a href='#'>Inicio</a></li>
					<li><a href='/client/account'>Cuenta</a></li>
					<li><a href='/client/pets'>Mascotas</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>
			


		<div id='index-banner' class='parallax-container'>
			<div class='parallax'><img src='images/hombrejugando_background.jpg' alt='Perro jugando'></div>
		</div>


		<div class="container">

			<div class="row">
				<div class="col s12">
					<div class="row">
						<h1 class='header center teal-text text-lighten-2'>Bienvenido ${user_data_session.getUser().getName()}</h1>
					</div>
					<div class="row">
						<h5 class='header center'>¿Qué deseas hacer?</h5>
					</div>
				</div>	
			</div>

			<div class="row">
				<div class='row'>

					<div class='col s12 m6'>
						<div class='icon-block center'>
							<h5 class='center'>Checar mascotas</h5>
							<p class='light center-align'>Ve la información de tus mascotas, agenda una cita para ellas o modifica su información.</p>
							<a href='/client/pets' id='pets-button' class='btn-large waves-effect waves-light teal lighten-1'>Mascotas</a>
						</div>
					</div>

					<div class='col s12 m6'>
						<div class='icon-block center'>
							<h5 class='center'>Administra tu cuenta</h5>
							<p class='light center-align'>Consulta tu información, puedes modificarla. <br> Cambia tu contraseña</p>
							<a href='/client/account' id='account-button' class='btn-large waves-effect waves-light teal lighten-1'>Cuenta</a>
						</div>
					</div>

				</div>	
			</div>

		</div>
		
		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init.js'></script>

	</body>
</html>