package TT2018B003.comp3.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

	@Override
	public String makeWinnowing() {
		
		//Base64u base64 = new Base64u();
		
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
		
		
		
		return cert + " : " + aesKey + " : " + booleantoString(patt);
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
