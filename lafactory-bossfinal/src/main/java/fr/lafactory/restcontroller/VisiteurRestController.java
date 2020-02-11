package fr.lafactory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOVisiteur;
import fr.lafactory.model.Visiteur;
import fr.lafactory.views.Views;

@RestController
@RequestMapping("/api/visiteur")
@CrossOrigin("*")
public class VisiteurRestController {

	@Autowired
	IDAOVisiteur daoVisiteur;
	
	@GetMapping
	@JsonView(Views.Visiteur.class )
	public List<Visiteur> findAll() {
		 return this.daoVisiteur.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Visiteur.class )
	public Visiteur save(@RequestBody Visiteur visiteur) {
		daoVisiteur.save(visiteur);
		
		
		return visiteur;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Visiteur.class )
	@Transactional
	public Visiteur findById(@PathVariable int id) {
		
		Visiteur v = daoVisiteur.findById(id).get();
		return v;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Visiteur.class )
	public Visiteur save (@PathVariable int id, @RequestBody Visiteur visiteur) {
		this.daoVisiteur.save(visiteur);
		return visiteur;
	}
	
	@DeleteMapping("/{id}")
	public void Supprimer(@PathVariable int id)  {
		daoVisiteur.deleteById(id);
	}
}
