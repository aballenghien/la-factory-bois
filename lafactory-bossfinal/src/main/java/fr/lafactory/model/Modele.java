package fr.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="modele")
public class Modele {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOD_ID")
	private int id;
	
	@Column(name = "MOD_NOM", length = 100, nullable = false)
	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 100, message = "Le nom du modèle ne doit pas dépasser 100 caractères")
	private String nom;
	
	@Column(name = "MOD_TPS_REAL")
	private int tempsrealisation;
	
	@Column(name = "MOD_NIV")
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	
	@Column(name = "MOD_QTE_BOIS")
	private int qteBoisNecessaire;
	
	@Transient
	private double noteMoy;
	
	@Column(name = "MOD_VISIBLE")
	private boolean visible;
	
	@Column(name = "MOD_LIEN_VIDEO")
	private String lienVideo;
	
	@OneToMany(mappedBy = "modele")
	private List<Etape> etapes;
	
	@ManyToMany(mappedBy = "modeles")
	private List<Categorie> categories;
	
	public Modele() {
		
	}

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

	public int getTempsrealisation() {
		return tempsrealisation;
	}

	public void setTempsrealisation(int tempsrealisation) {
		this.tempsrealisation = tempsrealisation;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public int getQteBoisNecessaire() {
		return qteBoisNecessaire;
	}

	public void setQteBoisNecessaire(int qteBoisNecessaire) {
		this.qteBoisNecessaire = qteBoisNecessaire;
	}

	public double getNoteMoy() {
		return noteMoy;
	}

	public void setNoteMoy(int noteMoy) {
		this.noteMoy = noteMoy;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getLienVideo() {
		return lienVideo;
	}

	public void setLienVideo(String lienVideo) {
		this.lienVideo = lienVideo;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
	
}
