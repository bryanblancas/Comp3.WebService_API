package TT2018B003.comp3.API.Utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class CipherUtilityAES{
	
	private String key;
	private static final String initVector = "encryptionIntVec";
	
	public void setKey(String stringKey) {
		this.key = stringKey;
	}
	
	public String decrypt(String encrypted) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	 
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}
	
}