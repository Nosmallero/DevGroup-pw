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
import pe.edu.upc.faveatfinal.business.crud.ReservationPaymentService;
import pe.edu.upc.faveatfinal.business.crud.ReservationService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.Customer;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.entity.Order;
import pe.edu.upc.faveatfinal.model.entity.Reservation;
import pe.edu.upc.faveatfinal.model.entity.ReservationPayment;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;

@Controller
@RequestMapping("/reservations")

public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationPaymentService reservationPaymentService;
	
	@Autowired
	private RestaurantService restaurantService;
	
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
			List<Reservation> reservations = reservationService.findByCustomer(id);
			model.addAttribute("reservations", reservations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "reservations/list-reservations";
		}
		return "redirect:/reservations";
	}
	
	@GetMapping("new")
	public String newReservations(Model model) {
		
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		try {
			List<ReservationPayment> reservationPayments = reservationPaymentService.getAll();
			model.addAttribute("reservationPayments", reservationPayments);
			
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
			
			List<CreditCard> creditCards = creditCardService.getAll();
			model.addAttribute("creditCards", creditCards);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reservations/new-reservations";
	}
	
	@PostMapping("savenew")
	public String saveReservation(Model model, @ModelAttribute("reservations") Reservation reservation)
	{
		if (userAuthentication.isAuthenticated()) {	
			Integer id = userAuthentication.getIdSegment();
			
		try {
			if(customerService.existById(id)) {
				Optional<Customer> optional = customerService.findById(id);
				reservation.setCustomer(optional.get());
				reservationService.create(reservation);
				return "redirect:/reservations";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		return "redirect:/reservations";
	}
	
	@GetMapping("{id}/edit")
	public String editReservation(Model model, @PathVariable("id") Integer id) {
		try {
			if (reservationService.existById(id)) {
				
				Optional<Reservation> optional = reservationService.findById(id);
				model.addAttribute("reservation", optional.get());
				
				List<ReservationPayment> reservationPayments = reservationPaymentService.getAll();
				model.addAttribute("reservationPayments", reservationPayments);
				
				List<Restaurant> restaurants = restaurantService.getAll();
				model.addAttribute("restaurants", restaurants);
				
				List<CreditCard> creditCards = creditCardService.getAll();
				model.addAttribute("creditCards", creditCards);
			} 
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reservations/edit-reservations";
	}
	//esto nop
	@PostMapping("{id}/update")
	public String updateReservation(Model model, @ModelAttribute("mesa") Reservation reservation,
			@PathVariable("id") Integer id)
	{
		try {
			if (reservationService.existById(id)) {
				reservationService.update(reservation);
			}
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
	@GetMapping("{id}/del")
	public String deleteReservation(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (reservationService.existById(id)) {
				reservationService.deleteById(id);
			}
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
}