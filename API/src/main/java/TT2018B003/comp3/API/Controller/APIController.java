package TT2018B003.comp3.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TT2018B003.comp3.API.Model.WinnowingModel;
import TT2018B003.comp3.API.Service.IWinnowing;

@RestController
@RequestMapping("API/v1")
public class APIController {
	
	@Autowired
	IWinnowing winnowingService;
	
	@RequestMapping(
					value = "/winnowing",
					method = RequestMethod.POST,
					consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
					)
	public String makeWinnowing(@RequestBody WinnowingModel data) {
		winnowingService.setChaffing(data.getChaffing());
		winnowingService.setPattern(data.getPattern());
		return winnowingService.makeWinnowing();
	}
	
	
	/*
	@GetMapping(value = "/chaffing/{chaffing}")
	public String setChaffing(@PathVariable String chaffing) {
		winnowingService.setChaffing(chaffing);
		return winnowingService.getChaffing();
	}
	
	@GetMapping(value = "/pattern/{pattern}")
	public String setPattern(@PathVariable String pattern) {
		winnowingService.setPattern(pattern);
		return winnowingService.getPattern();
	}
	
	@GetMapping(value = "/winnowing")
	public String getCertificate() {
		return winnowingService.makeWinnowing();
	}*/
	
}
