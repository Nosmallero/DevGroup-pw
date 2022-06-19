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
import pe.edu.upc.faveatfinal.business.crud.ReservationPaymentService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;

@Controller
@RequestMapping("/reservationPayments-bs")
@SessionAttributes("{reservationPayment}")
public class ReservationPaymentBsController {

	@Autowired
	private ReservationPaymentService reservationPaymentService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping  // /reservationPayments
	public String listReservationPayments(Model model) {
		
		try {
			List<ReservationPayment> reservationPayments = reservationPaymentService.getAll();
			model.addAttribute("reservationPayments", reservationPayments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "reservationPayments-bs/list-reservationPayments";
	}
	
	@GetMapping("new") // /reservationPayments/new
	public String newReservationPayment(Model model) {
		
		ReservationPayment reservationPayment = new ReservationPayment();
		model.addAttribute("reservationPayment", reservationPayment);
		try {
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reservationPayments-bs/new-reservationPayment";
	}
	
	@PostMapping("savenew") //reservationPayments/savenew
	public String saveReservationPayment(Model model, @ModelAttribute("reservationPayment") ReservationPayment reservationPayment)
	{
		try {
			ReservationPayment reservationPaymentSaved = reservationPaymentService.create(reservationPayment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/reservationPayments-bs";
	}
	
	@GetMapping("{id}/edit") // /reservationPayments/1/edit
	public String editReservationPayment(Model model, @PathVariable("id") Integer id) {
		try {
			if (reservationPaymentService.existById(id)) {
				
				Optional<ReservationPayment> optional = reservationPaymentService.findById(id);
				model.addAttribute("reservationPayment", optional.get());
				
				List<CreditCard> creditCards = creditCardService.getAll();
				model.addAttribute("creditCards", creditCards);
			} 
			else {
				return "redirect:/reservationPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reservationPayments-bs/edit-reservationPayment";
	}
	
	@PostMapping("{id}/update") //reservationPayments/1/update
	public String updateReservationPayment(Model model, @ModelAttribute("reservationPayment") ReservationPayment reservationPayment,
			@PathVariable("id") Integer id)
	{
		try {
			if (reservationPaymentService.existById(id)) {
			reservationPaymentService.update(reservationPayment);
			}
			else {
				return "redirect:/reservationPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/reservationPayments-bs";
	}
	
	@GetMapping("{id}/del") //reservationPayments/1/delete
	public String deleteReservationPayment(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (reservationPaymentService.existById(id)) {
			reservationPaymentService.deleteById(id);
			}
			else {
				return "redirect:/reservationPayments-bs";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/reservationPayments-bs";
	}
}
