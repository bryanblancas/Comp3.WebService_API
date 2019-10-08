
<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
	<head>
	  	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title>Inicio - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
	</head>
	<body class='grey lighten-2'>
		

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='#' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'>
					<li><a href='/login'>Iniciar Sesión</a></li>
					<li><a href='/logup'>Registrar</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li><a href='/login'>Iniciar Sesión</a></li>
					<li><a href='/logup'>Registrar</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>

		<div id='index-banner' class='parallax-container'>
			<div class='section no-pad-bot'>
				<div class='container'>
					<br><br>
					<h1 class='header center teal-text text-lighten-2'>¡Protégelos!</h1>
					<div class='row center'>
						<h5 class='header col s12 light black-text'>Se lo merecen</h5>
					</div>
					<div class='row center'>
						<a href='/login' id='download-button' class='btn-large waves-effect waves-light teal lighten-1'>Iniciar sesión</a>
					</div>
					<br><br>
				</div>
			</div>
			<div class='parallax'><img src='images/dog_background.jpg' alt='Perro jugando'></div>
		</div>


		<div class='container'>
			<div class='section'>
				<div class='row'>
					<div class='col s12 m4'>
						<div class='icon-block'>
							<h2 class='center brown-text'><i class='material-icons'>alarm</i></h2>
							<h5 class='center'>Agenda citas</h5>
							<p class='light center-align'>Agenda citas para tu mascota desde la comodidad de tu casa desde tu computadora !e incluso desde tu smartphone!</p>
						</div>
					</div>

					<div class='col s12 m4'>
						<div class='icon-block'>
							<h2 class='center brown-text'><i class='material-icons'>group</i></h2>
							<h5 class='center'>Los mejores veterinarios</h5>
							<p class='light center-align '>Contamos con los mejores veterinarios a nivel nacional para que el cuidado de tus mascotas esté en las mejores manos.</p>
						</div>
					</div>

					<div class='col s12 m4'>
						<div class='icon-block'>
							<h2 class='center brown-text'><i class='material-icons'>menu_book</i></h2>
							<h5 class='center'>Historial médico</h5>
							<p class='light center-align'>Te brindamos un rápido acceso a todos lo procedimientos a los que tus mascotas se han sometido. Revisa y monitorea a tus mascotas.</p>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class='parallax-container valign-wrapper'>
			<div class='parallax'><img src='images/cat_background.jpg' alt='Gato acostado'></div>
		</div>

		<div class='container'>
			<div class='section'>
				<div class='row'>
					<div class='col s12 center'>
						<h3><i class='mdi-content-send brown-text'>Servicios</i></h3>
					</div>
					<div class='col l4 s12 center'>
						<h5>Mascotas</h5>
						<p class='center-align light'>
							Como sabemos que no siempre se tiene una sola mascota en casa, aquí puedes guardas tantas mascotas como tengas. Cada una de ellas tiene su propio historial médico y citas separadas.
						</p>
					</div>
					<div class='col l4 s12 center'>
						<h5>Doctores</h5>
						<p class='center-align light'>
							Tú puedes agendar una cita con el doctor de tu preferencia, contamos con grandes médicos y especialistas para que acudas cuando más te convenga.
						</p>
					</div>
					<div class='col l4 s12 center'>
						<h5>Perfiles</h5>
						<p class='center-align light'>
							Llena tu perfil y el de tu mascota para que sea más fácil el acceso a la información para ti y para tus médicos.
						</p>
					</div>
				</div>
			</div>
		</div>


		<div class='parallax-container valign-wrapper'>
			<div class='parallax'><img src='images/hamster_background.jpg' alt='Unsplashed background img 3'></div>
		</div>

		<div class='parallax-container'>
			<div class='parallax'><img src='images/nosotros.jpeg' alt='Los mejores'></div>
		</div>

		<footer class='page-footer teal'>
			<div class='container'>
				<div class='row'>
					<div class='col l6 s12 center'>
						<h5 class='white-text'>TT2018-B003</h5>
						<p class='grey-text text-lighten-4'>Servicio web de prueba para implementar el inicio de sesión por Chaffing and Winnowing.</p>
						<img class='responsive-img' src='images/logo_Ch_W.svg' alt='DREAM TEAM' width="350" height="200">
					</div>
					<div class='col l6 s12 center'>
						<h5 class='white-text'>Integrantes:</h5>
						<br><br><br>
						<div class="row">	
							<div class="col s12 m6">
								<ul>
									<li>Blancas Pérez Bryan Israel</li>
									<blockquote>
								    	<a class='white-text' href='https://github.com/bryanblancas'>@BryanBlancas</a>
								    </blockquote></li>
								</ul>
							</div>
							<div class="col s12 m6">
								<ul>
									<li>Carrillo Fernández Gerardo</li>
									<blockquote>
										<a class='white-text' href='https://github.com/jerrycf'>@jerrycf</a>
									</blockquote>
								</ul>
							</div>
						</div>
						<div class="row">	
							<div class="col s12 m6">
								<ul>
									<li>Morales Gonzáles Diego Arturo</li>
									<blockquote>
										<a class='white-text' href='https://github.com/DiegoArturoMG'>@DiegoArturoMG</a>
									</blockquote>
								</ul>
							</div>
							<div class="col s12 m6">
								<ul>
										<li>Paredes Hernández Pedro Antonio</li>
									<blockquote>
										<a class='white-text' href='https://github.com/live2303'>@live2303</a>
									</blockquote>
								</ul>
							</div>
						</div>
						
						<!--
						<ul>
							<li>Blancas Pérez Bryan Israel</li>
							<blockquote>
						    	<a class='white-text' href='https://github.com/bryanblancas'>@BryanBlancas</a>
						    </blockquote></li>
							<li>Carrillo Fernández Gerardo</li>
							<blockquote>
								<a class='white-text' href='https://github.com/jerrycf'>@jerrycf</a>
							</blockquote>
							<li>Morales Gonzáles Diego Arturo</li>
							<blockquote>
								<a class='white-text' href='https://github.com/DiegoArturoMG'>@DiegoArturoMG</a>
							</blockquote>
							<li>Paredes Hernández Pedro Antonio</li>
							<blockquote>
								<a class='white-text' href='https://github.com/live2303'>@live2303</a>
							</blockquote>
						</ul>
					-->
					</div>
				</div>
			</div>
			<div class='footer-copyright'>
				<div class='container'>
					Made by <a class='brown-text text-lighten-3'>Bryan, Jerry, Arturo y Pedrito</a>
				</div>
			</div>
		</footer>

		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init.js'></script>

	</body>
</html>