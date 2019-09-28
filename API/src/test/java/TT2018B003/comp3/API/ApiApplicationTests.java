package TT2018B003.comp3.API;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import TT2018B003.comp3.API.Domain.WinnowingModelTest;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	//@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void contextLoads() {}
	private static String urlBase;
	
	@BeforeClass
	public static void setUrlBase() {
		urlBase = "http://localhost:8080/API/v1/";
	}
	
	@Test
	@Ignore
	public void testGetWinnowingWithData() {
		
		String chaffing = "JtJplCHhSEMh0K5Ga10RO9lUkgVHJNWpx0upGkQVmag63eDTMtyMQ7FZQmQ0283VIdhoOSSxrnSixVLKJdvrJMuhbGMnEKoUqrEEUSDd7HVLDXDDPZCpZAlOTpXIpAplKEDa5hXLGlEcnroQ0SzRimUKRZLCkKskcmkw6DiXkxHhsEQ9mBTyBOcnlcgki42awjXMrUaqndhqMR6oqrWawTfR6JOKVQpDVbddCJMtyKR6tUI0PehEiuUI1ijUqUSihSxGKkyJZYJRqMUn06iXuh0CMSrRqBd73QzSK5OoorBgMDwS6ESLtQRnNdytBlslDxzd5oQSDSJFK9Hq9RNBNCvZjmXK4EoYnKJgyjuTrSQrZZrVIZvMJTkM8DGQ5tZTKGQYnekGww0czSqa7nT9iMUYk6hFi92caiZNinbDLZzNNZBu9PoIIt7JlKLFbs41k2aNLmohmGch9KUmk6iWVQ7BGFVsqolQzUFVKuY7YQh6IFOlic5OKxDIZU7NIRrmFuOVDmw1mM8kqkEawRiR6BNK1QrCO93odSJdLLQw1elnMrWi9zvQ7HWKkSzRKFLoRIq5lLUizU+EI2mCzSGZ6HLZBiDc6VQJqlYqlKaDijkaURod6ESK5QhVlKoaEQjBK5HKk0K5IiqViFZ6NQbZI9DqG8WO0yTYxjQxIsUlEKoltbTaQ9uNgTSyHNqMttJIYmM2zo8U6tGSeFSodiPRstc2HOlG6nlsYioQ6DSKTZK3IhSrFNKt3tpCbQezDYcQqpSqCYTI0KjGOx0KyBCoxJotAtE16LY7HQpCIJONRZKdzm8zXo30eyyRFV8DkcVEaSLNjRYaKRrEOM3u9HoJEGYrm+2zK2FSMjWT7BS76WRBVtvqM4phIOuM6DZjEOj2KdupJEoZELcV36c75SEnhwfJhSDpGJHuJYO5xOIo0Kna3PBlIg2tRdKVxqszlM30ai3W2DVSxiWpYRLjItSmJlvY5sbNyWxEINh3A9baK9rpNjLZSjNQrsqRaNEp0qXJxS7NG9uo5tswZkwzjeaTEabiGZyNN4pNUkoZjKcKBRrTK5uoNau5jGIrm610KqmY6RjN7mRD4Q7xLBDI05pRqNM0jMq2W3M6SumWibbpOZnvBSo9rGoZUanjMUmk5QA3AFMACQAWABMAHQAWAHcAIAAAKwAWAHMAFQAcADIAGABTAC4AVwAKAGUAVAAAOABWgAAEAAAABgBzADkAVABIAAB7AFUAEABJACAGgAwAJwA7AGQAagBAGABTACYAcwA6ADwAVgB5QBgAGQAIABYAGgAtAAoAVwA3gBAAAAAKACEAUABRACAGAAkAdABJAEkAIoAWABkAEAUAdAB5QAwAAHEAPQAMwA4AZwAjAAAADgAyAFCAIAIAWgAgwAAAAgAVAGAEAAAQAIAAAwAMAA8AJQBTABAAXgB5ACSAGQAMAQBBgBEAJoALACAAXgAvACYAGgAVgBCALAAATQAKADACAGEAagBhADEAEgAJAHACQBwAgC4APABYAAAAagBQAHIAaAA3AFEALgBWAAsAaQBigAUANQBQAGgAFwA6AAAKAEAAAFAALAAUAGAJACAAAgAAAATACgAZAAoAdwAkABQAABQAAGACAERACwAUAEYABAB6AAkABABZACIAUQBKAAOAAAUAcIAAAAAAAABqADQAYgBLACwAFQANAAAKABkAHABqACeAGgBOgAYAABQAAG9AEQBUAA0AJAArAFkACoAYADIAVQAJAFQAEYAhAA4AQQAYAFUALIAAAgAgAgB3QAgAVgApAFQAEwAFAAIARgAAFAAHABeAAkAVAAANABgAUgBoAYAAAUAIAAA0AFEASQBmgBABAAAABgAAbQAnACMAAAoAbwAxAFQADQAkACsAWQAIAQAAFgAABgAqAEAIAE0AIAAAJwAAAgAdAAIAMQAqAFkACAAAKwBdAAoAQgAWAABuAGAKAEACAEADABMAKAAQAgA1AAQAQAAAWQBHAAADgB0AAARACABWACkAJIAbAD0ANABJADQAGAKAJgAADQAADgAgAFQAIAQAKkARAAACAAAUACgAFAAjAB0ATgBFQAEAEAAgBABCAGUAYAMAKABTAAUANAAaAGACAEABAA4AKAEAK4AQAGIAcgAtABsACQBTAAoATQBGADkAAAAOAGMAAAAAAgA0AFEATsAUAAAADgA4QBkAUoANAFQAEgAAAgBpABsAXgAPABQAAEwAVgBKACAAAgBlADEAPQAEgARACAIAQAcAAAEAABYAMgAegAAGADMAUAIAYQAlAF0AKAAgAAUAAoADADsADQAAAAMAEYAAAAEAEUAJAHMAAwA1AGwAVwAAEwANACABAFDAEgBVADUAWQANAAAKAB0AJABxACIATQAuAHMAIwApAFJAEAAhABQASQBgAAEAIABkACwAWQBoAEAIAQASAGIAHAAYAEkAEAEAWQAIAEUAGQBNAEAAAgBVABYAbAA4AAAAJQAgCAAASgA9ABIACYAWADsAXQAiAGADAFoACAAVAEsAEQBOAE0ANgBZAEkAYAoAAFIAaQA4ABoAACQAQQBgAABGACADACYAQwAbAAUARIAAAQAMAAA3AEIAQA5ADAEAWQAnABcAQAEAEoAJACUAXgBOABcAAwBFAEAFACAAUQAOAFAAAQBEADgAJAAbAAqAEAABABoANAA5AE0ASQBGAAAAAgAAABAEABYAYQBVQA4ARQAmABYAJgBFABIARQB0AEMANQBOACoARgAASQAEAEAAAF4ADQA1AEMAEACAGQAtAB0ASQBQAUANABAEABgAEwBNAAQAEoAYAFYATQAZAAAmAEYASgAZAEoAMQA3AEwAJQAgCwAQAFYAYAGAEAADAAsAIYAGAFUAIQBaAC8AAwAbADEAIMAQABeAHAAAFAAyABgAAEsAOwAZAGoAdQAiACGAEgA2QAcAUwAJAGYAewAxAEYATgAwAFsAAAM=";
		String pattern = "   @0@@P@@   @ P@ \"@ @@@!%D@   ! @(@@PD  0  2@@ @L0! @D  1h@@@   @@@ @A@`@0 p   0@@ $ !0 B  `  @@  D@@0@  @@èHH(0@$ @#(@P@HÈ@   %@ \" ÐD8bH@   A!@ @À X  @b @P7  A @@@P `  0!HÑ@$  D@0 @@AÀ % @ @px\" @!X@ $`@` XL  À    @À0\"\" @J@pè  D@ @À ,   B!@  ";
		String certificate = chaffing+":"+pattern;
		
		String url = urlBase+"winnowing";
		WinnowingModelTest data = new WinnowingModelTest(chaffing, pattern);
		
		String a = restTemplate.postForObject(url, data, String.class);
		
		Assert.assertNotNull(a);
		Assert.assertEquals(certificate, a);
	}
	
	@Test
	@Ignore
	public void testGetWinnowingWithoutData() {
		String url = urlBase+"winnowing";
		WinnowingModelTest data = new WinnowingModelTest();
		
		String a = restTemplate.postForObject(url, data, String.class);
		
		Assert.assertNotNull(a);
		Assert.assertEquals("null:null", a);
	}
		
}
