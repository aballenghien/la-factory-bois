package fr.lafactory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.lafactory.dao.IDAOModele;
import fr.lafactory.model.Modele;
import fr.lafactory.model.Niveau;

@Controller
public class ModeleController {
	
	@Autowired
	private IDAOModele daoModele;

	@GetMapping("/listeModeles")
	public String getModeles(Model model) {
		model.addAttribute("lstModeles",daoModele.findAll());
		model.addAttribute
		return "/listeModeles";
	}
	
	@GetMapping("/ajouterModele")
	public String add(Model model) {
		Modele modele = new Modele();
		model.addAttribute("modele",modele);
		return "/formModele";
	}
	
	@PostMapping("/ajouterModele")
	public String add(@Valid @ModelAttribute Modele modele, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("modele",modele);
			return "/formModele";
		}
		return "redirect:/listeModeles";
	}
	
	@ModelAttribute("lstNiveaux")
	public List<Niveau> getNiveaux(){
		List<Niveau> niveaux = new ArrayList<Niveau>();
		niveaux.addAll(Niveau.values());
		return niveaux;
	}
	
}
