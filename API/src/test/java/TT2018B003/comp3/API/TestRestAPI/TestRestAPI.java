package TT2018B003.comp3.API.TestRestAPI;

import org.springframework.web.client.RestTemplate;

public class TestRestAPI {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/API/v1/chaffing/holamundo";
		String a = restTemplate.getForObject(url, String.class);
		System.out.println(a);
	}
}
