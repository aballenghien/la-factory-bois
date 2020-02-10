package fr.lafactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.views.Views;

@Entity
@Table(name="etape")
public class Etape {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ETA_ID")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="ETA_ORDRE", nullable = false)
	@NotEmpty
	@JsonView({Views.Etape.class,Views.ModeleWithEtapes.class})
	private int ordre;
	
	@Column(name="ETA_TITRE")
	@JsonView({Views.Etape.class,Views.ModeleWithEtapes.class})
	private String titre;
	
	@Column(name="ETA_TEXTE")
	@JsonView({Views.Etape.class,Views.ModeleWithEtapes.class})
	private String texte;
	
	@Column(name="ETA_IMAGE")
	@JsonView({Views.Etape.class,Views.ModeleWithEtapes.class})
	private String image;
	
	@ManyToOne
	@JoinColumn(name="ETA_MOD_ID", nullable = false)
	@NotEmpty
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
