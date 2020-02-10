package fr.lafactory.model;

import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.views.Views;

@Entity
@Table(name="modele")
public class Modele {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOD_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name = "MOD_NOM", length = 100, nullable = false)
	@NotBlank(message = "Le nom doit être renseigné")
	@Size(max = 100, message = "Le nom du modèle ne doit pas dépasser 100 caractères")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private String nom;
	
	@Column(name = "MOD_DESC", length = 1000, nullable = false)
	@Size(max = 1000, message = "Le nom du modèle ne doit pas dépasser 1000 caractères")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private String description;
	
	@Column(name = "MOD_IMAGE", length = 1000, nullable = false)
	@Size(max = 1000, message = "L'url de l'image ne doit pas dépasser 1000 caraactères")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private String urlImage;
	
	@Column(name = "MOD_TPS_REAL")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private int tempsRealisation;
	
	@Column(name = "MOD_NIV")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	
	@Column(name = "MOD_QTE_BOIS")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private int qteBoisNecessaire;
	
	@Transient
	private double noteMoy;
	
	@Column(name = "MOD_VISIBLE")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private boolean visible;
	
	@Column(name = "MOD_LIEN_VIDEO")
	@JsonView({Views.Modele.class, Views.ModeleWithCategories.class, Views.ModeleWithEtapes.class})
	private String lienVideo;
	
	@OneToMany(mappedBy = "modele", cascade = CascadeType.REMOVE)
	@JsonView({ Views.ModeleWithEtapes.class, Views.ModeleWithEtapesAndCategories.class})
	private List<Etape> etapes;
	
	@ManyToMany(mappedBy = "modeles", cascade = CascadeType.PERSIST)
	@JsonView({Views.ModeleWithCategories.class, Views.ModeleWithEtapesAndCategories.class})
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
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getTempsRealisation() {
		return tempsRealisation;
	}

	public void setTempsRealisation(int tempsRealisation) {
		this.tempsRealisation = tempsRealisation;
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
