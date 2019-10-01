package TT2018B003.comp3.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Utils.Base64u;

@Service
public class WinnowingService implements IWinnowing {
	@Autowired
	CryptoService cryptoservice;
	
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
		Base64u b64 = new Base64u();
		System.out.println(chaffing+" : "+pattern);
		/*String rsap = pattern.split(" ")[1];
		System.out.println("LALLAVEEEEEE "+rsap);
		String aesk = cryptoservice.decryptAESKey(rsap);
		return b64.decode(chaffing)+":"+pattern+" : "+aesk;*/
		//boolean[] patt = patternF(b64.decode(pattern));
		

		
		//return patterntoString(patt) + " ----- " + patterntoString(patternF(b64.decode(chaffing));
		//return b64.decode(pattern) + " ----- " + b64.decode(chaffing);
		return  b64.decode(chaffing);
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
