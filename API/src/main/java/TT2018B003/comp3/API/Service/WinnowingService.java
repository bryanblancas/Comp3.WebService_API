package TT2018B003.comp3.API.Service;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import TT2018B003.comp3.API.Model.DataModel;
import TT2018B003.comp3.API.Utils.Base64u;

@Service
public class WinnowingService implements IWinnowing {

	@Autowired
	CryptoService cryptoService;
	@Autowired
	Base64u base64;
	
	private String chaffing;
	private String pattern;
	
	private static String dirServA = "http://10.100.68.109:3001";
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
   private static String validateCert(String shaUser) {
	   	RestTemplate restTemplate = new RestTemplate();		
		DataModel data = new DataModel(shaUser);		
	   return restTemplate.postForObject(dirServA+"/api/verificarCertificado", data, String.class);
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
		System.out.println("patt_s: "+patt.length+" chaff_s: "+chaffingByte.length);
		/*AQUIIII ESTÁ TODO EL TT*/
		String cab = "";
		String cert = "";
		try {
		for(int i = 0 ; i<patt.length ;i++) {
			if(patt[i]) {
				cab+=chaffingByte[i] == true ? '1' : '0';
			}else {
				cert+=chaffingByte[i] == true ? '1' : '0';
			}
		}
		
		System.out.println("Cabecera: "+arraybytetoString(arraybytetoBite(cab)));
		
		byte[] certificado = arraybytetoBite(cert);
		String certificate = arraybytetoString(certificado).replace("\r", "").replace("\n", "");
		System.out.println("Cert: "+certificate);
		String[] dataCert = getDataCert(certificado);	
		//Se verifica si el certificado fue emitido por la AC
		if(dataCert != null && cryptoService.verifyCertificate(getCert(certificate))==1 ) {
			String email = dataCert[0].split("=")[1];
			String shaEmail = cryptoService.doSHA(email);
		
			System.out.println("SHA_CERT:");			
			String shaCert = cryptoService.doSHA(certificate);			
			String response = validateCert(shaEmail);
			
			System.out.println(certificate+" : "+response);
			if(response.equals("0")) {
				System.out.println("No existe el usuario");
				return "0 0";
			} else if(response.equals(shaCert)) {
				System.out.println("Certificado válido");
				return certificate+" 1";
			} else {
				System.out.println("El usuario cambió de certificado");
				return"0 2";
			}

		}
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			
		}
		System.out.println("ERROR en el certificadooo");
		return "0 0";
		
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
