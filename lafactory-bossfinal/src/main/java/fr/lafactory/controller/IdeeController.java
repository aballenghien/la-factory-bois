package fr.lafactory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fr.lafactory.dao.IDAOIdee;
import fr.lafactory.dao.IDAOVisiteur;
import fr.lafactory.model.Idee;

@Controller
public class IdeeController {
	
	@Autowired
	private IDAOIdee daoIdee;
	
	@Autowired 
	private IDAOVisiteur daoVisiteur;
	
	@GetMapping(value="/idee")
	public String home(Model model) {
		
		model.addAttribute("idees",daoIdee.findIdeeWhereArchiveIsFalse());
		boolean affiche = false;
		model.addAttribute("affiche",affiche);
		return "idee";
	}
	
//	
//	@PostMapping(value="/idee")
//	public String ajouteIdee(@RequestParam String description,Model model) {
//		Idee idee = new Idee();
//		idee.setDescription(description);
//		idee.setVisiteur(daoVisiteur.findById(1).get());
//		daoIdee.save(idee);
//		model.addAttribute("idees",daoIdee.findIdeeWhereArchiveIsFalse());
//		boolean affiche = false;
//		model.addAttribute("affiche",affiche);
//		return "idee";
//		
//	}
	
	@GetMapping("/archiveIdee")
	public String edit(@RequestParam int id) {
		Idee idee=daoIdee.findById(id).get();
		idee.setArchive(true);
		daoIdee.save(idee);
		
		return "redirect:/idee";
		
	}
//
//	@GetMapping(value="/formulaire")
//	public String formulaire(Model model) {
//		model.addAttribute("idees", daoIdee.findAll());
//		return "ajProd";
//	}
//	
//	@PostMapping(value="/formulaire")
//	public String ajoutProduit(@Valid @ModelAttribute("produit") Idee idee, BindingResult result, Model model) {
//		
//		if (result.hasErrors()) {
//			model.addAttribute("fournisseurs", daoIdee.findAll());
//			return "ajProd";
//		}
//		daoIdee.save(idee);
//		
//		return "redirect:/listeProd";
//		
//	}

	@GetMapping("/ajouteIdee")
	public String edit(@RequestBody Idee idee) {
		daoIdee.save(idee);
		
		return "redirect:/idee";
		
	}
	
	
//	@GetMapping("/cacherIdee")
//	public String delete(@RequestParam int id) {
//		daoIdee.findById(id).get().setArchive(true);
//		return "redirect:/idee";
//	}
	
}
