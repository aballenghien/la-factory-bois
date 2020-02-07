package fr.lafactory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.lafactory.dao.IDAOUtilisateur;
import fr.lafactory.dao.IDAOVisiteur;
import fr.lafactory.model.Utilisateur;
import fr.lafactory.model.Visiteur;

@Controller
public class VisiteurController {
	
	@Autowired
	private IDAOVisiteur daoVisiteur;
	
	@GetMapping("/visiteur")
	public String findAll(Model model) {
		model.addAttribute("visiteurs", daoVisiteur.findAll());
		return "listeVisiteur";
	}
	
	
	@GetMapping("/ajouterVisiteur")
	public String ajouterProduit(Model model) {
		model.addAttribute("visiteur",  new Visiteur());
		
			return "formVisiteur";
	}
	
	@PostMapping("/ajouterVisiteur")
	public String ajouterUtilisateur(
			@Valid
			@ModelAttribute Utilisateur utilisateur,
			BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			return "redirect:/listeVisiteur";
		}
		
		daoVisiteur.save(utilisateur);
		return "redirect:/listeVisiteur";
	}
	
	@GetMapping("/supprimerVisiteur")
	public String supprimerUtilisateur(
			@RequestParam int id) {
		
		daoVisiteur.deleteById(id);
		return "redirect:/listeVisiteur";
	}
	
	
	@GetMapping("/editerVisiteur")
	public String edit(Model model, @RequestParam int id) {
		Visiteur v = daoVisiteur.findById(id).orElse(null);
		model.addAttribute("visiteur",v);
		return "formVisiteur";
	}
	
	@PostMapping("/editerVisiteur")
	public String edit(@Valid
			@ModelAttribute Visiteur visiteur, BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			return "listeVisiteur";
		}
		
		daoVisiteur.save(visiteur);
		return "redirect:/listeVisiteur";
	}
	
	

}
