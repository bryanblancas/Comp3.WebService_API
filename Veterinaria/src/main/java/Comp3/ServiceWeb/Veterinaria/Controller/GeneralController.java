package Comp3.ServiceWeb.Veterinaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class GeneralController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/hola")
	@ResponseBody
	public String nada(@SessionAttribute("idUser") String idUser) {
		return idUser;
	}
	
	
}
