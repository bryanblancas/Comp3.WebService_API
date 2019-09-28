package TT2018B003.comp3.API.TestCrypto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TT2018B003.comp3.API.Service.CryptoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CryptoServiceTest {

	@Autowired
	CryptoService cryptoService;
	
	@Test
	public void decryptTest() {
		String encryptedMessage = "woafjaX37sb977td12+KpMyUTSujICKPAM+VCG2ouqz409/YQYPtcWS8SLpky4RCli1yctvbjrGVUWc3JQAGf3oqNHLMr4SOtlLF2iatPrFLTdZyYtbSiqLvC0dZx3bxhgIohp/MgxaRawszs9+RG+kmPXg/Y/zCqG+eQQqVyicECn9rHeJ6CXUFvEDM783S4mtiieyHHw6NKkyznDkXk6LPPLXDJYGGraZjwU8z0zWaPAxqH9toKkjubbZeG2iMRRr1LVh9W03abXFrgOpVcBtd1oakk8hKEtBWIpishni2hsQ3J4ju1Eu9sBDjjb6FxnwdPONqkz1agA3K9IN+EQ==";
		String decryptedMessage = cryptoService.decryptAESKey(encryptedMessage);
		
		Assert.assertEquals("chiale", decryptedMessage);
	}
	
	@Test
	public void decryptPattern() {
		String aesKey = "chialechialechia";
		String encryptedPattern = "U2FsdGVkX19FYn7+cApP7HTacvZoUEbfjYsIv1NqEdM=";
		
		String pattern = cryptoService.decryptPattern(encryptedPattern, aesKey);
		
		Assert.assertEquals("hola mundo", pattern);
	}
	
}
