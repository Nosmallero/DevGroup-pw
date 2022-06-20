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

import pe.edu.upc.faveatfinal.business.crud.MesasService;
import pe.edu.upc.faveatfinal.model.entity.Mesas;

@Controller
@RequestMapping("/mesas")
@SessionAttributes("{mesa}")
public class MesasController {
	@Autowired
	private MesasService mesasService;
	
	@GetMapping
	public String listMesas(Model model) {
		
		try {
			List<Mesas> mesas = mesasService.getAll();
			model.addAttribute("mesas", mesas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mesas/list-mesas";
	}
	
	@GetMapping("new")
	public String newMesas(Model model) {
		
		Mesas mesa = new Mesas();
		model.addAttribute("mesa", mesa);
		try {
			List<Mesas> mesas = mesasService.getAll();
			model.addAttribute("mesas", mesas);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mesas/new-mesas";
	}
	
	@PostMapping("savenew")
	public String saveMesa(Model model, @ModelAttribute("mesas") Mesas mesa)
	{
		try {
			Mesas mesaSaved = mesasService.create(mesa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/mesas";
	}
	
	@GetMapping("{id}/edit")
	public String editMesa(Model model, @PathVariable("id") Integer id) {
		try {
			if (mesasService.existById(id)) {
				
				Optional<Mesas> optional = mesasService.findById(id);
				model.addAttribute("mesa", optional.get());
				
				List<Mesas> mesas = mesasService.getAll();
				model.addAttribute("mesas", mesas);
			} 
			else {
				return "redirect:/mesas";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mesas/edit-mesas";
	}
	
	@PostMapping("{id}/update")
	public String updateMesas(Model model, @ModelAttribute("mesa") Mesas mesa, @PathVariable("id") Integer id)
	{
		try {
			if (mesasService.existById(id)) {
				mesasService.update(mesa);
			}
			else {
				return "redirect:/mesas";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/mesas";
	}
	
	@GetMapping("{id}/del")
	public String deleteMesas(Model model, @PathVariable("id") Integer id)
	{
		try {
			if (mesasService.existById(id)) {
				mesasService.deleteById(id);
			}
			else {
				return "redirect:/mesas";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/mesas";
	}
}
