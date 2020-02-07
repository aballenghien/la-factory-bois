package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Utilisateur;


public interface IDAOUtilisateur extends JpaRepository<Utilisateur,Integer> {

}
