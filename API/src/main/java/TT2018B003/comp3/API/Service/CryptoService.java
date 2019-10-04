package TT2018B003.comp3.API.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Utils.CipherUtilityAES;
import TT2018B003.comp3.API.Utils.CipherUtilityRSA;
import TT2018B003.comp3.API.Utils.CipherUtilitySHA256;

@Service
public class CryptoService {
	
	@Autowired
	CipherUtilityRSA rsa;
	
	@Autowired
	CipherUtilityAES aes;
	
	@Autowired
	CipherUtilitySHA256 sha256;
	
	
	public String doSHA(String message) {
		String sha = null;
		try {
			sha = sha256.doSHA(message);
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			System.out.println("Error in CryptoService.doSHA()");
			e.printStackTrace();
		}
		return sha;
	}
	
	public String decryptAESKey(String encryptedMessage) {
		
		PrivateKey privKey = null;
		try {
			 privKey = getPrivateKey();
			 //System.out.println(privKey);
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
	
	public String decryptPattern(String encryptedPattern, String aesKey) {
		//aes.setKey(aesKey);
		String pattern = null;
		try {
			
			pattern = aes.decrypt(encryptedPattern, aesKey);
		
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			
			System.out.println("Error en CryptoService.decryptPattern()");
			e.printStackTrace();
			
		}
		
		return pattern;
	}

	public static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		String content = "";
	    try{
	        content = new String ( Files.readAllBytes( Paths.get("src/main/resources/privatekey_p8.pem") ) );
	    }
	    catch (IOException e){
	    	System.out.println("Error in CryptoService.getPrivateKey() -> reading a file");
	        e.printStackTrace();
	    }
		
	    content = content.replace("-----BEGIN PRIVATE KEY-----", "");
	    content = content.replace("-----END PRIVATE KEY-----", "");
	    content = content.replace("\n", "");
	    content = content.replace("\r", "");
	    
		/* Generate private key. */
		PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(content));
		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey pvt = kf.generatePrivate(keySpecPKCS8);
		
		return pvt;
		
	}
	
	
}
