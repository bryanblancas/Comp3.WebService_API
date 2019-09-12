package TT_2018B003.Test_WebService.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import TT_2018B003.Test_WebService.Model.Entity.UserEntity;
import TT_2018B003.Test_WebService.Repository.Interfaces.IUserRepository;
import TT_2018B003.Test_WebService.Utils.UserEntityMapper;

@Repository(value = "UserRepositoryManual")
public class UserRepositoryManual implements IUserRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public UserEntity getUserById(String idUser) {
		String query = "SELECT * FROM user where idUser = '"+idUser+"';";
		UserEntity ue;
		try {
			ue = jdbcTemplate.queryForObject(query, new UserEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ue;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
