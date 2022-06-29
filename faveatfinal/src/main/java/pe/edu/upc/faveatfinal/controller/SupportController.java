package pe.edu.upc.faveatfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support")
public class SupportController {
	@GetMapping	
	public String soporte() {
		return "support";
	}
	
	@GetMapping("new-report")
	public String newReport(Model model)
	{
		return "report/new-report";
	}
	
	
	
}
