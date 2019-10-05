package Comp3.ServiceWeb.Veterinaria;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IVetRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVetRepository {
	
	@Autowired
	IVetRepository vetRepo;
	
	@Test
	@Ignore
	public void saveVetTest() {
		VetEntity vet = new VetEntity(
				"prueba", "contrasena");
		
		int rows_affected = vetRepo.saveVet(vet);
		Assert.assertEquals(1, rows_affected);
	}
	
	@Test
	@Ignore
	public void findVetByIdTest() {
		String idUser_vet = "prueba";
		VetEntity ve = vetRepo.findVetById(idUser_vet);
		log.info(ve.toString());
		Assert.assertNotNull(ve);
	}
	
	@Test
	@Ignore
	public void updateVetByIdTest() {
		VetEntity vet = new VetEntity(
				"prueba", "nuevacontra");
		int rows_affected = vetRepo.updateVetById(vet);
		Assert.assertEquals(1, rows_affected);
	}
	
	@Test
	public void deleteVetByIdTest() {
		String idUser_vet = "prueba";
		
		int rows_affected = vetRepo.deleteVetById(idUser_vet);
		
		Assert.assertEquals(1, rows_affected);
	}
	
	
}
