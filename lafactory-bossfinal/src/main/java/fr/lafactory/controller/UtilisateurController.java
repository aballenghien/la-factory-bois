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
import org.springframework.web.bind.annotation.RequestParam;

import fr.lafactory.dao.IDAOUtilisateur;
import fr.lafactory.model.Role;
import fr.lafactory.model.Utilisateur;

@Controller
public class UtilisateurController {
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@GetMapping("/listeUtilisateur")
	public String findAll(Model model) {
		model.addAttribute("utilisateurs", daoUtilisateur.findAll());
		return "listeUtilisateur";
	}
	
	
	@GetMapping("/ajouterUtilisateur")
	public String ajouterProduit(Model model) {
		model.addAttribute("utilisateur",  new Utilisateur());
		
		return "formUtilisateur";
	}
	
	@PostMapping("/ajouterUtilisateur")
	public String ajouterUtilisateur(
			@Valid
			@ModelAttribute Utilisateur utilisateur,
			BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			System.out.println(utilisateur.getPrenom());
			System.out.println(utilisateur.getNom());
			System.out.println(utilisateur.getPassword());
			System.out.println(utilisateur.getUsername());
			System.out.println(result.getErrorCount());
			System.out.println(result);
			
			return "formUtilisateur";
		}
		
//		utilisateur.setRole(role);
		
		
		daoUtilisateur.save(utilisateur);
		
		return "redirect:/listeUtilisateur";
	}
	
	@GetMapping("/supprimerUtilisateur")
	public String supprimerUtilisateur(
			@RequestParam int id) {
		
		daoUtilisateur.deleteById(id);
		return "redirect:/listeUtilisateur";
	}
	
	
	@GetMapping("/editerUtilisateur")
	public String edit(Model model, @RequestParam int id) {
		Utilisateur u = daoUtilisateur.findById(id).orElse(null);
		model.addAttribute("utilisateur",u);
		return "formUtilisateur";
	}
	
	@PostMapping("/editerUtilisateur")
	public String edit(@Valid
			@ModelAttribute Utilisateur utilisateur, BindingResult result, Model model) {
		
		if(result.hasErrors ()) {
			return "formUtilisateur";
		}
		
		daoUtilisateur.save(utilisateur);
		return "redirect:/listeUtilisateur";
	}
	
	@ModelAttribute("utilisateurs")
	public List<Utilisateur> getUtilisateurs(){
		return daoUtilisateur.findAll();
	}
	
	@ModelAttribute("roles")
	public List<Role> getRoles(){
		List<Role> roles = new ArrayList<Role>();
		
		roles.add(Role.ADMINISTRATEUR);
		roles.add(Role.TECHNICIEN);
		return roles;
	}

}
