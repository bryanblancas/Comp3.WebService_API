package TT_2018B003.Test_WebService.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import TT_2018B003.Test_WebService.Model.Entity.CertificateEntity;
import TT_2018B003.Test_WebService.Repository.Interfaces.ICertificateRepository;
import TT_2018B003.Test_WebService.Utils.CertificateEntityMapper;

@Repository
public class CertificateRepository implements ICertificateRepository {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public CertificateEntity getCertificateByIdUser(String idUser_User) {
		String query = "SELECT * FROM certificate where idUser_User = '"+idUser_User+"';";
		CertificateEntity ce;
		try {
			ce = jdbcTemplate.queryForObject(query, new CertificateEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ce;
	}

	@Override
	public CertificateEntity searchCertificate(String certificate) {
		String query = "SELECT * FROM certificate where certificate = '"+certificate+"';";
		CertificateEntity ce;
		try {
			ce = jdbcTemplate.queryForObject(query, new CertificateEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ce;
	}

	@Override
	public int insertCertificate(String certificate, String idUser_User) {
		String query = "INSERT INTO certificate (certificate, statusCertificate, idUser_User) values (?, ?, ?)";
		int rows_affected = jdbcTemplate.update(query, certificate, 1, idUser_User);
		return rows_affected;
	}

}
