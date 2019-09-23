package Comp3.ServiceWeb.Veterinaria;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {
	
	@Autowired
	IUserRepository clientRepo;
	
	@Test
	@Ignore
	public void saveUserTest() {
		UserEntity client= new UserEntity(
				"prueba", "contrasena");
		
		int rows_affected = clientRepo.saveUser(client);
		Assert.assertEquals(1, rows_affected);
	}
	
	@Test
	@Ignore
	public void findUserByIdTest() {
		String idUser_client= "prueba";
		UserEntity ve = clientRepo.findUserById(idUser_client);
		log.info(ve.toString());
		Assert.assertNotNull(ve);
	}
	
	@Test
	@Ignore
	public void updateUserByIdTest() {
		UserEntity client = new UserEntity(
				"prueba", "nuevacontra");
		int rows_affected = clientRepo.updateUserById(client);
		Assert.assertEquals(1, rows_affected);
	}
	
	@Test
	public void deleteUserByIdTest() {
		String idUser_client = "prueba";
		
		int rows_affected = clientRepo.deleteUserById(idUser_client);
		
		Assert.assertEquals(1, rows_affected);
	}
	
}
