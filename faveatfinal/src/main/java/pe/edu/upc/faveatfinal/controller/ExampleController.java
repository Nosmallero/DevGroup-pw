package pe.edu.upc.faveatfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protocolo")
public class ExampleController {
	@GetMapping	
	public String soporte() {
		return "soporte";
	}
}
