package TT2018B003.comp3.API.Domain;

public class WinnowingModelTest {
	private String chaffing;
	private String pattern;

	public WinnowingModelTest() {}
	
	public WinnowingModelTest(String chaffing, String pattern) {
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
