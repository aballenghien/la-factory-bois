package fr.lafactory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOModele;
import fr.lafactory.model.Modele;
import fr.lafactory.model.Niveau;
import fr.lafactory.views.Views;

@RestController
@CrossOrigin("*")
@RequestMapping("api/modele")
public class ModeleRestController {
	
	@Autowired
	private IDAOModele daoModele;
	
	//FindById
	@GetMapping("{id}")
	@JsonView(Views.ModeleWithEtapes.class)
	public Modele getModeleById(@PathVariable int id) {
		return daoModele.findByIdWithEtapes(id);
	}
	
	//FindByCategorie
	@GetMapping("/categorie/{idCategorie}")
	@JsonView(Views.Modele.class)
	public List<Modele> getModeleByCategorie(@PathVariable int idCategorie) {
		return daoModele.findByIdCategorie(idCategorie).orElse(null);
	}
	
	//FindByNiveau
	@GetMapping("/niveau/{niveau}")
	@JsonView(Views.Modele.class)
	public List<Modele> getModeleByNiveau(@PathVariable Niveau niveau) {
		return daoModele.findByNiveau(niveau).orElse(null);
	}
	
	@GetMapping("categorie/{idCategorie}/niveau/{niveau}")
	@JsonView(Views.Modele.class)
	public List<Modele> getModeleByCategorieAndNiveau(@PathVariable int idCategorie, @PathVariable Niveau niveau) {
		return daoModele.findByCategorieAndNiveau(idCategorie,niveau).orElse(null);
	}
	
	//FindByNom
	@GetMapping("/nom/{nom}")
	@JsonView(Views.Modele.class)
	public List<Modele> getModeleByNom(@PathVariable String nom) {
		return daoModele.findByNomContaining(nom).orElse(null);
	}
}
