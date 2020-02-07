package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer>{
	
	public Categorie findByNom (String nom);
	

}
