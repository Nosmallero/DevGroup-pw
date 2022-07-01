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
import pe.edu.upc.faveatfinal.business.crud.MesasService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Category;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.MenuRestaurant;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.model.repository.FoodRepository;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;

@Controller
@RequestMapping("/myRestaurant")
@SessionAttributes("{myRestaurant}")
public class MyRestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private MenuRestaurantService menuRestaurantService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private UserAuthentication userAuthentication;

	@GetMapping
	public String getEnrollments(Model model) {
		if (userAuthentication.isAuthenticated()) {
			Integer id = userAuthentication.getIdSegment();
			try {
				List<Restaurant> restaurants = restaurantService.findByRestaurantOwner(id);
				model.addAttribute("restaurants", restaurants);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "myRestaurant/list-myRestaurants";
		}
		return "redirect:/";
	}

	@GetMapping("{id}/Menu")
	public String ListMenus(Model model, @PathVariable("id") Integer id, @ModelAttribute("food") Food food) {
		Restaurant restaurant = new Restaurant();
		model.addAttribute("restaurant", restaurant);
		if (userAuthentication.isAuthenticated()) {
			userAuthentication.getSegment(model);
		}
		try {
			if (foodService.existById(id)) {
				Optional<Food> optional = foodService.findById(id);
				model.addAttribute("food", optional.get());

				List<MenuRestaurant> menuRestaurants = menuRestaurantService.findByRestaurant(id);
				model.addAttribute("menuRestaurants", menuRestaurants);

			} else {
				return "redirect:/enrollments";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "myRestaurant/listMenusFoodMyRestaurant";
	}
	
	@GetMapping("{id}/Food")
	public String ListFood(Model model, @PathVariable("id") Integer id, @ModelAttribute("food") Food food) {
		Restaurant restaurant = new Restaurant();
		model.addAttribute("restaurant", restaurant);
		if (userAuthentication.isAuthenticated()) {
			userAuthentication.getSegment(model);
		}
		try {
			if (foodService.existById(id)) {
				Optional<Food> optional = foodService.findById(id);
				model.addAttribute("food", optional.get());

				List<Food> foods = foodService.findByMenuRestaurant(id);
				model.addAttribute("foods", foods);

			} else {
				return "redirect:/myRestaurant";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "myRestaurant/listFoodMyRestaurant";
	}
	
	@GetMapping("newMenu")
	public String newMenuRestaurant(Model model) {
		MenuRestaurant menuRestaurant = new MenuRestaurant();
		model.addAttribute("menuRestaurant", menuRestaurant);
		try {
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "myRestaurant/new-menu-MyRestaurant";
	}

	@PostMapping("savenewMenu")
	public String saveMenuRestaurant(Model model, @ModelAttribute("menuRestaurant") MenuRestaurant menuRestaurant) {
		try {
			MenuRestaurant menuRestaurantSaved = menuRestaurantService.create(menuRestaurant);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/myRestaurant";
	}
	
	@GetMapping("{id}/del")	
	public String deleteMenuRestaurant(Model model, @PathVariable("id") Integer id) {
		try {
			if (menuRestaurantService.existById(id)) {
				menuRestaurantService.deleteById(id);
			} else {
				return "myRestaurant/listMenusFoodMyRestaurant";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/myRestaurant";
	}
	
	@GetMapping("newFood")
	public String newFoodMyRestaurant(Model model) {
		Food food = new Food();
		model.addAttribute("food", food);
		try {
			List<MenuRestaurant> menuRestaurants = menuRestaurantService.getAll();
			model.addAttribute("menuRestaurants", menuRestaurants);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "myRestaurant/new-food-MyRestaurant";
	}

	@PostMapping("savenewFood")
	public String saveFoodMyRestaurant(Model model, @ModelAttribute("food") Food food) {
		try {
			Food foodSaved = foodService.create(food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/myRestaurant";
	}
	
}
