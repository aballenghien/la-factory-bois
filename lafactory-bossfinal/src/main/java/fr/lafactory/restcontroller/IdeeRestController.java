package fr.lafactory.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Idee> afficheListe(@Valid @RequestBody boolean booleen, BindingResult result){
		return daoIdee.findIdeeWhereArchiveIsTrue();
	}
	
//	@GetMapping("/listeIdee")
//	@JsonView(Views.Idee.class)
//	public List<Idee> retourneListe(@Valid @RequestBody boolean booleen, BindingResult result) {
//		
//		if (booleen) {
//			return daoIdee.findAll();
//		} else {
//			return daoIdee.findIdeeWhereArchiveIsFalse();
//		}
//		
//	}
	
	@GetMapping("/listeIdee")
	@JsonView(Views.Idee.class)
	public void retourneListe(@Valid @RequestBody boolean booleen, BindingResult result, Model model) {

		System.out.println("");
		System.out.println("fr");
		System.out.println("");
		model.addAttribute("idees",daoIdee.findAll());
		
		
		
	}
	

	
	
}
