package pe.edu.upc.faveatfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.faveatfinal.business.crud.CustomerService;
import pe.edu.upc.faveatfinal.model.entity.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String listCustomers(Model model) {
		try {
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "customers/list-customers";
	}
	
	@GetMapping("new")
	public String newCustomer(Model model) {
		return "customers/new-customer";
	}
}
