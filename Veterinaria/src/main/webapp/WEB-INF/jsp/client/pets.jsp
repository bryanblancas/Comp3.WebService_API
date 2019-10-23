<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title>Pets - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='../css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='../css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<!--<style>
			.modal { width: 75% !important ; height: 75% !important ; 
		</style>-->
	</head>
	<body class='grey lighten-2'>

		<nav class='white' role='navigation'>
			<div class='nav-wrapper container'>
				<a id='logo-container' href='/index' class='brand-logo'>Veterinaria</a>
				<ul class='right hide-on-med-and-down'><li>
					<li><a href='/welcome'>Inicio</a></li>
					<li><a href='/client/account'>Cuenta</a></li>
					<li class="active"><a href='#'>Mascotas</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>

				<ul id='nav-mobile' class='sidenav'>
					<li><a href='/welcome'>Inicio</a></li>
					<li><a href='/client/account'>Cuenta</a></li>
					<li class="active"><a href='#'>Mascotas</a></li>
					<li><a href='/logout'>Cerrar Sesión</a></li>
				</ul>
				<a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>
			</div>
		</nav>

		<br>
		<div class="container">
			<div class="row">
				<div class="col s12 m8">
					<h5>Estas son tu mascotas ${user_data_session.getUser().getName()}</h5>
				</div>
				<div class="col s12 m4 right-align">
					${errorMessage}
					<a class='btn-floating btn-large waves-effect waves-light teal lighten-2 add'><i class='material-icons'>add</i></a>
				</div>
			</div>
			
			<div class="row">
				<div class="col s12">
					<table class='highlight responsive-table'>
				        <thead class="teal lighten-2">
					        <tr>
				              	<th>Nombre</th>
				              	<th>Animal</th>
				              	<th>Nacimiento</th>
				              	<th>¿Está vivo?</th>
				              	<th class='right-align'>Acciones</th>
				        	</tr>
				        </thead>

			        	<tbody>
			        		${pets}
			        	</tbody>
			      	</table>
			    </div>
			</div>

		</div>


		<!--MODALS SECTIONS-->
		<div id="infoDelete_modal" class="modal">
		    <div class="modal-content">
		    	<h4 class='infoDelete_h4'></h4>
		      	<p class='infoDelete_p'></p>
		    </div>
		    <div class="modal-footer">
		      	<a href="#!" class="modal-close reload waves-effect waves-green btn-flat">Cerrar</a>
		    </div>
	  	</div>

	  	<div id="addPet_modal" class="modal">
		    <div class="modal-content">

		    	<form action="/client/add/${user_data_session.getUser().getIdUser()}" method="POST">

					<div class="row">
						<div class="col s12">
							<h5 class='brand-logo center'><p >Completa el siguiente formulario</p></h5>
						</div>
					</div>

					<div class="row">

						<div class="col s12">
							<div class='input-field col s12 center'>
								<i class='material-icons prefix'>person</i>
								<input type='text' id='name' name='name' required>
								<label for='name'>Nombre</label>
							</div>	
						</div>

					</div>

					<div class="row">

						<div class="col s8">
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
								    <option value="2000">2000</option>
								    <option value="2001">2001</option>
								    <option value="2002">2002</option>
								    <option value="2003">2003</option>
								</select>
								<label for="year_birth">Año de nacimiento</label>
							</div>
						</div>
						
						<div class="col s4">
							<div class="input-field col s12">
								<select id="type" name="type" required>
									<option value="" disabled selected>Elige</option>
								    <option value="perro">Perro</option>
								    <option value="gato">Gato</option>
								    <option value="raton">Raton</option>
								</select>
								<label for="type">Animal</label>
							</div>
						</div>
					</div>

					<div class="col s6 offset-s3 m4 offset-m4">
						<div class='input-field col s12 center'>
							<button class="btn waves-effect waves-light" type="submit" id="addPet_button">Agregar mascota
						    	<i class="material-icons right">send</i>
						  	</button>
						</div>
					</div>	

		    	</form>
		    </div>
		    <div class="modal-footer">
		      	<a href="#!" class="modal-close waves-effect waves-green btn-flat">Cerrar</a>
		    </div>
	  	</div>
		

		
		<div id="infoAppointment_modal" class="modal">
		    <div class="modal-content" id="infoAppointment_div">
		    	
		    </div>
		    <div class="modal-footer">
		      	<a href="#!" class="modal-close waves-effect waves-green btn-flat">Cerrar</a>
		    </div>
	  	</div>



		<div id="bookAppointment_modal" class="modal">
		    <div class="modal-content">

		    	<form action="/client/bookAppointment" method="POST">

		    		<div class="row">
						<div class="col s12">
							<h5 class='brand-logo center' id='infoBookAppoinment_h5'><p >Agenda tu cita</p></h5>
						</div>
					</div>

					<div class="row">
						<div class="col s8">
							<div class="input-field col s12 appendVets_div">
								${vetsSelect}
								<label for='idVet_form'>Elige veterinario</label>
							</div>
						</div>
							
						<div class="col s4">
							<div class="input-field col s12">
								 <input type="text" name="date" class="datepicker" required placeholder="Elige la fecha de la cita">
							</div>	
						</div>

						<div class="col s4 hide">
							<div class="input-field col s12">
								 <input type="text" name="idPet" id="idPet" value="">
							</div>	
						</div>
					</div>
					
					<div class="col s6 offset-s3 m4 offset-m4">
						<div class='input-field col s12 center'>
							<button class="btn waves-effect waves-light" type="submit" id="bookAppointment_button">Agendar cita
						    	<i class="material-icons right">send</i>
						  	</button>
						</div>
					</div>	

		    	</form>
		    	
		    </div>
		    <div class="modal-footer">
		      	<a href="#!" class="modal-close waves-effect waves-green btn-flat">Cerrar</a>
		    </div>
	  	</div>



		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='../js/materialize.js'></script>
		<script src='../js/init.js'></script>
		<script src='../js/actions.js'></script>

	</body>
</html>