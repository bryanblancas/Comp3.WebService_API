package TT2018B003.comp3.API.TestRestAPI;

import org.springframework.web.client.RestTemplate;
import TT2018B003.comp3.API.Domain.WinnowingModelTest;

public class TestRestAPI {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8083/API/v1/winnowing";

		WinnowingModelTest data = new WinnowingModelTest();
		data.setChaffing("cwwrwtFXc2JdK2qwuDFcHB5xpMbA3UtJt1c17woyOjbbgVXhq2xLGiPA4MaabDYXY2q3txfehvbYdvEfVRS8uJY2T7XQta2UvcnZrSRwG8OS2tMLPOUn5gnB1mWbhEhfKY3e8J9xIBuYcJuMRT0OA3FpXDMLajpt0t4XubsLZubjLZC1jV4cNlGFm2OcYp9vGnS1NXM=");
		data.setPattern("U2FsdGVkX19N90qAsiwL7ZR18CuSOtyi17S83y/7cFVCT9wcUEuNYL8Wx5PHh+1XhucjZow6eniWozclaCQG9sr5xcaFbuw2pW7TZmd4cVN+fUCqiNyYLTR7SmskgOEp2cEEsABmjqyMxrPPG6J52nM2ClhPnHSlPxrCpYoJ2bMnlh0zA6Ej46WXHHFo7eY5B14w8dgpuUhkeaD7sPzvqrVHrvLM4OrpVm4rPQOgC8sJSBwJ+1XSdDIoMn4p52kDg2LX4hzCrCs+7Uao4xo8PHGVM5wpG/1l2ZWE4He1vHd+wBTZ5szjgXMEa3bljN7pYN6VK1eMhT1x04mPlSn1iekh0HMa+G7uY0faomzSzAilFvXOsfmLBnOBRg3SNYhV JsuXKEpkzKWst7nzA0NeK2m/9xl9wPmtDuwAt7BViRxNEsBruQRtEyZkDcujobGXeCzN/uxLQRxJ9n7NCDm23MreCcR4bkC6sEi0n6oDRKyN06ScVDCFArV7tr7lcA6d5zknakwM79oYn+ELAPKMQyOlOi8651UOC7RBp9KYxNpi+M77xGNiaAfjRMPX8kGjRRo3nD15d//LGChx3bRU9G762SdZ1TdWbXCv/8Jx/8/TttbujOjFEyE56LBaUBi4pdj+0EAyMy8rc4EGtlEO6V+JVl74xS1OCQq7vdsZFzlhfLFDMfG4lsacCefvCjkZWtv4jgHoydWfGNULXWjXbg==");
		
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
