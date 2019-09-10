package TT2018B003.comp3.API.Service;

import org.springframework.stereotype.Service;

@Service
public class WinnowingService implements IWinnowing {

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
		return "Hola";
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
