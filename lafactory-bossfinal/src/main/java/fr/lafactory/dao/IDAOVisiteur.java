package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Visiteur;

public interface IDAOVisiteur extends JpaRepository<Visiteur,Integer>{

}
