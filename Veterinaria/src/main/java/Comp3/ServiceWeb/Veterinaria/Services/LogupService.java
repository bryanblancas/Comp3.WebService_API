package Comp3.ServiceWeb.Veterinaria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUserRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUser_dataRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IVetRepository;

@Service
public class LogupService {
	
	@Qualifier("User_dataRepository")
	@Autowired
	IUser_dataRepository userRepo;
	
	@Autowired
	IUserRepository clientRepo;
	
	@Autowired
	IVetRepository vetRepo;
	
	public boolean existUser(User_dataEntity user_data) {
		User_dataEntity user = userRepo.findUserById(user_data.getIdUser());
		if(user == null)
			return false;
		return true;
	}
	
	public int saveUser(User_dataEntity user_data, UserEntity client) {
		int rows_affected_user_data = userRepo.saveUser_data(user_data);
		int rows_affected_user = clientRepo.saveUser(client);
		
		if((rows_affected_user & rows_affected_user_data) == 1)
			return 1;
		return 0;
	}
	
	public int saveUser(User_dataEntity user_data, VetEntity vet) {
		int rows_affected_user_data = userRepo.saveUser_data(user_data);
		int rows_affected_vet = vetRepo.saveVet(vet);
		
		if((rows_affected_vet & rows_affected_user_data) == 1)
			return 1;
		return 0;
	}
	
}
