package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.VetEntity;

public class VetEntityMapper implements RowMapper<VetEntity> {

	@Override
	public VetEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		VetEntity ve = new VetEntity();
		
		ve.setPassword(rs.getString("password"));
		ve.setIdUser_vet(rs.getString("idUser_vet"));
		
		return ve;
	}

}
