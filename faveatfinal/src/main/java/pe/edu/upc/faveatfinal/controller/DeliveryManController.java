package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;

@Controller
@RequestMapping("/deliverymans")
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
		
		return "deliverymans/new-deliveryman";
	}
}
