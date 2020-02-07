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
import javax.validation.constraints.Size;

@Entity
@Table(name="idee")
public class Idee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDE_ID")
	private int id;
	@Column(name="IDE_DESCRIPTION", length = 1000, nullable = false)
	@NotEmpty
	@Size(max = 1000)
	private String description;
	@Column(name = "IDE_ARCHIVE")
	private Boolean archive = false;
	@ManyToOne
	@JoinColumn(name = "IDE_VISITEUR_ID")
	private Visiteur visiteur;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Visiteur getVisiteur() {
		return visiteur;
	}
	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}
}
