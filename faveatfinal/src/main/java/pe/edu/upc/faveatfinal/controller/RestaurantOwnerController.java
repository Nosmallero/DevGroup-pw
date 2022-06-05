package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.RestaurantOwnerService;
import pe.edu.upc.faveatfinal.model.entity.RestaurantOwner;

@Controller
@RequestMapping("/restaurantowners")
public class RestaurantOwnerController {
	@Autowired
	private RestaurantOwnerService restaurantOwnerService;
	
	@GetMapping
	public String listCustomers(Model model) {
		try {
			List<RestaurantOwner> restaurantowners = restaurantOwnerService.getAll();
			model.addAttribute("restaurantowners", restaurantowners);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "restaurantowners/list-restaurantowners";
	}
}
