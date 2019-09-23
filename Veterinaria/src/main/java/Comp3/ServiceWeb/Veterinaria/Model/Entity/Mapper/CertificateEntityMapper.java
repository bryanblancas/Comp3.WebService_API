package Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;

public class CertificateEntityMapper implements RowMapper<CertificateEntity> {

	@Override
	public CertificateEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CertificateEntity ce = new CertificateEntity();
		
		ce.setCertificate(rs.getString("certificate"));
		ce.setUser_data_idUser(rs.getString("user_data_idUser"));
		
		return ce;
	}

}
