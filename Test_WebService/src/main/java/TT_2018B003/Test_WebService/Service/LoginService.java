package TT_2018B003.Test_WebService.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userID, String password) {
		if (userID.equals("prueba") && password.equals("prueba"))
			return true;
		return false;
	}
}
