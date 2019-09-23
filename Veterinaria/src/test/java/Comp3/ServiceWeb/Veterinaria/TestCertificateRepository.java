package Comp3.ServiceWeb.Veterinaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;
import Comp3.ServiceWeb.Veterinaria.Repository.Interfaces.ICertificateRepository;
import org.junit.Assert;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCertificateRepository {
	
	@Autowired
	ICertificateRepository certRepo;
	
	@Test
	public void findCertificateByIdTest() {
		String certificate = "certificate_bryanclient";
		CertificateEntity ce = certRepo.findCertificateById(certificate);
		log.info(ce.toString());
		Assert.assertNotNull(ce);
	}
	
	@Test
	public void saveCertificateTest() {
		CertificateEntity ce = new CertificateEntity("certificate_bryanvet", "as");
		int rows_affected = certRepo.saveCertificate(ce);
		Assert.assertEquals(1, rows_affected);
	}
	
}
