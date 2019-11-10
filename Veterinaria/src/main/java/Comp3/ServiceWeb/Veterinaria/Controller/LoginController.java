package Comp3.ServiceWeb.Veterinaria.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import Comp3.ServiceWeb.API.Model.WinnowingModel;
import Comp3.ServiceWeb.Veterinaria.Model.UserDataSession;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;
import Comp3.ServiceWeb.Veterinaria.Services.LoginService;

@Controller
@Scope("session")
@SessionAttributes("user_data_session")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	// Variables to save chaffing
	private String certificate = null;
	private int status = -1;
	
	/*
	 * THIS IS THE PATH WHICH THE EXTENSION WILL SCAN
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			ModelMap model,
			@RequestHeader(name = "Chaffing", required = false) String chaffing, 
			@RequestHeader(name = "Pattern", required = false) String pattern
	) {
		
		String ipServer = "";
		/*
		 *  Check if chaffing and pattern have arrived with the request
		 */
		if(chaffing == null || pattern == null)
			return "/login";
		
		System.out.println(chaffing);
		System.out.println(pattern);
		
		/*
		 * At this point, it's supposed to exist chaffing and pattern
		 * So the first step is make a call to winnowing process to get the certificate
		 */
		
		RestTemplate restTemplate = new RestTemplate();
		
		WinnowingModel data = new WinnowingModel();
		data.setChaffing(chaffing);
		data.setPattern(pattern);
		
		String rtn = restTemplate.postForObject(getIpAPI(), data, String.class);
		String[] certAndStatus = rtn.split(" ");
		
		System.out.println("Hola:"+rtn);
		
		certificate = certAndStatus[0];
		status = Integer.parseInt(certAndStatus[1]);
		
		System.out.println("Status certificado: "+status);
		
		/*
		 * Winnowing process doesn't exist yet, so certificate will be equals to certificate
		 */
		/*
		System.out.println(chaffing);
		System.out.println(pattern);
		this.certificate = chaffing;
		*/
		
		
		if(status == 0) {
			certificate = null;
			status = -1;
			System.out.println("Credenciales Inválidas");
			ipServer = getIpServer()+"/showForm0";
			model.addAttribute("ipToRedirect", ipServer);
			return "/trapView";
		}
		
		/*
		 *  Check if certificate already exists
		 */
		CertificateEntity ce = loginService.checkCertificateExistance(certificate);
		
		if(status == 2) {
			/*
			 * Delete this cert, which is revocated, from DB only if it already exists  
			 */
			
			if(ce != null) {
				int rows_affected = loginService.deleteCertificateByCert(ce.getCertificate());
				if(rows_affected == 1)
					System.out.println("Exito al borrar certificado LoginController.login()");
				else
					System.out.println("Error al borrar certificado LoginController.login()");
			}else
				System.out.println("No existía previamente");
			
			certificate = null;
			status = -1;
			System.out.println("Certificado revocado");
			ipServer = getIpServer()+"/showForm2";
			model.addAttribute("ipToRedirect", ipServer);
			return "/trapView";
		}
		
		/*
		 * If certificate exists, sessionvariable user_data_session is setting
		 * and the user is redirect to the welcome page
		 * 
		 * If certificate doesn't exist, the user will be redirect to login form
		 * to link the certificate with his idUser 
		 */
		if(ce != null) {
			UserDataSession userdatasession = loginService.getUserDataSessionById(ce.getUser_data_idUser());
			model.addAttribute("user_data_session", userdatasession);
			ipServer = getIpServer()+"/welcome";
			certificate = null;
		}
		else 
			ipServer = getIpServer()+"/showForm";
		
		model.addAttribute("ipToRedirect", ipServer);
		return "/trapView";
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(ModelMap model) {
		model.addAttribute("infoMessage", "Inicia sesión para vincular las credenciales");
		return "/login";
	}
	
	@RequestMapping("/showForm0")
	public String showForm0(ModelMap model) {
		model.addAttribute("errorMessage", "Credenciales Inválidas");
		return "/login";
	}
	
	@RequestMapping("/showForm2")
	public String showForm2(ModelMap model) {
		model.addAttribute("errorMessage", "Credenciales Inválidas");
		return "/login";
	}
	
	
	@RequestMapping(value = "/loginByForm", method = RequestMethod.POST)
	public String loginByForm(ModelMap model, @RequestParam String idUser, @RequestParam String password) {
		
		/*
		 * Validate credentials of the user, if userdatasession is equal to null
		 * that means that the credentials are wrong 
		 */
		UserDataSession userdatasession = loginService.validateCredentials(idUser, password);
		
		if(userdatasession == null) {
			model.addAttribute("errorMessage", "Credenciales inválidas");
			return "/login";
		}
		
		/*
		 * Otherwise, user exists and his credentials were introduced correctly 
		 */
		
		
		/*
		 * If certificate class variable is different to null, that means certificate has been
		 * initialized in login(), so this is the first time that certificate comes to this WebService
		 */
		if(this.certificate != null) {
			
			/*
			 * At this point, we now that this certificate doesn't exist, so we are going to save it
			 * rows_affected cases:
			 * 	0 -> An error occurred saving the cert in mysql
			 * 	-1 -> User have previously linked to a certificate
			 * 	else -> every little thing is ok 
			 * 
			 * At the end certificate class variable is reset
			 * */
			
			CertificateEntity ce = new CertificateEntity(certificate, userdatasession.getUser().getIdUser());
			
			int rows_affected = loginService.saveCertificate(ce);
			if(rows_affected == 0) {
				model.addAttribute("errorMessage", "No se pudo vincular el certificado");
				return "/login";
			}
			else if(rows_affected == -1) {
				model.addAttribute("errorMessage", "El usuario "+ce.getUser_data_idUser()+" ya tiene un certificado vinculado");
				return "/login";
			}
			this.certificate = null;
		}
		
		/*
		 * If the process arrived to this point, there's two options
		 * 	1. certificate is equal to null, which means that normal login is happening
		 * 	2. certificate was different to null and it was possible to save it
		 * 
		 * Both cases means that login was successfully done, so userdatasession variable is settled down
		 * and depends of type of user the next view
		 */
		
		model.addAttribute("user_data_session", userdatasession);		
		//if(userdatasession.getType() == 1)
		//	return "redirect:/welcome";
		return "redirect:/welcome";
	}
	
	
	@RequestMapping(value = "/welcome")
	public String showWelcomePage(@SessionAttribute(name = "user_data_session", required=false) UserDataSession userdatasession) {
		if(userdatasession == null) return "redirect:/index";
		if(userdatasession.getType() == 0) return "redirect:/index";
		
		if(userdatasession.getType() == 1)
			return "/client/clientIndex";
		
		return "/vet/vetIndex";
	
	}
	
	@RequestMapping(value = "/logout")
	public String logout(ModelMap model) {
		UserDataSession cs = new UserDataSession();
		cs.setType(0);
		
		model.addAttribute("user_data_session", cs);
		return "redirect:/index";
	
	}
	
	// Method to get ip of this server
	public static String getIpServer() {
		Properties prop = new Properties();
		String ipServer = null;
		InputStream file = null;
		try {
			file = new FileInputStream("src/main/resources/server.properties");
			prop.load(file);
			ipServer = prop.getProperty("myserver.ip");
		}catch(IOException e) {
			System.out.println("Error in LoginController.getIpServer()");
			e.printStackTrace();
		}
		return ipServer;
	}
	
	// Method to get ip of API
	public static String getIpAPI() {
		Properties prop = new Properties();
		String ipAPI = null;
		InputStream file = null;
		try {
			file = new FileInputStream("src/main/resources/server.properties");
			prop.load(file);
			ipAPI = prop.getProperty("api.ip");
		}catch(IOException e) {
			System.out.println("Error in LoginCOntroller.getIpAPI()");
			e.printStackTrace();
		}
		return ipAPI;
	}
		
	
}
