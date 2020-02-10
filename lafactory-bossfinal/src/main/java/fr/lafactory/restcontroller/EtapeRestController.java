package fr.lafactory.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOEtape;
import fr.lafactory.model.Etape;
import fr.lafactory.views.Views;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/etape")
public class EtapeRestController {

	@Autowired
	private IDAOEtape daoEtape;
	
	
@GetMapping("/{id}")
@JsonView(Views.Etape.class)
public List<Etape> findByModel(@PathVariable int id) {
	return daoEtape.findEtapesByIdModele(id).orElse(null);
}
	
	
	
	
}
