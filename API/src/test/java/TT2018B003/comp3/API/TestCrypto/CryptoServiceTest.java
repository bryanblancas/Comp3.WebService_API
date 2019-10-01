package TT2018B003.comp3.API.TestCrypto;

import org.junit.Assert;
import org.junit.Ignore;
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
	@Ignore
	public void decryptTest() {
		String encryptedMessage = "vjPb9kR2lz0/EF0Fp09fQoG+lfJsWXOAnQ+31YE2niSB+e1xijfTFxb2gCUNGHI3vqRe3hd2lK0qyEz9sjlG6dSSEZBHhvhb+ZZmqKRGhDzKa1wf/QF/yTifX0v+AQ4Ba9Fl64c32pmN1xfkSTwe4+vtrD7FAHf7E/PALT2jJn3ipPskCVAn49PbDtSRZbBsqy5b1lWo1yMDLyDVBqqavhmCezfOarEyslLzan4SEZU6DBmHoxEIarL6ybxdqAtdlATB1SzLR5DlE0JTRHLl7lkUlWGa7rDRKBVR2E6iN+wi6zA9b4hfNgM8i+x+xCsN0r/gSPctNbW296WItLh2gg==";
		String decryptedMessage = cryptoService.decryptAESKey(encryptedMessage);
		
		Assert.assertEquals("zapatito12345678", decryptedMessage);
	}
	

	
	@Test
	@Ignore
	public void decryptPattern() {
		String aesKey = "chialevaledor";
		String encryptedPattern = "U2FsdGVkX18zPrcPTwQRm5nFri/7CVwGKz9F2Kvj4GM=";
		
		String pattern = cryptoService.decryptPattern(encryptedPattern, aesKey);
		
		Assert.assertEquals("hola mundo", pattern);
	}
	
}
