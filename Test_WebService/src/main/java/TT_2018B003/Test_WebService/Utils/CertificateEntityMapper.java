package TT_2018B003.Test_WebService.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import TT_2018B003.Test_WebService.Model.Entity.CertificateEntity;

public class CertificateEntityMapper implements RowMapper<CertificateEntity>{

	@Override
	public CertificateEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		CertificateEntity ce = new CertificateEntity();
		ce.setIdUser_User(rs.getString("idUser_User"));
		ce.setCertificate(rs.getString("certificate"));
		ce.setStatusCertificate(rs.getInt("statusCertificate"));
		return ce;
	}

}
