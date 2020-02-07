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

//import fr.formation.views.Views;
import fr.lafactory.dao.IDAOUtilisateur;
import fr.lafactory.model.Utilisateur;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	@GetMapping
//	@JsonView(Views.Utilisateur.class )
	public List<Utilisateur> findAll() {
		 return this.daoUtilisateur.findAll();
	}
	
	@PostMapping
//	@JsonView(Views.Utilisateur.class )
	public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		daoUtilisateur.save(utilisateur);
		
		
		return utilisateur;
	}
	
	@GetMapping("/{id}")
//	@JsonView(Views.Utilisateur.class )
	@Transactional
	public Utilisateur findById(@PathVariable int id) {
//	 return this.daoFournisseur.findByIdFetchingProduits(id);
		
		Utilisateur u = daoUtilisateur.findById(id).get();
		return u;
	}
	
	@PutMapping("/{id}")
//	@JsonView(Views.Utilisateur.class )
	public Utilisateur save (@PathVariable int id, @RequestBody Utilisateur utilisateur) {
		this.daoUtilisateur.save(utilisateur);
		return utilisateur;
	}
	
	@DeleteMapping("/{id}")
	public void Supprimer(@PathVariable int id)  {
		daoUtilisateur.deleteById(id);
	}
}
