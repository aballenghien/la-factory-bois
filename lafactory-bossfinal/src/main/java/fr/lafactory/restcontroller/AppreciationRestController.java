package fr.lafactory.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.dao.IDAOAppreciation;
import fr.lafactory.exception.AppreciationValidationException;
import fr.lafactory.model.Appreciation;
import fr.lafactory.views.Views;

@RestController
@RequestMapping("/api/appreciation")
@CrossOrigin("*")
public class AppreciationRestController {

	@Autowired
	IDAOAppreciation daoAppreciation;
	
	@PostMapping("/ajouter")
	@JsonView( Views.Appreciation.class)
	public Appreciation add(@Valid @RequestBody Appreciation appreciation, BindingResult result) throws AppreciationValidationException {
		if(result.hasErrors()) {
			throw new AppreciationValidationException();
		}
		daoAppreciation.save(appreciation);
		return appreciation;
	}
	
	@PutMapping("/modifier")
	@JsonView( Views.Appreciation.class)
	public Appreciation put(@Valid @RequestBody Appreciation appreciation, BindingResult result) throws AppreciationValidationException {
		if(result.hasErrors()) {
			throw new AppreciationValidationException();
		}
		daoAppreciation.save(appreciation);
		return appreciation;
	}
	
}
