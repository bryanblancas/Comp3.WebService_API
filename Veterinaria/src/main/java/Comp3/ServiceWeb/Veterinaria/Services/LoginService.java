package Comp3.ServiceWeb.Veterinaria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Comp3.ServiceWeb.Veterinaria.Model.UserDataSession;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.ICertificateRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUserRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUser_dataRepository;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IVetRepository;

@Service
public class LoginService {
	
	@Autowired
	IUser_dataRepository userRepo;
	
	@Autowired
	IUserRepository clientRepo;
	
	@Autowired
	IVetRepository vetRepo;
	
	@Autowired
	ICertificateRepository certRepo;
	
	public UserDataSession validateCredentials(String idUser, String password) {
		
		UserDataSession userdatasession = new UserDataSession();
		
		User_dataEntity user = userRepo.findUserById(idUser);
		if(user == null)
			return null;
		
		/*Exist User_Data*/
		userdatasession.setUser(user);
		
		UserEntity client = clientRepo.findUserById(idUser);
		if(client != null) {
			/*Exist in user*/
			if(password.equals(client.getPassword())) {
				userdatasession.setType(1);
				return userdatasession;
			}
			return null;
		}
		
		VetEntity vet = vetRepo.findVetById(idUser);
		if(vet != null) {
			/*Exist in vet*/
			if(password.equals(vet.getPassword())) {
				userdatasession.setType(2);
				return userdatasession;
			}
			return null;
		}
		
		return null;
		
	}
	
	public UserDataSession getUserDataSessionById(String idUser) {
		
		UserDataSession userdatasession = new UserDataSession();
		
		User_dataEntity user = userRepo.findUserById(idUser);
		if(user == null)
			return null;
		
		/*Exist User_Data*/
		userdatasession.setUser(user);
		
		UserEntity client = clientRepo.findUserById(idUser);
		if(client != null) {
			userdatasession.setType(1);
			return userdatasession;
		}
		
		VetEntity vet = vetRepo.findVetById(idUser);
		if(vet != null) {
			userdatasession.setType(2);
			return userdatasession;
			
		}
		
		return null;
		
	}
	
	public CertificateEntity checkCertificateExistance(String certificate) {
		CertificateEntity ce = null;
		
		ce = certRepo.findCertificateById(certificate);
		
		return ce;
	}
	
	public int saveCertificate(CertificateEntity ce) {
		
		CertificateEntity existcert = certRepo.findCertificateByIdUser(ce.getUser_data_idUser());
		
		if(existcert != null){
			certRepo.deleteCertificateByCert(existcert.getCertificate());
		}
		
		int rows_affected = certRepo.saveCertificate(ce);
		return rows_affected;
	}

	public int deleteCertificateByCert(String certificate) {
		int rows_affected = certRepo.deleteCertificateByCert(certificate);
		return rows_affected;
	}
}
