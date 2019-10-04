package TT2018B003.comp3.API.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.stereotype.Component;

@Component
public class CipherUtilitySHA256 {
	
	public String doSHA(String message) throws NoSuchAlgorithmException, NoSuchProviderException {
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		byte[] messageByteArray = message.getBytes();
		
		sha256.update(messageByteArray);
		
		String cipherMessage = bytesToHex(sha256.digest());
		
		System.out.println("SHA256: " + cipherMessage);
		
		return cipherMessage;
	}
	
	private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
	
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
