package fr.lafactory.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lafactory.dao.IDAOAppreciation;

@RestController
@RequestMapping("/api/appreciation")
@CrossOrigin("*")
public class AppreciationRestController {

	@Autowired
	IDAOAppreciation daoAppreciation;
}
