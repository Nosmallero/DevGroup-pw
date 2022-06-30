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

import pe.edu.upc.faveatfinal.business.crud.CreditCardService;
import pe.edu.upc.faveatfinal.business.crud.CustomerService;
import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.business.crud.DeliveryService;
import pe.edu.upc.faveatfinal.business.crud.FoodService;
import pe.edu.upc.faveatfinal.business.crud.OrderService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.Order;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;



@Controller
@RequestMapping("/deliverys")

public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private DeliveryManService deliveryManService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	
	
	@GetMapping
	public String getBill(Model model) {
		if (userAuthentication.isAuthenticated()) {	
			Integer id = userAuthentication.getIdSegment();
		try {
			List<Delivery> deliverys = deliveryService.findByCustomer(id);
			model.addAttribute("deliverys", deliverys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverys/list-deliverys";
		}
		return "redirect:/deliverys";
	}
	
	@GetMapping("new")
	public String newDelivery(Model model) {
		Delivery delivery = new Delivery();
		model.addAttribute("delivery", delivery);
		try {
			List<DeliveryMan> deliverymans = deliveryManService.getAll();
			model.addAttribute("deliverymans", deliverymans);
			List<Order> orders = orderService.getAll();
			model.addAttribute("orders", orders);
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverys/new-delivery";
	}
	
	@PostMapping("savenew")
	public String saveDelivery(Model model, @ModelAttribute("delivery") Delivery delivery) {
		if (userAuthentication.isAuthenticated()) {	
			Integer id = userAuthentication.getIdSegment();
			try {
				if(customerService.existById(id)) {
					Optional<Customer> optional = customerService.findById(id);
					delivery.setCustomer(optional.get());
					deliveryService.create(delivery);
					return "redirect:/deliverys";
				}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				List<Order> orders = orderService.getAll();
				model.addAttribute("orders", orders);
				List<CreditCard> creditCards = creditCardService.getAll();
				model.addAttribute("creditCards", creditCards);
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
