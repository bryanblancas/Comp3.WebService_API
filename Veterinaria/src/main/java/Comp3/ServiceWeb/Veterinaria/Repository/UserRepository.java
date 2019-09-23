package Comp3.ServiceWeb.Veterinaria.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.UserEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.UserEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveUser(UserEntity client) {
		String query = "INSERT INTO "
				+ "user(`password`, `idUser_client`) "
				+ "VALUES(?,?);";  
		
		int rows_affected = 0;
		
		try {
			rows_affected= jdbcTemplate.update(query, 
												client.getPassword(), 
												client.getIdUser_client()
											);
		}catch(DuplicateKeyException e) {}
		
		return rows_affected;
	}

	@Override
	public UserEntity findUserById(String idUser_client) {
		String query = "SELECT * FROM user WHERE idUser_client = '"+idUser_client+"';";
		UserEntity ue;
		try {
			ue = jdbcTemplate.queryForObject(query, new UserEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ue;
	}

	@Override
	public int updateUserById(UserEntity client) {
		
		String query = "UPDATE user SET password=? WHERE idUser_client='"+client.getIdUser_client()+"';";
		int rows_affected;
		
		rows_affected = jdbcTemplate.update(query, client.getPassword());
		
		return rows_affected;
		
	}

	@Override
	public int deleteUserById(String idUser_client) {
		String query = "DELETE FROM user WHERE idUser_client='"+idUser_client+"';";
		int rows_affected;
		
		rows_affected = jdbcTemplate.update(query);
		
		return rows_affected;
	}

}
