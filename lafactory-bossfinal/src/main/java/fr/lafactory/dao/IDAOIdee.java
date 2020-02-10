package fr.lafactory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Idee;
import fr.lafactory.model.Visiteur;

public interface IDAOIdee extends JpaRepository<Idee,Integer> {

	public Idee findByVisiteur(Visiteur visiteur);
	//public List<Idee> findAllWithArchiveIsFalse();
}
