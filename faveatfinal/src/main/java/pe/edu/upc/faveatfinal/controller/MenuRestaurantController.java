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
@RequestMapping("/menus")
@SessionAttributes("{menuRestaurant}")
public class MenuRestaurantController {

	@Autowired
	private MenuRestaurantService menuRestaurantService;
	
	@Autowired
	private FoodService foodService;

	@GetMapping
	public String listMenuRestaurants(Model model) {
		try {
			List<MenuRestaurant> menuRestaurants = menuRestaurantService.getAll();
			model.addAttribute("menuRestaurants", menuRestaurants);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<Food> foods = foodService.getAll();
			model.addAttribute("foods", foods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "menu-restaurants/list-menu-restaurants";
	}

	@GetMapping("new")
	public String newMenuRestaurant(Model model) {
		MenuRestaurant menuRestaurant = new MenuRestaurant();
		model.addAttribute("menuRestaurant", menuRestaurant);
		return "menu-restaurants/new-menu-restaurant";
	}
	
	@PostMapping("savenew")
	public String saveMenuRestaurant(Model model, @ModelAttribute("menuRestaurant") MenuRestaurant menuRestaurant) {
		try {
			MenuRestaurant menuRestaurantSaved = menuRestaurantService.create(menuRestaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/menus";
	}
	
	@GetMapping("{id}/edit")
	public String editMenuRestaurant(Model model, @PathVariable("id") Integer id) {				
		try {
			if (menuRestaurantService.existById(id)) {
				Optional<MenuRestaurant> optional = menuRestaurantService.findById(id);
				model.addAttribute("menuRestaurant", optional.get());
			} else {
				return "redirect:/menus";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "menu-restaurants/edit-menu-restaurant";
	}
	
	@PostMapping("{id}/update")	
	public String updateMenuRestaurant(Model model, @ModelAttribute("menuRestaurant") MenuRestaurant menuRestaurant, 
			@PathVariable("id") Integer id) {
		try {
			if (menuRestaurantService.existById(id)) {
				menuRestaurantService.update(menuRestaurant);
			} else {
				return "redirect:/menus";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/menus";
	}
	
	@GetMapping("{id}/del")	
	public String deleteMenuRestaurant(Model model, @PathVariable("id") Integer id) {
		try {
			if (menuRestaurantService.existById(id)) {
				menuRestaurantService.deleteById(id);
			} else {
				return "redirect:/menus";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/menus";
	}
	
	
}
