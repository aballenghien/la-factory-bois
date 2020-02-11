package fr.lafactory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import fr.lafactory.views.Views;



@Entity
@Table(name = "appreciation")
public class Appreciation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APP_ID")
	@JsonView( {Views.Common.class,Views.ModeleWithAppreciation.class})
	private int id;
	
	@Column(name = "APP_NOTE")
	@JsonView( {Views.Appreciation.class,Views.ModeleWithAppreciation.class})
	private double note;
	
	@Column(name = "APP_MESSAGE_DATE")
	@Temporal(TemporalType.DATE)
	@JsonView( {Views.Appreciation.class,Views.ModeleWithAppreciation.class})
	private Date dateCommentaire;
	
	@Column(name = "APP_PSEUDO")
	@JsonView( {Views.Appreciation.class,Views.ModeleWithAppreciation.class})
	private String pseudo;
	
	@ManyToOne
	@JoinColumn(name="APP_MOD_ID", nullable = false)
	@JsonView( Views.Appreciation.class)
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
