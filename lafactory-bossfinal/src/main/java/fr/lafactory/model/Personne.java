package fr.lafactory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PER_TYPE")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PER_ID")
	protected int id;
	
	@Column(name = "PER_NOM", length = 100)
	protected String nom;
	
	@Column(name = "PER_PRENOM", length = 100)
	protected String prenom;
	
	@Column(name = "PER_MAIL", length = 100)
	protected String mail;
	
	@OneToMany(mappedBy = "visiteur")
	protected List<Idee> idees;
	
	@Column(name ="PER_ROLE",nullable = false)
	@Enumerated(EnumType.STRING)
	protected Role role = Role.VISITEUR;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Idee> getIdees() {
		return idees;
	}

	public void setIdees(List<Idee> idees) {
		this.idees = idees;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
