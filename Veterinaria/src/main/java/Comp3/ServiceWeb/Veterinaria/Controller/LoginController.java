package Comp3.ServiceWeb.Veterinaria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Comp3.ServiceWeb.Veterinaria.Services.LoginService;

@Controller
@Scope("session")
@SessionAttributes("idUser")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/*
	 * THIS IS THE PATH WHICH THE EXTENSION WILL SCAN
	 * */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = "/loginByForm", method = RequestMethod.POST)
	public String loginByForm(ModelMap model, @RequestParam String idUser, @RequestParam String password) {
		
		if(!loginService.validateCredentials(idUser, password)) {
			model.addAttribute("errorMessage", "Credenciales inválidas");
			return "/login";
		}
		
		model.addAttribute("idUser", idUser);
		return "/welcome";
	}
	
	@RequestMapping(value = "/welcome")
	public String showWelcomePage(@ModelAttribute("idUser") String idUser) {
		
		if(idUser.equals(""))
			return "redirect:/index";
			
		return "/welcome";
	
	}
	
	@RequestMapping(value = "/logout")
	public String logout(ModelMap model) {
		
		model.addAttribute("idUser", "");
		return "redirect:/index";
	
	}
	
}
