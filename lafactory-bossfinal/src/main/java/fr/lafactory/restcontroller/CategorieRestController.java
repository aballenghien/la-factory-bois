package fr.lafactory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOCategorie;
import fr.lafactory.model.Categorie;
import fr.lafactory.views.Views;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorie")
public class CategorieRestController {
	
	@Autowired
	IDAOCategorie daoCategorie;
	
	@GetMapping
	@JsonView(Views.Categorie.class)
	public List<Categorie> findAll(){
		return this.daoCategorie.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Categorie.class)
	public List<Categorie> findByCategorieMere (@PathVariable int id) {
		return daoCategorie.findByCatMere(daoCategorie.findById(id).orElse(null)).orElse(null);
		
	}
	

}
