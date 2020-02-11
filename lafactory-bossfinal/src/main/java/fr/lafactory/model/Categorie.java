package fr.lafactory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.views.Views;






@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="CAT_NOM", nullable = false, length = 100)
	@NotEmpty
	@JsonView({Views.Categorie.class, Views.ModeleWithCategories.class})
	private String nom;
	@ManyToOne
	@JoinColumn(name = "CATMERE_ID")
	@JsonView(Views.ModeleWithCategories.class)
	private Categorie catMere;
	@JsonView(Views.CategorieFetchingCategoriesFilles.class)
	@OneToMany(mappedBy = "catMere", cascade = CascadeType.REMOVE)
	private List<Categorie> catFilles;
	
	@ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private List<Modele> modeles;
	
	
	// getters et setters 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCatMere() {
		return catMere;
	}

	public void setCatMere(Categorie catMere) {
		this.catMere = catMere;
	}

	public List<Categorie> getCatFilles() {
		return catFilles;
	}

	public void setCatFilles(List<Categorie> catFilles) {
		this.catFilles = catFilles;
	}

	public List<Modele> getModeles() {
		return modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}
	
	
	

}
