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
@Table(name = "visiteur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="UTI_TYPE")
public class Visiteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	protected int id;
	
	@Column(name = "UTI_NOM")
	protected String nom;
	
	@Column(name = "UTI_PRENOM")
	protected String prenom;
	
	@Column(name = "UTI_MAIL")
	protected String mail;
	
	@OneToMany(mappedBy = "visiteur")
	private List<Idee> idees;
	
	@Column(name ="UTI_ROLE",nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role = Role.visiteur;

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
