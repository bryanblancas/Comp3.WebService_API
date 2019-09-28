package TT2018B003.comp3.API.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Utils.CipherUtilityRSA;

@Service
public class CryptoService {
	
	@Autowired
	CipherUtilityRSA rsa;
	
	public String decrypt(String encryptedMessage) {
		
		PrivateKey privKey = null;
		try {
			 privKey = getPrivateKey();
			 System.out.println(privKey);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
			System.out.println("Error in CryptoService.decrypt()");
			e.printStackTrace();
		}
		
		String decryptedMessage  = null;
		try {
			decryptedMessage = rsa.decrypt(encryptedMessage, privKey);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			System.out.println("Error in CryptoService.decrypt() : decryptedMessage");
			e.printStackTrace();
		}
        
        return decryptedMessage;
	}

	public static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		PrivateKey h = null;
		return h;
		
	}
	
	
}
