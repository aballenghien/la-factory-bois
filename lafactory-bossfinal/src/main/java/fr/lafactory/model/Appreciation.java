package fr.lafactory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "appreciation")
public class Appreciation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APP_ID")
	private int id;
	
	@Column(name = "APP_NOTE")
	private double note;
	
	@Column(name = "APP_MESSAGE_DATE")
	@Temporal(TemporalType.DATE)
	private Date dateCommentaire;
	
	@Column(name = "APP_PSEUDO")
	private String pseudo;
	
	@ManyToOne
	private Modele modele;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}
}
