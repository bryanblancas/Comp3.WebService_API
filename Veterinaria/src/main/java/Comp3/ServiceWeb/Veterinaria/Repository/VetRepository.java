package Comp3.ServiceWeb.Veterinaria.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.VetEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IVetRepository;

@Repository
public class VetRepository implements IVetRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveVet(VetEntity vet) {
		
		String query = "INSERT INTO "
				+ "vet(`password`, `idUser_vet`) "
				+ "VALUES(?,?);";  
		
		int rows_affected = 0;
		
		try {
			rows_affected= jdbcTemplate.update(query, 
												vet.getPassword(), 
												vet.getIdUser_vet()
											);
		}catch(DuplicateKeyException e) {}
		
		return rows_affected;
		
	}

	@Override
	public VetEntity findVetById(String idUser_vet) {
		
		String query = "SELECT * FROM vet WHERE idUser_vet = '"+idUser_vet+"';";
		VetEntity ve;
		try {
			ve = jdbcTemplate.queryForObject(query, new VetEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ve;
		
	}

	@Override
	public int updateVetById(VetEntity vet) {
		
		String query = "UPDATE vet SET password=? WHERE idUser_vet='"+vet.getIdUser_vet()+"';";
		int rows_affected;
		
		rows_affected = jdbcTemplate.update(query, vet.getPassword());
		
		return rows_affected;
		
	}

	@Override
	public int deleteVetById(String idUser_vet) {
	
		String query = "DELETE FROM vet WHERE idUser_vet='"+idUser_vet+"';";
		int rows_affected;
		
		rows_affected = jdbcTemplate.update(query);
		
		return rows_affected;
	
	}

	@Override
	public List<VetEntity> getAllVets() {
		String query = "SELECT * FROM vet";
		
		List<VetEntity> vets = jdbcTemplate.query(query, new VetEntityMapper());

		return vets;
	}

}
