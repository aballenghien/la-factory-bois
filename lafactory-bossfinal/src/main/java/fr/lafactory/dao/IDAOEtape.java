package fr.lafactory.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.model.Etape;
import fr.lafactory.views.Views;

public interface IDAOEtape extends JpaRepository<Etape, Integer> {

	@Query("Select e from Etape e left join e.modele m where m.id=?1")
	@JsonView(Views.Etape.class)
	public Optional<List<Etape>> findEtapesByIdModele(int id);
	

}
