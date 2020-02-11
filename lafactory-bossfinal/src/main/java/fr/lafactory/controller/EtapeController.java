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
	
	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@GetMapping("/etape/modele")
	public String findAll(Model model, @RequestParam int idModele) {
		model.addAttribute("etapes", daoEtape.findEtapesByIdModele(idModele).orElse(null));
		model.addAttribute("modele",daoModele.findById(idModele).orElse(null));
		return "etape";
	}

	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@GetMapping("/ajouterEtape")
	public String add(Model model, @RequestParam int idModele) {
		Etape etape = new Etape();
		etape.setModele(daoModele.findById(idModele).orElse(null));
		model.addAttribute("etape", etape);
		return "ajouterEtape";
	}

	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@PostMapping("/ajouterEtape")
	public String add(@Valid @ModelAttribute Etape etape, BindingResult result, @RequestParam int idModele) {
		
	if(result.hasErrors()) {
		return "ajouterEtape";
	}
	
	daoEtape.save(etape);
	return "redirect:/etape/modele?idModele="+etape.getModele().getId();
	}
	
	
	
	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@GetMapping("/supprimerEtape")
	public String delete(@RequestParam int id) {
		Etape etape = daoEtape.findById(id).orElse(null);
		daoEtape.deleteById(id);
		return "redirect:/etape/modele?idModele="+etape.getModele().getId();
	}
	

	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@GetMapping("/modifierEtape")
	public String edit(Model model, @RequestParam int id) {
		model.addAttribute("etapes", daoEtape.findAll());
		Etape e = daoEtape.findById(id).orElse(null);
		
		model.addAttribute("etape", e);
		return "ajouterEtape";
	}
	
	@PreAuthorize("hasRole('ADMINISTRATEUR') or hasRole('TECHNICIEN')")
	@PostMapping("/modifierEtape")
	public String edit(@Valid @ModelAttribute Etape etape, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ajouterEtape";
		}
		daoEtape.save(etape);
		return "redirect:/etape/modele?idModele="+etape.getModele().getId();
		
	}
	

	@ModelAttribute("modeles")
	public List<Modele> getModeles(){
		return daoModele.findAll();
	}
	
	
}
