package pe.edu.upc.faveatfinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.business.crud.MenuRestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;

@Controller
@RequestMapping("/foods")
@SessionAttributes("{food}")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private MenuRestaurantService menuRestaurantService;

	@GetMapping
	public String listFoods(Model model) {
		try {
			List<Food> foods = foodService.getAll();
			model.addAttribute("foods", foods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "foods/list-foods";
	}
	
	@GetMapping("new")
	public String newFood(Model model) {
		Food food = new Food();
		model.addAttribute("food", food);
		try {
			List<MenuRestaurant> menuRestaurants = menuRestaurantService.getAll();
			model.addAttribute("menuRestaurants", menuRestaurants);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foods/new-food";
	}
	
	@PostMapping("savenew")
	public String saveFood(Model model, @ModelAttribute("food") Food food) {
		try {
			Food foodSaved = foodService.create(food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foods";
	}
	
	@GetMapping("{id}/edit")
	public String editFood(Model model, @PathVariable("id") Integer id) {				
		try {
			if (foodService.existById(id)) {
				Optional<Food> optional = foodService.findById(id);
				model.addAttribute("food", optional.get());
				List<MenuRestaurant> menuRestaurants = menuRestaurantService.getAll();
				model.addAttribute("menuRestaurants", menuRestaurants);
			} else {
				return "redirect:/foods";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foods/edit-food";
	}
	
	@PostMapping("{id}/update")	//	/students/1/update
	public String updateFood(Model model, @ModelAttribute("food") Food food, 
			@PathVariable("id") Integer id) {
		try {
			if (foodService.existById(id)) {
				foodService.update(food);
			} else {
				return "redirect:/foods";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foods";
	}
	
	@GetMapping("{id}/del")
	public String deleteFood(Model model, @PathVariable("id") Integer id) {
		try {
			if (foodService.existById(id)) {
				foodService.deleteById(id);
			} else {
				return "redirect:/foods";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foods";
	}
	
	
}
