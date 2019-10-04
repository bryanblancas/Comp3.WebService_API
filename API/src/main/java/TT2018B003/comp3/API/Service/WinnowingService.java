package TT2018B003.comp3.API.Service;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Model.CertificateModel;
import TT2018B003.comp3.API.Utils.Base64u;

@Service
public class WinnowingService implements IWinnowing {

	@Autowired
	CryptoService cryptoService;
	@Autowired
	Base64u base64;
	
	private String chaffing;
	private String pattern;
	
	@Override
	public void setChaffing(String chaffing) {
		this.chaffing = chaffing;
	}
	
	private static String booleantoString(boolean[] pattern) {
        String out = "";
        for (boolean x : pattern) {
            out += x == true ? '1' : '0';
        }
        return out;
    }
	
	private static String booleantoString(Boolean[] pattern) {
        String out = "";
        for (Boolean x : pattern) {
            out += x.booleanValue() == true ? '1' : '0';
        }
        return out;
    }

    private static boolean[] stringtoBoolean(String patt) {
        boolean[] out = new boolean[patt.length() * 8];

        	for(int i = 0; i < patt.length(); i++) {
        		int val = patt.charAt(i);
        		for(int j = 0 ; j < 8 ; j++) {
        			out[(i*8) + j] = (val & 128) == 0 ? false : true;
        			val <<= 1;
        		}
        	}
        
        
        return out;
    }
    
    private static byte[] arraybytetoBite(String array) {
    	byte[] bites = new byte[array.length()/8];
    	
    	String[] bytes = array.split("(?<=\\G.{8})");
    	
    	for(int i = 0 ; i < bytes.length ; i++) {
    		bites[i] = Byte.parseByte(bytes[i],2);
    		
    	}
    	return bites;
    }
    
    private static String arraybytetoString(byte[] array) {
    	String out = "";
    	for(byte i : array) {
    		out+= (char) i;
    	}
    	return out;
    }
    
    private static String getCert(String cert) {
    	return "-----BEGIN CERTIFICATE-----\r\n"+cert+"\r\n" + 
    			"-----END CERTIFICATE-----\r\n" ;
    }
    
   private static String[] getDataCert(byte[] cert) {
	   String[] data = null;
	   try {
			X509Certificate certF = X509Certificate.getInstance(getCert(arraybytetoString(cert)).getBytes());
			System.out.println(certF.getSubjectDN().getName());
			data = certF.getSubjectDN().getName().split(",");
			
		} catch (CertificateException e) {
			System.out.println("Error al obtener certificado");
			e.printStackTrace();
		}
	   
	   return data;
   }

	@Override
	public String makeWinnowing() {
		
		String[] patternAndAesKey = pattern.split(" ");
		String chaffingDecode = base64.decode(chaffing);
		String aesKey = cryptoService.decryptAESKey(patternAndAesKey[1]);
		String pattern = cryptoService.decryptPattern(patternAndAesKey[0], aesKey);
		
		/*Winnowing*/
		boolean[] patt = stringtoBoolean(pattern);
		boolean[] chaffingByte = stringtoBoolean(chaffingDecode);
		/*AQUIIII ESTÁ TODO EL TT*/
		String cab = "";
		String cert = "";
		
		for(int i = 0 ; i<patt.length ;i++) {
			if(patt[i]) {
				cab+=chaffingByte[i] == true ? '1' : '0';
			}else {
				cert+=chaffingByte[i] == true ? '1' : '0';
			}
		}
		
		byte[] certificado = arraybytetoBite(cert);
		String certificate = arraybytetoString(certificado).replace("\r", "").replace("\n", "");
		
		String[] dataCert = getDataCert(certificado);		
		if(dataCert != null) {
			String email = dataCert[0].split("=")[1];
			String shaEmail = cryptoService.doSHA(email);
			
			/*
			 * 
			 * Llamada a AC para validar status de Certificado
			 * 
			 */
			
			
			return certificate+" 1";
			
		}
		
		return " 0";
		
	}

	@Override
	public String getChaffing() {
		return chaffing;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	@Override
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
