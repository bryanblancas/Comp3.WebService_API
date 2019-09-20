package Comp3.ServiceWeb.Veterinaria.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;

@Controller
public class LogupController {
	
	@RequestMapping("/logup")
	public String showLogupPage(){
		return "logup";
	}
	
	@RequestMapping("/logupForm")
	@ResponseBody
	public String registerUser(@RequestParam Map<String, String> allParams) {
		/*
		 * 
		 * Maybe some good validation here, that will be great!
		 * 
		 * 
		 */
		User_dataEntity user_data = null;
		VetEntity vet = null;
		UserEntity user = null;
		
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
		
		if(allParams.get("isVet") != null)
			vet = new VetEntity(allParams.get("idUser"), allParams.get("password"));
		else
			user = new UserEntity(allParams.get("idUser"), allParams.get("password"));
		
		if(user == null)
			return "Es un veterinario " + user_data.toString() + "\n"+vet.toString();
		return "No es un veterinario " + user_data.toString() + "\n"+user.toString();
	}
	
}
