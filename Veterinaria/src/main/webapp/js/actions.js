$( document ).ready(function() {
   
   	

    $('a.view').on('click', function(){
    	let id_pet = $(this).attr('id_pet');
    	$('#infoAppointment_modal').modal('open');

    	$.ajax({
			url: "/client/view/"+id_pet,
			type: "GET",
			contentType: "text/plain;charset=UTF-8",
			datatype: 'text/plain',
			success:function(result){
				if(result === "EMPTY")
					$('#infoAppointment_div').html("<h2>No hay historial médico para tu mascota</h2>");	
				else if(result === "USERNOTLOGEDIN")
					window.location.href = "/index";
				else
					$('#infoAppointment_div').html(result);
			},
			error:function(result){
				$('#infoAppointment_div').html("ERROR");	
			}
		});
    });




    $('a.book').on('click', function(){
    	let id_pet = $(this).attr('id_pet');
    	$('#idPet').val(id_pet);
    	$('#bookAppointment_modal').modal('open');
    });

   


    $('a.delete').on('click', function(){
    	let id_pet = $(this).attr('id_pet');

    	$.ajax({
			url: "/client/delete/"+id_pet,
			type: "GET",
			contentType: "text/plain;charset=UTF-8",
			datatype: 'text/plain',
			success:function(result){
				if(result === "OK"){
					$('.infoDelete_h4').text("Éxito al eliminar mascota");
					$('.infoDelete_p').text("Tu mascota ha sido eliminada");
				}
				else if(result === "ERROR"){
					$('.infoDelete_h4').text("Error al eliminar mascota");
					$('.infoDelete_p').text("Ocurrió un error al eliminar a esa mascota");	
				}
				else if(result === "USERNOTLOGEDIN")
					window.location.href = "/index";
			},
			error:function(result){
				$('.infoDelete_h4').text("Error al conectar con el servidor");
				$('.infoDelete_p').text("Intenta nuevamente esta operación más adelante");
			}
		});
		$('#infoDelete_modal').modal('open');
    });




    $('a.add').on('click', function(){
    	$('#addPet_modal').modal('open');
    });

    

    $('.modal').modal();
	$('.modal-close.reload').on('click', function() {
    	location.reload()
    });


    $('select').formSelect();
  	$('.datepicker').datepicker({
  		autoClose: true, 
  		format: "dd-mm-yyyy",
  		minDate: new Date()
  	});

});