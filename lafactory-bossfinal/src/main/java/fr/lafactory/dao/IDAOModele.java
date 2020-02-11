package fr.lafactory.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.model.Modele;
import fr.lafactory.model.Niveau;
import fr.lafactory.views.Views;

public interface IDAOModele extends JpaRepository<Modele, Integer> {
	
	@Query("Select m from Modele m left join fetch m.categories c where m.id=?1")
	@JsonView(Views.ModeleWithCategories.class)
	public Optional<Modele> findByIdWithCategories(int id);
	@JsonView(Views.ModeleWithEtapes.class)
	@Query("Select m from Modele m left join fetch m.etapes e where m.id=?1")
	public Modele findByIdWithEtapes(int id);
	

	@Query("SELECT m from Modele m left join fetch m.appreciations a where m.id=?1")
	@JsonView(Views.ModeleWithAppreciation.class)
	public Modele modeleWithNote(int id);
	
	@Query("Select m from Modele m left join m.categories c where c.id=?1")
	@JsonView(Views.Modele.class)
	public Optional<List<Modele>> findByIdCategorie(int idCat);
	
	@Query("Select m from Modele m where m.niveau=?1")
	@JsonView(Views.Modele.class)
	public Optional<List<Modele>> findByNiveau(Niveau niveau);
	
	@Query("Select m from Modele m where m.nom LIKE %?1%")
	@JsonView(Views.Modele.class)
	public Optional<List<Modele>> findByNomContaining(String nom);
	
	@Query("Select m from Modele m left join m.categories c where c.id=?1 and m.niveau=?2 ")
	@JsonView(Views.Modele.class)
	public Optional<List<Modele>> findByCategorieAndNiveau( int idCategorie ,Niveau niveau);

}
