package Comp3.ServiceWeb.Veterinaria.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.User_dataEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.User_dataEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.IUser_dataRepository;

@Repository(value = "User_dataRepository")
public class User_dataRepository implements IUser_dataRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User_dataEntity findUserById(String idUser){
		
		String query = "SELECT * FROM user_data where idUser = '"+idUser+"';";
		User_dataEntity ue;
		try {
			ue = jdbcTemplate.queryForObject(query, new User_dataEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ue;
		
	}

	@Override
	public int saveUser_data(User_dataEntity user) {
		String query = "INSERT INTO "
				+ "user_data(`name`, `first_lastname`, `second_lastname`, `day_birth`, `month_birth`, `year_birth`, `email`, `idUser`) "
				+ "VALUES(?,?,?,?,?,?,?,?);";  
		int rows_affected = 0;
		
		try {
			rows_affected= jdbcTemplate.update(query, 
												user.getName(), 
												user.getFirst_lastname(), 
												user.getSecond_lastname(), 
												user.getDay_birth(), 
												user.getMonth_birth(), 
												user.getYear_birth(), 
												user.getEmail(), 
												user.getIdUser()
											);
		}catch(DuplicateKeyException e) {}

		return rows_affected;
	}

	@Override
	public int updateUser_dataById(User_dataEntity user) {
		String query = "UPDATE user_data SET "
				+ "name=?, "
				+ "first_lastname=?, "
				+ "second_lastname=?, "
				+ "day_birth=?, "
				+ "month_birth=?, "
				+ "year_birth=?, "
				+ "email=? "
				+ "WHERE idUser='"+user.getIdUser()+"';";
		
		int rows_affected;
		
		rows_affected = jdbcTemplate.update(
				query,
				user.getName(),
				user.getFirst_lastname(),
				user.getSecond_lastname(),
				user.getDay_birth(),
				user.getMonth_birth(),
				user.getYear_birth(),
				user.getEmail()
				);
		
		return rows_affected;
	}

	@Override
	public int deleteUser_dataById(String idUser) {
		String query = "DELETE FROM user_data WHERE idUser='"+idUser+"';";
		int rows_affected;
		try {
			rows_affected = jdbcTemplate.update(query);
		}catch(DataIntegrityViolationException e) {
			return 0;
		}
		return rows_affected;
	}
	
	
	
}