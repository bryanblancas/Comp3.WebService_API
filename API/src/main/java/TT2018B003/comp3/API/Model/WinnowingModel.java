package TT2018B003.comp3.API.Model;

public class WinnowingModel {
	private String chaffing;
	private String pattern;

	public WinnowingModel() {}
	
	public WinnowingModel(String chaffing, String pattern) {
		this.chaffing = chaffing;
		this.pattern = pattern;
	}
	
	public String getChaffing() {
		return chaffing;
	}

	public void setChaffing(String chaffing) {
		this.chaffing = chaffing;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String toString() {
		return "chaffing: "+chaffing+"\n"
				+"pattern: "+pattern+"\n";
	}
	
}
