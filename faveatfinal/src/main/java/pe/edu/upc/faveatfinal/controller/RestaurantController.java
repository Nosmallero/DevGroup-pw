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

import pe.edu.upc.faveatfinal.business.crud.CategoryService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Category;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;


@Controller
@RequestMapping("/restaurants")	// GET y POST
@SessionAttributes("{restaurant}")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CategoryService categoryService; 

	@GetMapping		//	/students
	public String listRestaurant(Model model) {
		
		try {
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "restaurants/list-restaurants";
	}
	
	@GetMapping("new")	//	/students/new
	public String newRestaurant(Model model) {
		Restaurant restaurant = new Restaurant();
		model.addAttribute("restaurant", restaurant);
		try {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "restaurants/new-restaurants";
	}
	
	@PostMapping("savenew")	//	/students/savenew
	public String saveRestaurant(Model model, @ModelAttribute("restaurant") Restaurant restaurant) {
		try {
			Restaurant restaurantSaved = restaurantService.create(restaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/restaurants";
	}
	
	@GetMapping("{id}/edit")	//	/students/1/edit
	public String editRestaurant(Model model, @PathVariable("id") Integer id) {				
		try {
			if (restaurantService.existById(id)) {
				Optional<Restaurant> optional = restaurantService.findById(id);
				model.addAttribute("restaurant", optional.get());
				List<Category> categories = categoryService.getAll();
				model.addAttribute("categories", categories);
			} else {
				return "redirect:/restaurants";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "restaurants/edit-restaurants";
	}
	
	@PostMapping("{id}/update")	//	/students/1/update
	public String updateRestaurant(Model model, @ModelAttribute("restaurant") Restaurant restaurant, 
			@PathVariable("id") Integer id) {
		try {
			if (restaurantService.existById(id)) {
				restaurantService.update(restaurant);
			} else {
				return "redirect:/restaurants";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/restaurants";
	}
	
	@GetMapping("{id}/del")	//	/students/1/del
	public String deleteStudent(Model model, @PathVariable("id") Integer id) {
		try {
			if (restaurantService.existById(id)) {
				restaurantService.deleteById(id);
			} else {
				return "redirect:/restaurants";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/restaurants";
	}	
}