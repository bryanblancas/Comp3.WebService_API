package TT2018B003.comp3.API.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.springframework.stereotype.Component;

@Component
public class SignatureUtility {
	
	/*
	 * Function that receives certificate in a correct format, i.e, ----BEGIN CERTIFICATE--- etc
	 */
	public int verifyCertificate(String certificate){
		
		X509Certificate cert;
		
		try {
		
			cert = X509Certificate.getInstance(certificate.getBytes());
			
		} catch (CertificateException e1) {
			
			System.out.println("Error getting instance SignatureUtility.verifyCertificate()");
			return -1;
			
		}
		
		try {
			try {
				
				cert.verify(getPublicKey());
				
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException
					| CertificateException | IOException e) {
				System.out.println("Error verifiying SignatureUtility.verifyCertificate()");
				return -1;
			}
			
		} catch (SignatureException e) {
			
			System.out.println("Certificado no válido con publicKey dada");
			return 0;
			
		}
		
		return 1;
		
	}
	
	public static PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		String content = "";
	    try{
	        content = new String ( Files.readAllBytes( Paths.get("src/main/resources/AC/llavePublica_AC.key") ) );
	    }
	    catch (IOException e){
	    	System.out.println("Error in SignatureUtility.getPublicKey() -> reading a file");
	        e.printStackTrace();
	    }
		
	    content = content.replace("-----BEGIN PUBLIC KEY-----", "");
	    content = content.replace("-----END PUBLIC KEY-----", "");
	    content = content.replace("\n", "");
	    content = content.replace("\r", "");
	    
		/* Generate private key. */
	    X509EncodedKeySpec X509Encode = new X509EncodedKeySpec(Base64.getDecoder().decode(content));
		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey put = kf.generatePublic(X509Encode);
		
		return put;
		
	}
}
