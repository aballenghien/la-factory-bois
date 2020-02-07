package fr.lafactory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lafactory.model.Appreciation;

public interface IDAOAppreciation extends JpaRepository<Appreciation, Integer> {

	public List<Appreciation> findByPseudo(String pseudo);
}
