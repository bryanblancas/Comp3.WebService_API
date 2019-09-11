package TT_2018B003.Test_WebService.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import TT_2018B003.Test_WebService.Model.Entity.UserEntity;

public class UserEntityMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity ue = new UserEntity();
		ue.setIdUser(rs.getString("idUser"));
		ue.setPassword(rs.getString("password"));
		return ue;
	}

}
