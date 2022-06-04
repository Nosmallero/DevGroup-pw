package pe.edu.upc.faveatfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplo")
public class ExampleController {
	
	@GetMapping	//	/ejemplo
	public String ejemplo() {
		return "example";
	}
	
	@GetMapping("base")	//  /ejemplo/base
	public String base() {
		return "layout/base";
	}
}
