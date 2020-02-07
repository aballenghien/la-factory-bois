package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Idee;
import fr.lafactory.model.Visiteur;

public interface IDAOIdee extends JpaRepository<Idee,Integer> {

	public Idee findByVisiteur(Visiteur visiteur);
}
