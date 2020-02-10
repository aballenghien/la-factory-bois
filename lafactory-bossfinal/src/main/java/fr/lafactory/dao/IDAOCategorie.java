package fr.lafactory.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer>{
	
	public Categorie findByNom (String nom);
	
	public Optional<List<Categorie>> findByCatMere(Categorie catMere);
	

}
