package fr.lafactory.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOIdee;
import fr.lafactory.model.Idee;
import fr.lafactory.views.Views;

@RestController
@CrossOrigin("*")
@RequestMapping("api/idee")
public class IdeeRestController {

	@Autowired
	private IDAOIdee daoIdee;
	
	@GetMapping
	@JsonView(Views.Idee.class)
	public List<Idee> afficheListe(){
		return daoIdee.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Idee.class)
	public Idee add(@Valid @RequestBody Idee idee, BindingResult result) {
		
		daoIdee.save(idee);
		
		return idee;
	}
	

	@PutMapping("/{id}")
	@JsonView(Views.Idee.class)
	public Idee modifie(@PathVariable int id, @RequestBody Idee idee) {
		daoIdee.save(idee);
		return idee;
	}
	
}
