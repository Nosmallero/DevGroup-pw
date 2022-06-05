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

import pe.edu.upc.faveatfinal.business.crud.CategoryService;
import pe.edu.upc.faveatfinal.model.entity.Category;


@Controller
@RequestMapping("/categories")	// GET y POST
@SessionAttributes("{category}")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping		//	/students
	public String listCategory(Model model) {
		
		try {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "categories/list-categories";
	}
	
	@GetMapping("new")	//	/students/new
	public String newCategory(Model model) {
		Category category = new Category();
		model.addAttribute("student", category);
		
		return "category/new-category";
	}
	
	@GetMapping("{id}/edit")	//	/students/1/edit
	public String editCategory(Model model, @PathVariable("id") Integer id) {				
		try {
			if (categoryService.existById(id)) {
				Optional<Category> optional = categoryService.findById(id);
				model.addAttribute("student", optional.get());
				
			} else {
				return "redirect:/category";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "categories/edit-category";
	}
	
	@PostMapping("savenew")	//	/students/savenew
	public String saveCategory(Model model, @ModelAttribute("category") Category category) {
		try {
			Category categorySaved = categoryService.create(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/category";
	}
	
	@GetMapping("{id}/del")	//	/students/1/del
	public String deleteCategory(Model model, @PathVariable("id") Integer id) {
		try {
			if (categoryService.existById(id)) {
				categoryService.deleteById(id);
			} else {
				return "redirect:/categories";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categories";
	}
}