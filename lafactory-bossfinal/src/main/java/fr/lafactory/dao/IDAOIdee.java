package fr.lafactory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.lafactory.model.Idee;
import fr.lafactory.model.Visiteur;

public interface IDAOIdee extends JpaRepository<Idee,Integer> {

	public Idee findByVisiteur(Visiteur visiteur);
	
	@Query("select i from Idee i where i.archive = false")
	public List<Idee> findIdeeWhereArchiveIsFalse();

	@Query("select i from Idee i where i.archive = true")
	public List<Idee> findIdeeWhereArchiveIsTrue();
}
