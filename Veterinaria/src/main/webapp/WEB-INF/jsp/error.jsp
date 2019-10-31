
<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
	<head>
	  	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
	 	<meta name='viewport' content='width=device-width, initial-scale=1'/>
		<title>Error - Veterinaria</title>
	
		<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>
		<link href='css/materialize.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<link href='css/style.css' type='text/css' rel='stylesheet' media='screen,projection'/>
		<style>
			body {  
				background-image: url(/images/nosotros.jpeg);
				background-repeat: no-repeat;
				background-size:cover;
				} 
		</style>
	</head>
	<body>
		
		<div class="container">
			<h3 class="header center red-text text-lighten-2">ERROR</h3>
			<div class="row">
				<marquee direction="down" width="800" height="400"  scrollamount="50" scrolldelay='1' behavior="alternate">
				 	<marquee behavior="alternate" scrollamount="50" scrolldelay='1'> 
				 		<a href='/welcome' id='return-button' class='btn-large waves-effect waves-light red lighten-1'><i class="material-icons">backspace</i></a>
				 	</marquee>
				</marquee>
			</div>
		</div>
		


		<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>
		<script src='js/materialize.js'></script>
		<script src='js/init.js'></script>
	</body>
</html>