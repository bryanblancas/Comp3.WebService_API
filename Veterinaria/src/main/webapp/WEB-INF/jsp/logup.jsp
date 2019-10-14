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

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='/index' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'>
					<li><a href='/login'>Iniciar Sesión</a></li>
					<li class='active'><a href='/logup'>Registrar</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li><a href='/login'>Iniciar Sesión</a></li>
					<li class='active'><a href='/logup'>Registrar</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>
		
		<br><br>
	
		<div class='container'>
			
			<div class='row'>
				<div class="col s12">
					<h4 class='brand-logo center'><p class='chido'>Completa el siguiente formulario</p></h4>
				</div>
			</div>

			<form action="/logupForm" method="POST">
				<div class="row">
					<div class="col s12">
						<h5 class='brand-logo center'><p class='chido'>Información general</p></h5>
					</div>
				</div>
				<div class="row">
					<div class="col s12 l4">
						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>person</i>
							<input type='text' id='name' name='name' required>
							<label for='name'>Nombre</label>
						</div>	
					</div>
					
					<div class="col s12 l4">
						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>person</i>
							<input type='text' id='first_lastname' name='first_lastname' required>
							<label for='first_lastname'>Primer apellido</label>
						</div>	
					</div>
					
					<div class="col s12 l4">
						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>person</i>
							<input type='text' id='second_lastname' name='second_lastname' required>
							<label for='second_lastname'>Segundo apellido</label>
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="col s12 l6">
						<div class='input-field col s12 center'>
							<i class='material-icons prefix'>mail_outline</i>
							<input type='email' id='email' name='email' required>
							<label for='email'>E-mail</label>
						</div>	
					</div>

					<div class="col s12 l6">
						<div class="input-field col s4">
							<select id="day_birth" name="day_birth" required>
								<option value="" disabled selected>Elige</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
							    <option value="6">6</option>
							    <option value="7">7</option>
							    <option value="8">8</option>
							    <option value="9">9</option>
							    <option value="10">10</option>
							    <option value="11">11</option>
							    <option value="12">12</option>
							    <option value="13">13</option>
							    <option value="14">14</option>
							    <option value="15">15</option>
							    <option value="16">16</option>
							    <option value="17">17</option>
							    <option value="18">18</option>
							    <option value="19">19</option>
							    <option value="20">20</option>
							    <option value="21">21</option>
							    <option value="22">22</option>
							    <option value="23">23</option>
							    <option value="24">24</option>
							    <option value="25">25</option>
							    <option value="26">26</option>
							    <option value="27">27</option>
							    <option value="28">28</option>
							    <option value="29">29</option>
							    <option value="30">30</option>
							    <option value="31">31</option>
							</select>
							<label for="day_birth">Día de nacimiento</label>
						</div>

						<div class="input-field col s4">
							<select id="month_birth" name="month_birth" required>
								<option value="" disabled selected>Elige</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
							    <option value="6">6</option>
							    <option value="7">7</option>
							    <option value="8">8</option>
							    <option value="9">9</option>
							    <option value="10">10</option>
							    <option value="11">11</option>
							    <option value="12">12</option>
							</select>
							<label for="month_birth">Mes de nacimiento</label>
						</div>

						<div class="input-field col s4">
							<select id="year_birth" name="year_birth" required>
								<option value="" disabled selected>Elige</option>
							   	<option value="1970">1970</option>
							    <option value="1971">1971</option>
							    <option value="1972">1972</option>
							    <option value="1973">1973</option>
							    <option value="1974">1974</option>
							    <option value="1975">1975</option>
							    <option value="1976">1976</option>
							    <option value="1977">1977</option>
							    <option value="1978">1978</option>
							    <option value="1979">1979</option>
							    <option value="1980">1980</option>
							    <option value="1981">1981</option>
							    <option value="1982">1982</option>
							    <option value="1983">1983</option>
							    <option value="1984">1984</option>
							    <option value="1985">1985</option>
							    <option value="1986">1986</option>
							    <option value="1987">1987</option>
							    <option value="1988">1988</option>
							    <option value="1989">1989</option>
							    <option value="1990">1990</option>
							    <option value="1991">1991</option>
							    <option value="1992">1992</option>
							    <option value="1993">1993</option>
							    <option value="1994">1994</option>
							    <option value="1995">1995</option>
							    <option value="1996">1996</option>
							    <option value="1997">1997</option>
							    <option value="1998">1998</option>
							    <option value="1999">1999</option>
							    <option value="2000">2000</option>
							    <option value="2001">2001</option>
							    <option value="2002">2002</option>
							    <option value="2003">2003</option>
							</select>
							<label for="year_birth">Año de nacimiento</label>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col s12">
						<h5 class='brand-logo center'><p class='chido'>Información de la cuenta</p></h5>
						<p class='red-text center'>${errorMessage}</p>
					</div>
				</div>
				
				<div class="row">
					
					<div class="col s12 center">
						<i class='material-icons prefix medium'>account_circle</i>

						<label for="isVet">
				        <input type="checkbox" id="isVet" name="isVet" />
				        	<span>Soy veterinario</span>
				      	</label>

						<div class="input-field col s12">
							<input type='text' id='idUser' name='idUser' required>
							<label for='idUser'>Nombre de Usuario</label>
						</div>
					</div>
					
					<div class="col m6 s12 center">
						<i class='material-icons prefix medium'>vpn_key</i>
						<div class="input-field col s12">
							<input type='password' id='password' name='password' required>
							<label for='password'>Contraseña de Usuario</label>
						</div>
					</div>	
					
					<div class="col m6 s12 center">
						<i class='material-icons prefix medium'>vpn_key</i>
						<div class="input-field col s12">
							<input type='password' id='repeat_password' name='repeat_password' required>
							<label for='repeat_password'>Repite la contraseña de Usuario</label>
						</div>
					</div>

					<div class="col s6 offset-s3 m4 offset-m4">
						<div class='input-field col s12 center'>
							<button class="btn waves-effect waves-light" type="submit" name="action">Registrarme
						    	<i class="material-icons right">send</i>
						  	</button>
						</div>
					</div>	

				</div>
			
			</form>
		</div>
		
		<!--<script src='js/jquery-3.4.1.min.js'></script>-->
		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init_logup.js'></script>
		<script src='js/init.js'></script>

	</body>
</html>