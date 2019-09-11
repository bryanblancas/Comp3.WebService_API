package TT2018B003.comp3.API.TestRestAPI;

import org.springframework.web.client.RestTemplate;
import TT2018B003.comp3.API.Domain.WinnowingModelTest;

public class TestRestAPI {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/API/v1/winnowing";

		WinnowingModelTest data = new WinnowingModelTest();
		data.setChaffing("Hola mundo chaffing");
		data.setPattern("pattern");
		
		String a = restTemplate.postForObject(url, data, String.class);
		System.out.println(a);
		
		/*user.setEmail("admin@gmail.com");
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setCreatedBy("admin");
		user.setUpdatedBy("admin");
		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
		*/
		
		
	}
}
