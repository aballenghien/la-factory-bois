package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Modele;

public interface IDAOModele extends JpaRepository<Modele, Integer> {
	
	

}
