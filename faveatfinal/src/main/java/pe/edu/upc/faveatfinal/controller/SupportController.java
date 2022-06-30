package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.DeliveryManService;
import pe.edu.upc.faveatfinal.business.crud.ReportService;
import pe.edu.upc.faveatfinal.business.crud.RestaurantService;
import pe.edu.upc.faveatfinal.model.entity.CreditCard;
import pe.edu.upc.faveatfinal.model.entity.Delivery;
import pe.edu.upc.faveatfinal.model.entity.DeliveryMan;
import pe.edu.upc.faveatfinal.model.entity.DeliveryPayment;
import pe.edu.upc.faveatfinal.model.entity.Food;
import pe.edu.upc.faveatfinal.model.entity.Report;
import pe.edu.upc.faveatfinal.model.entity.Restaurant;
import pe.edu.upc.faveatfinal.utils.UserAuthentication;

@Controller
@RequestMapping("/support")
public class SupportController {
	
	@GetMapping	
	public String soporte() {
		return "support";
	}
	
	@Autowired
    private UserAuthentication userAuthentication;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("reportList")
    public String getBill(Model model) {
        if (userAuthentication.isAuthenticated()) {
            Integer id = userAuthentication.getIdSegment();
        try {
            List<Report> reports = reportService.findByRestaurant(id);
            model.addAttribute("reports", reports);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "reports/list-report";
        }
        return "redirect:/reports";
    }
	
	@GetMapping("new-report")
	public String newReport(Model model)
	{
		Report report = new Report();
		model.addAttribute("report", report);
		try {
			
			List<Restaurant> restaurants = restaurantService.getAll();
			model.addAttribute("restaurants", restaurants);
		
			} catch (Exception e) {
			e.printStackTrace();
		}
		return "reports/new-report";
	}
	
	@PostMapping("savenew")	
	public String saveReport(Model model, @ModelAttribute("report") Report report) {
		try {
			Report reportSaved = reportService.create(report);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/support";
	}
	
	@GetMapping("{id}/delete")
	public String deleteFood(Model model, @PathVariable("id") Integer id) {
		try {
			if (reportService.existById(id)) {
				reportService.deleteById(id);
			} else {
				return "redirect:/support/reportList";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/support/reportList";
	}
	
	
}
