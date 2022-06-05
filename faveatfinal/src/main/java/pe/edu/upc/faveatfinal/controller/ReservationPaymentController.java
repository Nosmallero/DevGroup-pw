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

import pe.edu.upc.faveatfinal.business.crud.PaymentTypeService;
import pe.edu.upc.faveatfinal.business.crud.ReservationPaymentService;
import pe.edu.upc.faveatfinal.model.entity.PaymentType;
import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;

@Controller
@RequestMapping("/reservationPayments")
@SessionAttributes("{reservationPayment}")
public class ReservationPaymentController {

	@Autowired
	private ReservationPaymentService reservationPaymentService;
	
	@Autowired
	private PaymentTypeService paymentTypeService;
	
	@GetMapping  // /reservationPayments
	public String listReservationPayments(Model model) {
		
		try {
			List<ReservationPayment> reservationPayments = reservationPaymentService.getAll();
			model.addAttribute("reservationPayments", reservationPayments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "reservationPayments/list-reservationPayments";
	}
	
	@GetMapping("new") // /reservationPayments/new
	public String newReservationPayment(Model model) {
		
		ReservationPayment reservationPayment = new ReservationPayment();
		model.addAttribute("reservationPayment", reservationPayment);
		try {
			List<PaymentType> paymentTypes = paymentTypeService.getAll();
			model.addAttribute("paymentTypes", paymentTypes);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reservationPayments/new-reservationPayment";
	}
	
	@PostMapping("savenew") //reservationPayments/savenew
	public String saveReservationPayment(Model model, @ModelAttribute("reservationPayment") ReservationPayment reservationPayment)
	{
		try {
			ReservationPayment reservationPaymentSaved = reservationPaymentService.create(reservationPayment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservationPayments";
	}
	
	@GetMapping("{id}/edit") // /reservationPayments/1/edit
	public String editReservationPayment(Model model, @PathVariable("id") Integer id) {
		try {
			if (reservationPaymentService.existById(id)) {
				
				Optional<ReservationPayment> optional = reservationPaymentService.findById(id);
				model.addAttribute("reservationPayment", optional.get());
				
				List<PaymentType> paymentTypes = paymentTypeService.getAll();
				model.addAttribute("paymentTypes", paymentTypes);
			} 
			else {
				return "redirect:/reservationPayments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reservationPayments/edit-reservationPayment";
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
				return "redirect:/reservationPayments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservationPayments";
	}
	
	@GetMapping("{id}/del") //reservationPayments/1/del
	public String deleteReservationPayment(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (reservationPaymentService.existById(id)) {
			reservationPaymentService.deleteById(id);
			}
			else {
				return "redirect:/reservationPayments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservationPayments";
	}
	
}
