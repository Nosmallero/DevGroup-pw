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

import pe.edu.upc.faveatfinal.business.crud.ReservationService;
import pe.edu.upc.faveatfinal.model.entity.Reservation;

@Controller
@RequestMapping("/reservations")
@SessionAttributes("{reservation}")
public class ReservationController {
	@Autowired
	private ReservationService reservationsService;
	
	@GetMapping
	public String listReservations(Model model) {
		
		try {
			List<Reservation> reservations = reservationsService.getAll();
			model.addAttribute("reservations", reservations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "reservations/list-reservations";
	}
	
	@GetMapping("new")
	public String newReservations(Model model) {
		
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		try {
			List<Reservation> reservations = reservationsService.getAll();
			model.addAttribute("reservations", reservations);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reservations/new-reservations";
	}
	
	@PostMapping("savenew")
	public String saveReservation(Model model, @ModelAttribute("reservations") Reservation reservation)
	{
		try {
			Reservation reservationSaved = reservationsService.create(reservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
	@GetMapping("{id}/edit")
	public String editReservation(Model model, @PathVariable("id") Integer id) {
		try {
			if (reservationsService.existById(id)) {
				
				Optional<Reservation> optional = reservationsService.findById(id);
				model.addAttribute("reservation", optional.get());
				
				List<Reservation> reservation = reservationsService.getAll();
				model.addAttribute("reservation", reservation);
			} 
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reservations/edit-reservations";
	}
	
	@PostMapping("{id}/update")
	public String updateReservation(Model model, @ModelAttribute("mesa") Reservation reservation,
			@PathVariable("id") Integer id)
	{
		try {
			if (reservationsService.existById(id)) {
				reservationsService.update(reservation);
			}
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
	@GetMapping("{id}/del")
	public String deleteReservation(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (reservationsService.existById(id)) {
				reservationsService.deleteById(id);
			}
			else {
				return "redirect:/reservations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
}