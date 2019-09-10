package TT_2018B003.Test_WebService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import TT_2018B003.Test_WebService.Service.LoginService;

@Controller
@SessionAttributes("name")
@Scope("session")
public class LoginController {

	@Autowired
	LoginService loginService;
	String ipServer = "http://25.7.126.53:8081";
	
	// Variables for save chaffing and pattern
	public String chaffing = "";
	public String pattern = "";
	
	
	@RequestMapping(value = "/login/byChaffing", method = RequestMethod.POST)
	@ResponseBody
	public String loginByChaffing(
			ModelMap model,
			@RequestHeader(name = "Chaffing", required = false) String chaffing, 
			@RequestHeader(name = "Pattern", required = false) String pattern
	) {
		
		if(chaffing == null || pattern == null)
			return form(); 
		
		/*Winnowing
		 * THIS WILL BE A CALL TO A MICROSERVICE
		 * */
		
		// Check if chaffing (certificate) already exists
		boolean exists = checkCertificate(chaffing);
		
		this.chaffing = chaffing;
		this.pattern = pattern;
		
		// if exists, return path to welcome page
		if(exists) {
			model.put("name", "Inicio de sesión automático con chaffing");	
			return ipServer+"/welcome";
		}
		
		// if not exists, return path to loginByForm
		return ipServer+"/loginByForm";
		
	}
	
	public static String form() {
		String rtn = "<h1>Introduce tus credenciales</h1>		"
				+"<font color='red'>${errorMessage}</font>"
				+"<form method='POST' action='/login/byForm/check'>"
				+"Name : <input type='text' name='name' />"
				+"Password : <input type='password' name='password' /> "
				+"<input type='submit' />"
				+"</form>";
		return rtn;
	}
	
	public static boolean checkCertificate(String certificate) {
		if(certificate.equals("chaff"))
			return true;
		return false;
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		
		model.put("chaffing", this.chaffing);
		model.put("patter", this.pattern);
		return "/welcome";
	
	}
	
	@RequestMapping(value = "/loginByForm", method = RequestMethod.GET)
	public String loginByForm(ModelMap model) {
		return "/loginByForm";
	}
	
	@RequestMapping(value = "/login/byForm/check", method = RequestMethod.POST)
	public String checkLogin(
			ModelMap model, 
			@RequestParam String password, 
			@RequestParam String name
	) {	
		
		/*boolean isValidUser = loginService.validateUser(name, password);
		if(!isValidUser) {
			model.put("errorMessage", "Credenciales invalidas");
			return "/loginByForm";
		}*/
		
		if(!chaffing.equals(""))
			model.put("name", "Primer inicio de chaffing: "+name);
		else
			model.put("name", "Inicio de sesión sin chaffing: "+name);
	
		return "/welcome";
		
	}
	
	@RequestMapping(value = "/cerrarsesion", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		
		this.chaffing = "";
		this.pattern = "";
		
		return "redirect:/";
	
	}
	
	// Every time that a method with RequestMapping executes, this will be executed too  
		@ModelAttribute("chaffing")
		public String getChaffing() {
			return this.chaffing;
		}
		
		@ModelAttribute("pattern")
		public String getPattern() {
			return this.pattern;
		}
}
