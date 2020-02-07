package fr.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Etape;

public interface IDAOEtape extends JpaRepository<Etape, Integer> {

}
