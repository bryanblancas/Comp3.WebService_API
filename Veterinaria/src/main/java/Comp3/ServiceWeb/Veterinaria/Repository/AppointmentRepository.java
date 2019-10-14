package Comp3.ServiceWeb.Veterinaria.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.AppointmentEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.AppointmentEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IAppointmentRepository;

@Repository
public class AppointmentRepository implements IAppointmentRepository {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AppointmentEntity> findAllAppointmentOfPet(int idPet) {
		String query = "SELECT * FROM appointment WHERE pet_idPet='"+idPet+"'";
		
		List<AppointmentEntity> appointments = jdbcTemplate.query(query, new AppointmentEntityMapper());

		return appointments;
	}

	@Override
	public int deleteAppointmentByIdPet(int idPet) {
		String query = "DELETE FROM appointment WHERE pet_idPet='"+idPet+"'";
		
		int rows_affected;
		try {
			rows_affected = jdbcTemplate.update(query);
		}catch(DataIntegrityViolationException e) {
			System.out.println("DataIntegrityViolationException AppointmentRepository.deleteAppointmentByIdPet()");
			return -1;
		}
		return rows_affected;
	}

}
