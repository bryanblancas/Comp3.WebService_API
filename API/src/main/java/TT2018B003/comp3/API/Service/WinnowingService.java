package TT2018B003.comp3.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Utils.Base64u;

@Service
public class WinnowingService implements IWinnowing {

	@Autowired
	CryptoService cryptoService;
	
	private String chaffing;
	private String pattern;
	
	@Override
	public void setChaffing(String chaffing) {
		this.chaffing = chaffing;
	}
	
	private static String patterntoString(boolean[] pattern) {
        String out = "";
        for (boolean x : pattern) {
            out += x == true ? '1' : '0';
        }
        return out;
    }

    private static boolean[] patternF(String patt) {
        boolean[] out = new boolean[patt.length() * 8];
        /*for (int i = 0; i < patt.length(); i++) {
            String aux = Integer.toBinaryString(patt.charAt(i));
            for (int j = 0; j < aux.length(); j++) {
                out[(i*8) + j] = aux.charAt(j) == '1' ? true : false;
            }
        }*/

        	for(int i = 0; i < patt.length(); i++) {
        		int val = patt.charAt(i);
        		String aux = Integer.toBinaryString(patt.charAt(i));
        		for(int j = 0 ; j < 8 ; j++) {
        			out[(i*8) + j] = (val & 128) == 0 ? false : true;
        			val <<= 1;
        		}
        	}
        
        
        return out;
    }

	@Override
	public String makeWinnowing() {
		
		Base64u base64 = new Base64u();
		
		String[] patternAndAesKey = pattern.split(" ");
		String chaffingDecode = base64.decode(chaffing);
		String aesKey = cryptoService.decryptAESKey(patternAndAesKey[1]);
		String pattern = cryptoService.decryptPattern(patternAndAesKey[0], aesKey);
		
		String rtn = chaffingDecode + " : " + aesKey + " : " + pattern;
		ystem.out.println(chaffing+" : "+pattern);
		/*String rsap = pattern.split(" ")[1];
		System.out.println("LALLAVEEEEEE "+rsap);
		String aesk = cryptoservice.decryptAESKey(rsap);
		return b64.decode(chaffing)+":"+pattern+" : "+aesk;*/
		//boolean[] patt = patternF(b64.decode(pattern));
		

		
		//return patterntoString(patt) + " ----- " + patterntoString(patternF(b64.decode(chaffing));
		//return b64.decode(pattern) + " ----- " + b64.decode(chaffing);
		return  b64.decode(chaffing);
		return rtn;
	}

	@Override
	public String getChaffing() {
		return chaffing;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

}
