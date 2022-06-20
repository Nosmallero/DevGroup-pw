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

import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.business.crud.DeliveryService;
import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.entity.Food;



@Controller
@RequestMapping("/deliverys")
@SessionAttributes("{delivery}")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public String listDelivery(Model model) {
		
		try {
			List<Delivery> deliverys = deliveryService.getAll();
			model.addAttribute("deliverys", deliverys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverys/list-deliverys";
	}
	
	@GetMapping("new")
	public String newDelivery(Model model) {
		Delivery delivery = new Delivery();
		model.addAttribute("delivery", delivery);
		try {
			List<DeliveryMan> deliverymans = deliveryManService.getAll();
			model.addAttribute("deliverymans", deliverymans);
			List<Food> foods = foodService.getAll();
			model.addAttribute("foods", foods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverys/new-delivery";
	}
	
	@PostMapping("savenew")
	public String saveDelivery(Model model, @ModelAttribute("delivery") Delivery delivery) {
		try {
			Delivery deliverySaved = deliveryService.create(delivery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverys";
	}
	
	@GetMapping("{id}/edit")
	public String editDelivery(Model model, @PathVariable("id") Integer id) {
		
		try {
			if(deliveryService.existById(id)) {
				Optional<Delivery> optional = deliveryService.findById(id);
				model.addAttribute("delivery", optional.get());
				List<DeliveryMan> deliverymans = deliveryManService.getAll();
				model.addAttribute("deliverymans", deliverymans);
				List<Food> foods = foodService.getAll();
				model.addAttribute("foods", foods);
			} else {
				return "redirect:/deliverys";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverys/edit-delivery";
	}
	
	@PostMapping("{id}/update")
	public String updateDelivery(Model model, @ModelAttribute("delivery") Delivery delivery, @PathVariable("id") Integer id) {
		try {
			if(deliveryService.existById(id)) {
				deliveryService.update(delivery);
			} else {
				return "redirect:/deliverys";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverys";
	}
	
	@GetMapping("{id}/delete")
	public String deleteDelivery(Model model, @PathVariable("id") Integer id) {
		try {
			if(deliveryService.existById(id)) {
				deliveryService.deleteById(id);
			} else {
				return "redirect:/deliverys";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverys";
	}
	
}
