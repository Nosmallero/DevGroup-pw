package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.Report;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;

@Controller
@RequestMapping("/support")
public class SupportController {
	
	@GetMapping	
	public String soporte() {
		return "support";
	}
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("new-report")
	public String newReport(Model model)
	{
		Report report = new Report();
		model.addAttribute("report", report);
		try {
			
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
		
			} catch (Exception e) {
			e.printStackTrace();
		}
		return "reports/new-report";
	}
	
}
