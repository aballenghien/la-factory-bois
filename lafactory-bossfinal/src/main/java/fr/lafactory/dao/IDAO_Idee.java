package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Idee;

public interface IDAO_Idee extends JpaRepository<Idee,Integer> {

	public Idee findByVisiteur(Visiteur visiteur);
}
