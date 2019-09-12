package TT_2018B003.Test_WebService;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;
import TT_2018B003.Test_WebService.Repository.Interfaces.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {
	
	@Qualifier("UserRepository")
	@Autowired
	IUserRepository userRepo;
	
	
	@Test
	public void test_getUserById() {
		
		String idUser = "bryan";
		
		UserEntity ue = userRepo.getUserById(idUser);
		
		Assert.assertNotNull(ue);
	}
}
