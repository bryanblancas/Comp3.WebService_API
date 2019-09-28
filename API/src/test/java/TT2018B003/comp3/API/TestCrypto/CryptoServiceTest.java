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
		String encryptedMessage = "dAMyzxS4wcZMXb5QEJ9Tl9HhwLNM3iDRYokGRqY3bsRcJSvlwTzdMBAYQ1Q9GkioBWqj25mFwt69tkMlv4MV/eVzabApQ2cXoch7Am2nyrZIv/GPgvauzLZcQsbjkgq2hNJ4Xbf6E4pIcP6V7AbuQjP6ER2Bo/Mz9QBnnNuZOXdMSIbPmj/QWEM1rcPSMkry9mAaJPGlU3ssFUGcVdqo4uN32IOhNG6KqJZnmf1yNfwzKQv/kBIEHc2SFRS29NqhU8SizthtT49F1fn47fSPu4JDtLqp0UkjBI0KovjlufpM7FjsueCbqiMbP7m+Atn8Xu7ch1LyadEMmKxb36isFg==";
		String decryptedMessage = cryptoService.decrypt(encryptedMessage);
		
		Assert.assertEquals("chiale", decryptedMessage);
	}
}
