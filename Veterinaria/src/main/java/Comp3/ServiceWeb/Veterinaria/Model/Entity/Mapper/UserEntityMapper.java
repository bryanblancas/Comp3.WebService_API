package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;

public class UserEntityMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity ue = new UserEntity();
		
		ue.setPassword(rs.getString("password"));
		ue.setIdUser_client(rs.getString("idUser_client"));
		
		return ue;
	}

}
