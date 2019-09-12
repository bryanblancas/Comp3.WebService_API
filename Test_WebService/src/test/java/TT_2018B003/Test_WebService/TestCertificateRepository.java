package TT_2018B003.Test_WebService;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import TT_2018B003.Test_WebService.Model.Entity.CertificateEntity;
import TT_2018B003.Test_WebService.Repository.Interfaces.ICertificateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCertificateRepository {

	@Autowired
	ICertificateRepository certificateRepo;
	
	@Test
	@Ignore
	public void test_getCertificateByIdUser() {
		
		String idUser = "bryan";
		CertificateEntity ce = certificateRepo.getCertificateByIdUser(idUser);
		
		System.out.println(ce.toString());
		
		Assert.assertNotNull(ce);
		Assert.assertNotNull(ce.getIdUser_User());
		Assert.assertNotNull(ce.getCertificate());
		Assert.assertNotNull(ce.getStatusCertificate());
		
	}
	
	@Test
	@Ignore
	public void test_getCertificateByIdUser2() {
		
		String idUser = "bryandfsdf";
		CertificateEntity ce = certificateRepo.getCertificateByIdUser(idUser);
		
		Assert.assertNull(ce);
		
	}
	
	@Test
	@Ignore
	public void test_searchCertificate() {
		
		String certificate = "certificate_jerry";
		CertificateEntity ce = certificateRepo.searchCertificate(certificate);
		
		System.out.println(ce.toString());
		
		Assert.assertNotNull(ce);
		Assert.assertNotNull(ce.getIdUser_User());
		Assert.assertNotNull(ce.getCertificate());
		Assert.assertNotNull(ce.getStatusCertificate());
		
	}
	
	@Test
	@Ignore
	public void test_searchCertificate2() {
		
		String certificate = "certificate_jerry2";
		CertificateEntity ce = certificateRepo.searchCertificate(certificate);
		
		Assert.assertNull(ce);
		
	}
	
	@Test
	public void test_insertCertificate() {
		
		String certificate = "certificate_jerry";
		String idUser = "jerry";
		int rows_affected = certificateRepo.insertCertificate(certificate, idUser);
		
		Assert.assertNotNull(rows_affected);
		Assert.assertEquals(1, rows_affected);
		
	}
	
}
