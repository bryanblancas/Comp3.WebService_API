package TT2018B003.comp3.API.TestAC;

import org.springframework.web.client.RestTemplate;

import TT2018B003.comp3.API.Model.DataModel;

public class TestConect {
	public static void main(String args[]) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		DataModel data = new DataModel("840f374f1824bbb22eb39c67e953f69c2aff64ad24cf4507c6446f3588b98e9");
		
		String rtn = restTemplate.postForObject("http://25.7.11.142:3001/api/verificarCertificado", data, String.class);
		
		System.out.println(rtn);
		
	}
}
