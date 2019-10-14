package Comp3.ServiceWeb.Veterinaria.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.PetEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IPetRepository;

@Repository
public class PetRepository implements IPetRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PetEntity> findAllPetsByIdUser(String idUser) {
		
		String query = "SELECT * FROM pet WHERE user_idUser_client='"+idUser+"'";
		
		List<PetEntity> pets = jdbcTemplate.query(query, new PetEntityMapper());

		return pets;
	}

	@Override
	public int deletePetById(int idPet) {
		String query = "DELETE FROM pet WHERE idPet='"+idPet+"';";
		int rows_affected;
		try {
			rows_affected = jdbcTemplate.update(query);
		}catch(DataIntegrityViolationException e) {
			System.out.println("DataIntegrityViolationException PetRepository.deletePetById()");
			return 0;
		}
		return rows_affected;
	}

	@Override
	public int savePet(PetEntity pet) {
		String query = "INSERT INTO "
				+ "pet(name, day_birth, month_birth, year_birth, user_idUser_client, is_alive, type) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		int rows_affected = 0;
		
		try {
			rows_affected = jdbcTemplate.update(
								query,
								pet.getName(),
								pet.getDay_birth(),
								pet.getMonth_birth(),
								pet.getYear_birth(),
								pet.getUser_idUser_client(),
								pet.getIs_alive(),
								pet.getType()
								);
		}catch(DuplicateKeyException e) {
			System.out.println("DuplicateKeyEntry PetRepository.savePet()");
		}
		catch(DataIntegrityViolationException e) {
			System.out.println("DataIntegrityViolationException PetRepository.savePet()");
		}
		
		return rows_affected;
	}

}
