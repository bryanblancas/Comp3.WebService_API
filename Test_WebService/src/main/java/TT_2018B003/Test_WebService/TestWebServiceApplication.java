package TT_2018B003.Test_WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("TT_2018B003.Test_WebService")
public class TestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebServiceApplication.class, args);
	}

}
