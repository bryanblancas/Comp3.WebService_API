package Comp3.ServiceWeb.Veterinaria.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import Comp3.ServiceWeb.Veterinaria.Model.UserDataSession;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.AppointmentEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Services.ClientService;

@Controller
@Scope("session")
public class ClientController {
			
	@Autowired
	ClientService clientService;
	
	@RequestMapping("client/pets")
	public String showClientPets(Model model, @SessionAttribute(name="user_data_session", required=false) UserDataSession userdatasession) {
		if(userdatasession == null) return "redirect:/index";
		if(userdatasession.getType() == 0 || userdatasession.getType() == 2) return "redirect:/index";
		
		List<PetEntity> petsList = clientService.getClientPets(userdatasession.getUser().getIdUser());
		
		String pets = "<h2> No tienes mascotas aún </h2>";
		
		if(petsList.isEmpty() == false){
			pets = "";
			for(PetEntity pe : petsList) {
				pets += "<tr>"
						+ 	"<td>"+pe.getName()+"</td>"
						+ 	"<td>"+pe.getType()+"</td>"
						+ 	"<td>"+pe.getDay_birth()+"/"+pe.getMonth_birth()+"/"+pe.getYear_birth()+"</td>"
						+ 	"<td>"+(pe.getIs_alive()==1?"¡SI!":"NO")+"</td>"
						+ 	"<td class='right-align'>"
						+ 		"<a class='btn-floating btn-large waves-effect waves-light red delete' id_pet='"+pe.getIdPet()+"'><i class='material-icons'>delete</i></a>\n" 
						+ 		"<a class='btn-floating btn-large waves-effect waves-light blue view' id_pet='"+pe.getIdPet()+"'><i class='material-icons'>remove_red_eye</i></a>\n"
						+ 		"<a class='btn-floating btn-large waves-effect waves-light green book' id_pet='"+pe.getIdPet()+"'><i class='material-icons'>menu_book</i></a>"
						+ 	"</td>"
						+ "</tr>";
			}
			
		}
		
		model.addAttribute("pets", pets);
		
		/*GET VETS LIST*/
		String text = "<select name='idVet' id='idVet_form' required>";
		List<User_dataEntity> vets = clientService.getVetList();
		
		for(User_dataEntity ue : vets)
			text += "<option value='"+ue.getIdUser()+"'>"+ue.getName()+ue.getFirst_lastname()+"</option>";
		text += "</select>";
		
		model.addAttribute("vetsSelect", text);
		
		return "/client/pets";
	}
	
	
	@RequestMapping("/client/delete/{idPet}")
	@ResponseBody
	public String deleteByIdPet(Model model, @PathVariable("idPet") int idPet, @SessionAttribute(name="user_data_session", required=false) UserDataSession userdatasession) {
		if(userdatasession == null) return "USERNOTLOGEDIN";
		if(userdatasession.getType() == 0 || userdatasession.getType() == 2) return "USERNOTLOGEDIN";
		
		int rows_affected = clientService.deleteByIdPet(idPet);
		
		if(rows_affected == 1)
			return "OK";
		else 
			return "ERROR";
		
	}
	
	@RequestMapping("/client/view/{idPet}")
	@ResponseBody
	public String viewAppointments(Model model, @PathVariable("idPet") int idPet, @SessionAttribute(name="user_data_session", required=false) UserDataSession userdatasession) {
		if(userdatasession == null)	return "USERNOTLOGEDIN";
		if(userdatasession.getType() == 0 || userdatasession.getType() == 2) return "USERNOTLOGEDIN";
		
		List<AppointmentEntity> appointmentList = clientService.findAllAppointmentOfPet(idPet);
		String rtn = "EMPTY"; 
		
		if(appointmentList.isEmpty() == false){
			rtn = "";
			
			for (AppointmentEntity ae : appointmentList) {
				User_dataEntity ue = clientService.findVet(ae.getVet_idUser_vet());
				
				rtn += "<hr>"
					+ 		"<h4 class='infoAppointment_vetName'>"+ue.getName()+" "+ue.getFirst_lastname()+" "+ue.getSecond_lastname()+"</h4>"
					+ 		"<h5 class='infoAppointment_date'>"+ae.getDay()+"/"+ae.getMonth()+"/"+ae.getYear()+"</h5>\n"
					+       "<p class='infoAppointment_prescription'>"+ae.getPrescription()+"</p>";
			}
		}
		
		return rtn;
	}
	
	@RequestMapping(value = "/client/add/{idUser}", method = RequestMethod.POST)
	public String addNewPet(Model model, @PathVariable("idUser") String idUser, @SessionAttribute(name="user_data_session", required=false) UserDataSession userdatasession, @RequestParam Map<String, String> allParams) {
		if(userdatasession == null)	return "redirect:/index";
		if(userdatasession.getType() == 0 || userdatasession.getType() == 2) return "redirect:/index";
		
		if(!idUser.equals(userdatasession.getUser().getIdUser()))
			return "redirect:/logout";
		
		PetEntity pe = new PetEntity(
					1,
					allParams.get("name"),
					Integer.parseInt(allParams.get("day_birth")),
					Integer.parseInt(allParams.get("month_birth")),
					Integer.parseInt(allParams.get("year_birth")),
					idUser,
					1,
					allParams.get("type")
				);
		
		int rows_affected = clientService.savePet(pe);
		
		if(rows_affected == 1)
			return "redirect:/client/pets";
		else {
			model.addAttribute("errorMessage", "No se pudo guardar la mascota.");
			return "redirect:/client/pets";
		}
		
	}
	
	@RequestMapping(value="/client/bookAppointment", method=RequestMethod.POST)
	public String bookAppointment(Model model, @RequestParam Map<String, String> allParams) {
		String date[] = allParams.get("date").split("-");
		
		AppointmentEntity ae = new AppointmentEntity(
				1,
				Integer.parseInt(date[0]),
				Integer.parseInt(date[1]),
				Integer.parseInt(date[2]),
				allParams.get("idVet"),
				Integer.parseInt(allParams.get("idPet")),
				"Aún no establecido"
			);
		
		int rows_affected = clientService.bookAppointment(ae);
		
		if(rows_affected != 1)
			model.addAttribute("erroMessage", "No se pudo agendar la cita");
		return "redirect:/client/pets";
	}
	
	
	@RequestMapping(value="/client/account")
	public String showClientInfo(Model model, @SessionAttribute(name="user_data_session", required=false) UserDataSession userdatasession) {
		if(userdatasession == null)	return "redirect:/index";
		if(userdatasession.getType() == 0 || userdatasession.getType() == 2) return "redirect:/index";
		
		return "/client/clientAccount"; 
	}
	
}

