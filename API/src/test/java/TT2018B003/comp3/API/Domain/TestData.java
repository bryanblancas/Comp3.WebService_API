package TT2018B003.comp3.API.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestData {
	private String chaffing;
	
	public void setChaffing(String chaffing) {
		this.chaffing = chaffing;
	}
	
	public String getChaffing() {
		return this.chaffing;
	}
	
}
