package fr.lafactory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import fr.lafactory.dao.IDAOCategorie;
import fr.lafactory.model.Categorie;

@Controller
public class CategorieController {
	
	@Autowired
	private IDAOCategorie daoCategorie;
	
	@GetMapping("/categorie")
	public String findAll(Model model) {
		
		model.addAttribute("categories", daoCategorie.findAll());
		return "categorie";
	}
	
	@GetMapping("/addCategorie")
	public String categorie(Model model) {
		
		Categorie categorie = new Categorie();
		
		model.addAttribute("categorie", categorie);
		model.addAttribute("categories", daoCategorie.findAll());
		return "addCategorie";
	}
	
	@PostMapping("/addCategorie")
	public String add(
			@Valid @ModelAttribute Categorie categorie,
			BindingResult result
					){
		daoCategorie.save(categorie);
		return "redirect:/categorie";
	}
	
	@GetMapping("/deleteCategorie")
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("categorieId"));
		
		daoCategorie.deleteById(id);
		
		return "redirect:/categorie";
	}
	
	@GetMapping("/modifCategorie")
	public String getAffiche(Model model, HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("categorieId"));
		Categorie c = daoCategorie.findById(id).orElse(null);
		model.addAttribute("categorie", c);
		return "addCategorie";
	}
	
	@PostMapping("/modifCategorie")
	public String modif (@Valid @ModelAttribute Categorie categorie,
			BindingResult result,
			HttpServletRequest request
			) {
		
		categorie.setId(Integer.parseInt(request.getParameter("categorieId")));
		
		daoCategorie.save(categorie);
		
		return "redirect:/categorie";
	}

}
