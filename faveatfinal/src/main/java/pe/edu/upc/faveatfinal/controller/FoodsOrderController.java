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
import pe.edu.upc.faveatfinal.business.crud.FoodsOrderService;
import pe.edu.upc.faveatfinal.business.crud.OrderService;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.FoodsOrder;
import pe.edu.upc.faveatfinal.model.entity.Order;


@Controller
@RequestMapping("foodsOrders")
@SessionAttributes("{foodOrder}")
public class FoodsOrderController {
	
	@Autowired
	private FoodsOrderService foodsOrderService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping  // /orders
	public String ListFoodsOrder(Model model) {
		
		try {
			List<FoodsOrder> foodsOrders = foodsOrderService.getAll();
			model.addAttribute("foodsOrders", foodsOrders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "foodsOrders/list-foodsOrders";
	}
	
	
	@GetMapping("new")
	public String newFoodsOrder(Model model) {
		FoodsOrder foodsOrders = new FoodsOrder();
		model.addAttribute("foodsOrders", foodsOrders);
		try {
			List<Order> orders = orderService.getAll();
			model.addAttribute("orders", orders);
			List<Food> foods = foodService.getAll();
			model.addAttribute("foods", foods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foodsOrders/new-foodsOrder";
	}
	
	@PostMapping("savenew")
	public String saveFoodsOrder(Model model, @ModelAttribute("foodsOrder") FoodsOrder foodsOrder) {
		try {
			FoodsOrder foodsOrderSaved = foodsOrderService.create(foodsOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foodsOrders";
	}
	
	@GetMapping("{id}/edit")
	public String editFoodsOrder(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(foodsOrderService.existById(id)) {
				Optional<FoodsOrder> optional = foodsOrderService.findById(id);
				model.addAttribute("foodsOrders", optional.get());
				List<Order> orders = orderService.getAll();
				model.addAttribute("orders", orders);
				List<Food> foods = foodService.getAll();
				model.addAttribute("foods", foods);
			} else {
				return "redirect:/foodsOrders";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "foodsOrders/edit-foodsOrder";
	}
	
	@PostMapping("{id}/update")
	public String updateFoodsOrder(Model model, @ModelAttribute("foodsOrder") FoodsOrder foodsOrder, @PathVariable("id") Integer id) {
		try {
			if(foodsOrderService.existById(id)) {
				foodsOrderService.update(foodsOrder);
			} else {
				return "redirect:/foodsOrders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foodsOrders";
	}
	
	@GetMapping("{id}/delete")
	public String deleteFoodsOrder(Model model, @PathVariable("id") Integer id) {
		try {
			if(foodsOrderService.existById(id)) {
				foodsOrderService.deleteById(id);
			} else {
				return "redirect:/foodsOrders";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/foodsOrders";
	}
}
