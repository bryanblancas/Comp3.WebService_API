package Comp3.ServiceWeb.Veterinaria.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;
import Comp3.ServiceWeb.Veterinaria.Services.LogupService;

@Controller
public class LogupController {
	
	@Autowired
	LogupService logupService;
	
	
	@RequestMapping("/logup")
	public String showLogupPage(){
		return "logup";
	}
	
	@RequestMapping("/logupForm")
	public String registerUser(ModelMap model, @RequestParam Map<String, String> allParams) {
		/*
		 * 
		 * Maybe some good validation here, that will be great!
		 * 
		 * 
		 */
		
		User_dataEntity user_data = null;
		VetEntity vet = null;
		UserEntity client = null;
		int rows_affected = 0;
		
		user_data = new User_dataEntity(
				allParams.get("idUser"),
				allParams.get("name"),
				allParams.get("first_lastname"),
				allParams.get("second_lastname"),
				Integer.parseInt(allParams.get("day_birth")),
				Integer.parseInt(allParams.get("month_birth")),
				Integer.parseInt(allParams.get("year_birth")),
				allParams.get("email")
		);
		

		boolean existUser = logupService.existUser(user_data);
		if(existUser) {
			model.addAttribute("errorMessage", "Ese nombre de usuario ya existe");
			return "/logup";
		}
		
		if(allParams.get("isVet") != null) {
			vet = new VetEntity(allParams.get("idUser"), allParams.get("password"));
			rows_affected = logupService.saveUser(user_data, vet);
		}
		else {
			client = new UserEntity(allParams.get("idUser"), allParams.get("password"));
			rows_affected = logupService.saveUser(user_data, client);
		}
		
		if(rows_affected != 0) {
			model.addAttribute("infoMessage", "Ya puedes iniciar sesión");
			return "/login";
		}
			
		model.addAttribute("errorMessage", "No se pudo guardar. Intenta de nuevo más tarde");
		return "/logup";
		
	}
	
}
