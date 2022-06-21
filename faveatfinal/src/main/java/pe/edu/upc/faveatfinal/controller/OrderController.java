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

import pe.edu.upc.faveatfinal.business.crud.CustomerService;
import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.business.crud.OrderService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.Order;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;


@Controller
@RequestMapping("orders")
@SessionAttributes("{order}")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping  // /orders
	public String ListOrders(Model model) {
		
		try {
			List<Order> orders = orderService.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "orders/list-orders";
	}
	
	
	@GetMapping("new")
	public String newOrder(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		try {
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
			List<Food> foods = foodService.getAll();
			model.addAttribute("foods", foods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orders/new-order";
	}
	
	@PostMapping("savenew")
	public String saveOrder(Model model, @ModelAttribute("order") Order order) {
		try {
			Order orderSaved = orderService.create(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/orders";
	}
	
	@GetMapping("{id}/delete")
	public String deleteOrder(Model model, @PathVariable("id") Integer id) {
		try {
			if(orderService.existById(id)) {
				orderService.deleteById(id);
			} else {
				return "redirect:/orders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/orders";
	}
	/*
	@GetMapping("{id}/edit")
	public String editOrder(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(orderService.existById(id)) {
				Optional<Order> optional = orderService.findById(id);
				model.addAttribute("order", optional.get());
				List<Restaurant> restaurants = restaurantService.getAll();
				model.addAttribute("restaurants", restaurants);
				List<Customer> customers = customerService.getAll();
				model.addAttribute("customers", customers);
				List<Food> foods = foodService.getAll();
				model.addAttribute("foods", foods);
			} else {
				return "redirect:/orders";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orders/edit-order";
	}
	
	@PostMapping("{id}/update")
	public String updateOrder(Model model, @ModelAttribute("order") Order order, @PathVariable("id") Integer id) {
		try {
			if(orderService.existById(id)) {
				orderService.update(order);
			} else {
				return "redirect:/orders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/orders";
	}*/
	
	
}
