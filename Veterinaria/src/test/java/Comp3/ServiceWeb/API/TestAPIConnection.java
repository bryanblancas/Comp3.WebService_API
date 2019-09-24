package Comp3.ServiceWeb.API;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import Comp3.ServiceWeb.API.Model.WinnowingModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
public class TestAPIConnection {

	@Test
	public void connectionTest() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/API/v1/winnowing";

		WinnowingModel data = new WinnowingModel();
		data.setChaffing("hola");
		data.setPattern("pattern");
		
		String a = restTemplate.postForObject(url, data, String.class);
		
		Assert.assertEquals("hola:pattern", a);
		log.info(a);
	}
}
