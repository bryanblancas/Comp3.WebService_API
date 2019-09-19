package Comp3.ServiceWeb.Veterinaria.Services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateCredentials(String idUser, String password) {
		if(idUser.equals("prueba") && password.equals("prueba"))
			return true;
		return false;
	}
}
