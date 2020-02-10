package fr.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.views.Views;


@Entity
@Table(name="etape")
public class Etape {

	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ETA_ID")
	private int id;
	
	@JsonView(Views.Etape.class)
	@Column(name="ETA_ORDRE", nullable = false)
	@NotNull
	private int ordre;
	
	@JsonView(Views.Etape.class)
	@Column(name="ETA_TITRE")
	private String titre;
	
	@JsonView(Views.Etape.class)
	@Column(name="ETA_TEXTE")
	private String texte;
	
	@JsonView(Views.Etape.class)
	@Column(name="ETA_IMAGE")
	private String image;
	
	@JsonView(Views.Etape.class)
	@ManyToOne
	@JoinColumn(name="ETA_MOD_ID", nullable = false)
	@NotNull
	private Modele modele;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}
	
	
	
}
