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
import pe.edu.upc.faveatfinal.business.crud.DeliveryPaymentService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.DeliveryPayment;

@Controller
@RequestMapping("/deliveryPayments-bs")
@SessionAttributes("{deliveryPayment}")
public class DeliveryPaymentBsController {

	@Autowired
	private DeliveryPaymentService deliveryPaymentService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping  // /deliveryPayments
	public String listDeliveryPayments(Model model) {
		
		try {
			List<DeliveryPayment> deliveryPayments = deliveryPaymentService.getAll();
			model.addAttribute("deliveryPayments", deliveryPayments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "deliveryPayments-bs/list-deliveryPayments";
	}
	
	@GetMapping("new") // /deliveryPayments/new
	public String newDeliveryPayment(Model model) {
		
		DeliveryPayment deliveryPayment = new DeliveryPayment();
		model.addAttribute("deliveryPayment", deliveryPayment);
		try {
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deliveryPayments-bs/new-deliveryPayment";
	}
	
	@PostMapping("savenew") //deliveryPayments/savenew
	public String saveDeliveryPayment(Model model, @ModelAttribute("deliveryPayment") DeliveryPayment deliveryPayment)
	{
		try {
			DeliveryPayment deliveryPaymentSaved = deliveryPaymentService.create(deliveryPayment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/deliveryPayments-bs";
	}
	
	@GetMapping("{id}/edit") // /deliveryPayments/1/edit
	public String editDeliveryPayment(Model model, @PathVariable("id") Integer id) {
		try {
			if (deliveryPaymentService.existById(id)) {
				
				Optional<DeliveryPayment> optional = deliveryPaymentService.findById(id);
				model.addAttribute("deliveryPayment", optional.get());
				
				List<CreditCard> creditCards = creditCardService.getAll();
				model.addAttribute("creditCards", creditCards);
			} 
			else {
				return "redirect:/deliveryPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deliveryPayments-bs/edit-deliveryPayment";
	}
	
	@PostMapping("{id}/update") //deliveryPayments/1/update
	public String updateDeliveryPayment(Model model, @ModelAttribute("deliveryPayment") DeliveryPayment deliveryPayment,
			@PathVariable("id") Integer id)
	{
		try {
			if (deliveryPaymentService.existById(id)) {
				deliveryPaymentService.update(deliveryPayment);
			}
			else {
				return "redirect:/deliveryPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/deliveryPayments-bs";
	}
	
	@GetMapping("{id}/del") //deliveryPayments/1/del
	public String deleteDeliveryPayment(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (deliveryPaymentService.existById(id)) {
				deliveryPaymentService.deleteById(id);
			}
			else {
				return "redirect:/deliveryPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/deliveryPayments-bs";
	}
}
