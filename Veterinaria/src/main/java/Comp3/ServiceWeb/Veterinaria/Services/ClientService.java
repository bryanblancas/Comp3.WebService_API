package Comp3.ServiceWeb.Veterinaria.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.AppointmentEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.AppointmentRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.PetRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.User_dataRepository;

@Service
public class ClientService {
	@Autowired
	PetRepository petRepo;
	
	@Autowired 
	AppointmentRepository appRepo;
	
	@Autowired
	User_dataRepository user_dataRepo;
	
	public List<PetEntity> getClientPets(String idUser){
		return petRepo.findAllPetsByIdUser(idUser);
	}
	
	public int deleteByIdPet(int idPet) {
		int rows_affected_app = appRepo.deleteAppointmentByIdPet(idPet);
		
		if(rows_affected_app != -1) {
			int rows_affected = petRepo.deletePetById(idPet);
			
			if(rows_affected == 1)
				return 1;
			else
				return 0;
		}
		
		return -1;
		
	}
		
	public List<AppointmentEntity> findAllAppointmentOfPet(int idPet){
		return appRepo.findAllAppointmentOfPet(idPet);
	}
	
	public int savePet(PetEntity pe) {
		return petRepo.savePet(pe);
	}
	
	public User_dataEntity findVet(String idVet) {
		return user_dataRepo.findUserById(idVet);
	}
	
}
