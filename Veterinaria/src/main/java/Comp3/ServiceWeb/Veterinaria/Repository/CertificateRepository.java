package Comp3.ServiceWeb.Veterinaria.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;
import Comp3.ServiceWeb.Veterinaria.Model.Entity.Mapper.CertificateEntityMapper;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.ICertificateRepository;

@Repository
public class CertificateRepository implements ICertificateRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public CertificateEntity findCertificateById(String certificate) {
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
	public int saveCertificate(CertificateEntity certificate) {
		String query = "INSERT INTO "
				+ "certificate(`certificate`,`user_data_idUser`) "
				+ "VALUES(?,?);";
		int rows_affected = 0;
		
		try {
			rows_affected = jdbcTemplate.update(
								query,
								certificate.getCertificate(),
								certificate.getUser_data_idUser()
								);
		}catch(DuplicateKeyException e) {
			System.out.println("DuplicateKeyEntry CertificateRepository.saveCertificate()");
		}
		catch(DataIntegrityViolationException e) {}
		
		return rows_affected;
		
	}

	@Override
	public CertificateEntity findCertificateByIdUser(String user_data_idUser) {
		String query = "SELECT * FROM certificate where user_data_idUser = '"+user_data_idUser+"';";
		CertificateEntity ce;
		try {
			ce = jdbcTemplate.queryForObject(query, new CertificateEntityMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return ce;
	}

	@Override
	public int deleteCertificateByCert(String certificate) {
		String query = "DELETE FROM certificate WHERE certificate='"+certificate+"';";
		int rows_affected;
		try {
			rows_affected = jdbcTemplate.update(query);
		}catch(DataIntegrityViolationException e) {
			return 0;
		}
		return rows_affected;
	}

}
