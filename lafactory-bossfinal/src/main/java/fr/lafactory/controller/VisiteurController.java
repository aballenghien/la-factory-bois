package fr.lafactory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@GetMapping("/listeVisiteur")
	public String findAll(Model model) {
		model.addAttribute("visiteurs", daoVisiteur.findAll());
		return "listeVisiteur";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@GetMapping("/ajouterVisiteur")
	public String ajouterProduit(Model model) {
		model.addAttribute("visiteur",  new Visiteur());
		
			return "formVisiteur";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@PostMapping("/ajouterVisiteur")
	public String ajouterUtilisateur(
			@Valid
			@ModelAttribute Visiteur visiteur,
			BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			
			return "formVisiteur";
		}
		
		System.out.println(visiteur.getPrenom());
		daoVisiteur.save(visiteur);
		return "redirect:/listeVisiteur";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@GetMapping("/supprimerVisiteur")
	public String supprimerUtilisateur(
			@RequestParam int id) {
		
		daoVisiteur.deleteById(id);
		return "redirect:/listeVisiteur";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@GetMapping("/editerVisiteur")
	public String edit(Model model, @RequestParam int id) {
		Visiteur v = daoVisiteur.findById(id).orElse(null);
		model.addAttribute("visiteur",v);
		return "formVisiteur";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@PostMapping("/editerVisiteur")
	public String edit(@Valid
			@ModelAttribute Visiteur visiteur, BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			return "formVisiteur";
		}
		
		daoVisiteur.save(visiteur);
		return "redirect:/listeVisiteur";
	}
	
	
	@ModelAttribute("visiteurs")
	public List<Visiteur> getVisiteurs(){
		return daoVisiteur.findAll();
	}
}
