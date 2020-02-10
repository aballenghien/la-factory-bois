package fr.lafactory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.lafactory.dao.IDAOIdee;
import fr.lafactory.model.Idee;

@Controller
public class IdeeController {
	
	@Autowired
	private IDAOIdee daoIdee;
	
	@GetMapping(value="/idee")
	public String home(Model model) {
		model.addAttribute("idees",daoIdee.findAll());
		return "idee";
	}
	
	@PostMapping(value="/idee")
	public String ajouteIdee(@Valid @ModelAttribute("idee") Idee idee, BindingResult result, Model model) {
		
		daoIdee.save(idee);
		
		return "redirect:/menu";
		
	}
	
}
