package TT2018B003.comp3.API.TestRestAPI;

import org.springframework.web.client.RestTemplate;
import TT2018B003.comp3.API.Domain.WinnowingModelTest;

public class TestRestAPI {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8083/API/v1/winnowing";

		WinnowingModelTest data = new WinnowingModelTest();
		data.setChaffing("bRitgdo081Jym2tkTchQ3B0MyZS46gux0TvnNh3rQaHsPaUwWb8FmqwsXGq8HAzBrWTbAmtDSNu9xLvh2thxuU+mAXxyF0ci3TwsuzpePuxLxOBcaWzMLO5SeoLhJnTPMWFoF+ksLbjPUyyuOCeMF4XE5jarmrDnY0u+3hfebJ7na5qXkVrkv1Li6pPDbmXZZ2vejtaWaw==");
		data.setPattern("5/79vfVO9+X3f7Pot5Hff/799af32v/fd29tcuf7d/962+1/bd30v7/9uZTv/f3P8+uPP26b/Ovz/r++///1/v9/P7v+fZ1394/9f8/+df3ev//7//1f//3+/t/412f9g/+9XnO7b/+/59N///Z9/3v7b/t5Zv8vv/37797v/uW/+f2+fv++3i3eO+1+/+v/v+d0ev959w==");
		
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
