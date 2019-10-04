package TT2018B003.comp3.API.TestAC;

import org.springframework.web.client.RestTemplate;

public class TestConect {
	public static void main(String args[]) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		DataModel data = new DataModel("555");
		
		String rtn = restTemplate.postForObject("http://25.7.11.142:3001/api/verificarCertificado", data, String.class);
		
		System.out.println(rtn);
		
	}
}
