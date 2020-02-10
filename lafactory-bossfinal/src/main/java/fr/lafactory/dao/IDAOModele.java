package fr.lafactory.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.api.Views;
import fr.lafactory.model.Modele;

public interface IDAOModele extends JpaRepository<Modele, Integer> {
	
	@Query("Select m from Modele m left join fetch m.categories c where m.id=?1")
	@JsonView(Views.ModeleWithCategories.class)
	public Optional<Modele> findByIdWithCategories(int id);

}
