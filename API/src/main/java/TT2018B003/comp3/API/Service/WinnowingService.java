package TT2018B003.comp3.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TT2018B003.comp3.API.Utils.Base64u;

@Service
//@Scope("Prototype")
public class WinnowingService implements IWinnowing {

	@Autowired
	CryptoService cryptoService;
	
	private String chaffing;
	private String pattern;
	
	@Override
	public void setChaffing(String chaffing) {
		this.chaffing = chaffing;
	}
	
	@Override
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String makeWinnowing() {
		
		Base64u base64 = new Base64u();
		
		String[] patternAndAesKey = pattern.split(" ");
		String chaffingDecode = base64.decode(chaffing);
		String aesKey = cryptoService.decryptAESKey(patternAndAesKey[1]);
		String pattern = cryptoService.decryptPattern(patternAndAesKey[0], aesKey);
		
		String rtn = chaffingDecode + " : " + aesKey + " : " + pattern;
		
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
