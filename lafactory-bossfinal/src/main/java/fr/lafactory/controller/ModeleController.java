package fr.lafactory.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.api.Views;
import fr.lafactory.dao.IDAOCategorie;
import fr.lafactory.dao.IDAOModele;
import fr.lafactory.model.Categorie;
import fr.lafactory.model.Modele;
import fr.lafactory.model.Niveau;

@Controller
public class ModeleController {
	
	@Autowired
	private IDAOModele daoModele;
	
	@Autowired
	private IDAOCategorie daoCategorie;

	@GetMapping("/modele")
	public String getModeles(Model model) {
		model.addAttribute("lstModeles",daoModele.findAll());
		return "/listeModeles";
	}
	
	@GetMapping("/supprimerModele/{id}")
	public String deleteModele(Model model, @PathVariable int id) {
		daoModele.deleteById(id);
		return "redirect:/modele";
	}
	
	@GetMapping("/ajouterModele")
	public String add(Model model) {
		Modele modele = new Modele();
		model.addAttribute("modele",modele);
		return "/formModele";
	}
	
	@PostMapping("/ajouterModele")
	@JsonView(Views.ModeleWithCategories.class)
	public String add(@Valid @ModelAttribute Modele modele, BindingResult result, Model model, @RequestParam String listeDesCategories) {
		if(result.hasErrors()) {
			model.addAttribute("modele",modele);
			model.addAttribute("listeDesCategories",listeDesCategories);
			return "/formModele";
		}
		if(modele.getCategories() == null) {
			modele.setCategories(new ArrayList<Categorie>());
		}
		List<String> categoriesAAjouter = Arrays.asList(listeDesCategories.split("\n"));
		categoriesAAjouter.stream().forEach(cat -> {
			String idCat = cat.split(":")[0];
			if(!idCat.equals("")) {
				Categorie catAAjouter = daoCategorie.findById(Integer.parseInt(cat.split(":")[0])).orElse(null);
				modele.getCategories().add(catAAjouter);
			}
		});
		
		
		daoModele.save(modele);

		
		return "redirect:/modele";
	}
	
	@GetMapping( "/modifierModele/{id}")
	@JsonView(Views.ModeleWithCategories.class)
	public String editModeleGet(@PathVariable(value="id", required=true) int id,Model model) {
		Modele m = daoModele.findByIdWithCategories(id).orElse(null);
		String listeDesCategories = "";
		for(Categorie c : m.getCategories()){
			listeDesCategories+=c.getId()+":"+c.getNom()+"\n";
		}
		model.addAttribute("modele",m);
		model.addAttribute("listeDesCategories",listeDesCategories);
		return "formModele";
	}
	
	@PostMapping( "/modifierModele/{id}")
	public String editModelePost(@PathVariable(value="id", required=true) int id,
			@Valid @ModelAttribute Modele modele,
			BindingResult result,
			Model model,
			@RequestParam String listeDesCategories) {
		if(result.hasErrors()) {
			model.addAttribute(modele);
			model.addAttribute("listeDesCategories",listeDesCategories);
			return "formModele";
		}
		modele.setId(id);
		if(modele.getCategories() == null) {
			modele.setCategories(new ArrayList<Categorie>());
		}
		List<String> categoriesAAjouter = Arrays.asList(listeDesCategories.split("\n"));
		categoriesAAjouter.stream().forEach(cat -> {
			String idCat = cat.split(":")[0];
			if(!idCat.equals("")) {
				Categorie catAAjouter = daoCategorie.findById(Integer.parseInt(cat.split(":")[0])).orElse(null);
				modele.getCategories().add(catAAjouter);
			}
		});
		daoModele.save(modele);
		return "redirect:/modele";
	}
	
	
	
	@ModelAttribute("lstNiveaux")
	public List<Niveau> getNiveaux(){
		List<Niveau> niveaux = Arrays.asList(Niveau.values());
		return niveaux;
	}
	
	@ModelAttribute("lstCategories")
	public List<Categorie> getCategories(){
		List<Categorie> categories = daoCategorie.findAll();
		return categories;
	}
	
}
