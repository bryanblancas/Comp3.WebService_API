package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.AppointmentEntity;

public class AppointmentEntityMapper implements RowMapper<AppointmentEntity>{

	@Override
	public AppointmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AppointmentEntity ae = new AppointmentEntity();
		
		ae.setIdAppointment(rs.getInt("idAppointment"));
		ae.setDay(rs.getInt("day"));
		ae.setMonth(rs.getInt("month"));
		ae.setYear(rs.getInt("year"));
		ae.setPet_idPet(rs.getInt("pet_idPet"));
		ae.setVet_idUser_vet(rs.getString("vet_idUser_vet"));
		ae.setPrescription(rs.getString("prescription"));
		
		return ae;
		
	}

}
