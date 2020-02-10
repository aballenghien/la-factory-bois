package fr.lafactory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.lafactory.dao.IDAOEtape;
import fr.lafactory.dao.IDAOModele;
import fr.lafactory.model.Etape;
import fr.lafactory.model.Modele;

@Controller
public class EtapeController {

	@Autowired
	private IDAOEtape daoEtape;

	@Autowired
	private IDAOModele daoModele;
	
	@GetMapping("/etape")
	public String findAll(Model model) {
		model.addAttribute("etapes", daoEtape.findAll());
		return "etape";
	}

	
	@GetMapping("/ajouterEtape")
	public String add(Model model) {
		model.addAttribute("etape", new Etape());
		return "ajouterEtape";
	}

	@PostMapping("/ajouterEtape")
	public String add(@Valid @ModelAttribute Etape etape, BindingResult result) {
		
	if(result.hasErrors()) {
		return "ajouterEtape";
	}
	
	daoEtape.save(etape);
	return "redirect:/etape";
	}
	
	
	
	
	@GetMapping("/supprimerEtape")
	public String delete(@RequestParam int id) {
		
		daoEtape.deleteById(id);
		return "redirect:/etape";
	}
	

	
	@GetMapping("/modifierEtape")
	public String edit(Model model, @RequestParam int id) {
		model.addAttribute("etapes", daoEtape.findAll());
		Etape e = daoEtape.findById(id).orElse(null);
		
		model.addAttribute("etape", e);
		return "ajouterEtape";
	}
	
	@PostMapping("/modifierEtape")
	public String edit(@Valid @ModelAttribute Etape etape, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ajouterEtape";
		}
		daoEtape.save(etape);
		return "redirect:/etape";
		
	}
	

	@ModelAttribute("modeles")
	public List<Modele> getModeles(){
		return daoModele.findAll();
	}
	
	
}
