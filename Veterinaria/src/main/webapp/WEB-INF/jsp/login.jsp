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
		<style>
			.chido{
				color: #26a69a;
			}
		</style>
	</head>
	<body class='grey lighten-2'>

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='/index' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'>
					<li class='active'><a href='/login'>Iniciar Sesión</a></li>
					<li><a href='/logup'>Registrar</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li class='active'><a href='/login'>Iniciar Sesión</a></li>
					<li><a href='/logup'>Registrar</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>
		
		<br><br>

		<div class='container'>
			<div class='row'>
				<div class='col s12 m6 offset-m3'>

					<h4 class='brand-logo center'><p class='chido'>Inicia sesión</p></h4>
					<p class="center blue-text">${infoMessage}</p>
					<br>
					
					<form action='/loginByForm' method='POST' class='col s12'>
						
						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>account_circle</i>
							<input type='text' id='idUser' name='idUser' required>
							<label for='idUser'>Nombre de Usuario</label>
						</div>

						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>vpn_key</i>
							<input type='password' id='password' name='password' required>
							<label for='password'>Contraseña de Usuario</label>
						</div>
						<p class='red-text center'>${errorMessage}</p>						
						<div class='input-field col s12 center'>
							<button class="btn waves-effect waves-light" type="submit" name="action">Iniciar sesión
						    	<i class="material-icons right">send</i>
						  	</button>
						</div>

					</form>
				</div>
			</div>
		</div>

		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init.js'></script>

	</body>
</html>