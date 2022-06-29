package pe.edu.upc.faveatfinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	@GetMapping("/")
	public String Search(Model model) {
		try {
			List<Food> foods = foodService.getAll();
			model.addAttribute("food", new Food());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/example";
	}
	
	@PostMapping("/find_food")
	public String findByFood(Model model, @ModelAttribute("food") Food food) {
		
		List<Food> foods = new ArrayList<>();
		model.addAttribute("food", new Food());
		
		try {
			foods = foodService.findByName(food.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("foodSearch", food);
		model.addAttribute("foods", foods);

		return "restaurants/search-food-restaurant";

	}
	
	

	
}
