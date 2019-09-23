package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;

public class User_dataEntityMapper implements RowMapper<User_dataEntity> {
	
	@Override
	public User_dataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User_dataEntity ue = new User_dataEntity();
		
		ue.setIdUser(rs.getString("idUser"));
		ue.setName(rs.getString("name"));
		ue.setFirst_lastname(rs.getString("first_lastname"));
		ue.setSecond_lastname(rs.getString("second_lastname"));
		ue.setDay_birth(rs.getInt("day_birth"));
		ue.setMonth_birth(rs.getInt("month_birth"));
		ue.setYear_birth(rs.getInt("year_birth"));
		ue.setEmail(rs.getString("email"));
		
		return ue;
	}
}
