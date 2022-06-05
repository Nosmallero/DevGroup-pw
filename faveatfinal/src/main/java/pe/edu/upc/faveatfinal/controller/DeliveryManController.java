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

import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;

@Controller
@RequestMapping("/deliverymans")
@SessionAttributes("{deliveryman}")
public class DeliveryManController {

	@Autowired
	private DeliveryManService deliveryManService;
	
	@GetMapping
	public String listDeliveryMan(Model model) {
		try {
			List<DeliveryMan> deliverymans = deliveryManService.getAll();
			model.addAttribute("deliverymans", deliverymans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "deliverymans/list-deliverymans";
	}
	
	@GetMapping("new")
	public String newDeliveryMan(Model model) {
		DeliveryMan deliveryMan = new DeliveryMan();
		model.addAttribute("deliveryman", deliveryMan);
		try {
			List<DeliveryMan> deliverymans = deliveryManService.getAll();
			model.addAttribute("deliverymans", deliverymans);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deliverymans/new-deliveryman";
	}
	
	@PostMapping("savenew")
	public String saveDeliveryMan(Model model, @ModelAttribute("deliveryman") DeliveryMan deliveryman) {
		try {
			DeliveryMan deliverymanSaved = deliveryManService.create(deliveryman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverymans";
	}
	
	@GetMapping("{id}/edit")
	public String editDeliveryMan(Model model, @PathVariable("id") Integer id) {
			try {
				if(deliveryManService.existById(id)) {
					Optional<DeliveryMan> optional = deliveryManService.findById(id);
					model.addAttribute("deliveryman", optional.get());
					List<DeliveryMan> deliverymans = deliveryManService.getAll();
					model.addAttribute("deliverymans", deliverymans);
				} else {
					return "redirect:/deliverymans";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "deliverymans/edit-deliveryman";
	}
	
	@PostMapping("{id}/update")
	public String updateDeliveryMan(Model model, @ModelAttribute("deliveryman") DeliveryMan deliveryman, @PathVariable("id") Integer id) {
		try {
			if(deliveryManService.existById(id)) {
				deliveryManService.update(deliveryman);
			} else {
				return "redirect:/deliverymans";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverymans";
	}
	
	@GetMapping("{id}/delete")
	public String deleteDeliveryMan(Model model, @PathVariable("id") Integer id) {
		try {
			if(deliveryManService.existById(id)) {
				deliveryManService.deleteById(id);
			} else {
				return "redirect:/deliverymans";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/deliverymans";
	}
}
