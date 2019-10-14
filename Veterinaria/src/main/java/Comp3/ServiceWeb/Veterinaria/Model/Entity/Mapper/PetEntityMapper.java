package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.PetEntity;

public class PetEntityMapper implements RowMapper<PetEntity>{

	@Override
	public PetEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PetEntity pe = new PetEntity();
		
		pe.setIdPet(rs.getInt("idPet"));
		pe.setName(rs.getString("name"));
		pe.setDay_birth(rs.getInt("day_birth"));
		pe.setMonth_birth(rs.getInt("month_birth"));
		pe.setYear_birth(rs.getInt("year_birth"));
		pe.setUser_idUser_client(rs.getString("user_idUser_client"));
		pe.setIs_alive(rs.getShort("is_alive"));
		pe.setType(rs.getString("type"));
		
		return pe;
		
	}

}
