package Comp3.ServiceWeb.Veterinaria;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUser_dataRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser_dataRepository {
	
	@Qualifier("User_dataRepository")
	@Autowired
	IUser_dataRepository userRepo;
	
	@Test
	@Ignore
	public void findUserByIdTest() {
		String idUser = "bryanblancas";
		User_dataEntity user = userRepo.findUserById(idUser);
		log.info(user.toString());
		Assert.assertNotNull(user);
	}
	
	@Test
	@Ignore
	public void saveUser_dataTest() {
		User_dataEntity user = new User_dataEntity(
				"prueba", "nombresuper prueba", "blancas", "perez", 10, 11, 1997, "5@5.com");
		
		int rows_affected = userRepo.saveUser_data(user);
		Assert.assertEquals(0, rows_affected);
	}
	
	@Test
	@Ignore
	public void updateUser_dataByIdTest() {
		User_dataEntity user = new User_dataEntity(
				"prueba", "nombresuper prueba", "blancas", "perez", 10, 11, 1997, "5@5.com");
		
		int rows_affected = userRepo.updateUser_dataById(user);
		Assert.assertEquals(1, rows_affected);
		
	}
	
	
	@Test
	public void deleteUser_dataByIdTest() {
		String idUser = "bryanblancas";
		
		int rows_affected = userRepo.deleteUser_dataById(idUser);
		
		Assert.assertEquals(1, rows_affected);
	}
	
}
