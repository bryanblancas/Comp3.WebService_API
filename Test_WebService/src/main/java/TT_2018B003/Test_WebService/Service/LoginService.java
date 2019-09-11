package TT_2018B003.Test_WebService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;
import TT_2018B003.Test_WebService.Repository.IUserRepository;

@Service
public class LoginService {
	
	@Qualifier("UserRepositoryManual")
	@Autowired
	IUserRepository userRepo;

	public boolean validateUser(String idUser, String password) {
		UserEntity ue = userRepo.getUserById(idUser);
		if(ue == null)
			return false;
		if(!ue.getPassword().equals(password))
			return false;
		return true;
	}
}
