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
import pe.edu.upc.faveatfinal.model.entity.CreditCard;

@Controller
@RequestMapping("/creditCards-bs")
@SessionAttributes("{creditCard}")
public class CreditCardBsController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping  // /creditCards
	public String listCreditCards(Model model) {
		
		try {
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "creditCards-bs/list-creditCards";
	}
	
	@GetMapping("new") // /creditCards/new
	public String newCreditCard(Model model) {
		
		CreditCard creditCard = new CreditCard();
		model.addAttribute("creditCard", creditCard);
		try {
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "creditCards-bs/new-creditCard";
	}
	
	@PostMapping("savenew") //creditCards/savenew
	public String saveCreditCard(Model model, @ModelAttribute("creditCard") CreditCard creditCard)
	{
		try {
			CreditCard creditCardSaved = creditCardService.create(creditCard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/creditCards-bs";
	}
	
	@GetMapping("{id}/edit") // /creditCards/1/edit
	public String editCreditCard(Model model, @PathVariable("id") Integer id) {
		try {
			if (creditCardService.existById(id)) {
				
				Optional<CreditCard> optional = creditCardService.findById(id);
				model.addAttribute("creditCard", optional.get());
				
				List<CreditCard> creditCards = creditCardService.getAll();
				model.addAttribute("creditCards", creditCards);
			} 
			else {
				return "redirect:/creditCards-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "creditCards-bs/edit-creditCard";
	}
	
	@PostMapping("{id}/update") //creditCards/1/update
	public String updateCreditCard(Model model, @ModelAttribute("creditCard") CreditCard creditCard,
			@PathVariable("id") Integer id)
	{
		try {
			if (creditCardService.existById(id)) {
				creditCardService.update(creditCard);
			}
			else {
				return "redirect:/creditCards-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/creditCards-bs";
	}
	
	@GetMapping("{id}/del") //creditCards/1/del
	public String deleteCreditCard(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (creditCardService.existById(id)) {
				creditCardService.deleteById(id);
			}
			else {
				return "redirect:/creditCards-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/creditCards-bs";
	}
}

