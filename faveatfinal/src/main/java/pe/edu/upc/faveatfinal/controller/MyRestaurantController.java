package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.faveatfinal.business.crud.MesasService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;

@Controller
@RequestMapping("/myRestaurant")
@SessionAttributes("{myRestaurant}")
public class MyRestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private UserAuthentication userAuthentication;
	
	@GetMapping
	public String getEnrollments(Model model) {
		if (userAuthentication.isAuthenticated()) {	// Enviar los datos del Segmento al html
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
		return "redirect:/";	// Fala corregir, genera un bucle infinito
	}
	
}
