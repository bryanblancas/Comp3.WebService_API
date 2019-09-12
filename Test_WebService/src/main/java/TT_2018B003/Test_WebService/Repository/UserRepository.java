package TT_2018B003.Test_WebService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;
import TT_2018B003.Test_WebService.Repository.Interfaces.IUserJPARepository;
import TT_2018B003.Test_WebService.Repository.Interfaces.IUserRepository;

@Repository(value = "UserRepository")
public class UserRepository implements IUserRepository {

	@Autowired
	IUserJPARepository userRepo;
	
	@Override
	public UserEntity getUserById(String idUser) {
		Optional<UserEntity> ue;
		
		ue = userRepo.findById(idUser);
		System.out.println(ue.toString());
		
		return ue.get();
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return null;
	}

}
