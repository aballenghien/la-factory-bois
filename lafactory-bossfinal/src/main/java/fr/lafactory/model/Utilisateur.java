package fr.lafactory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue("utilisateur")
public class Utilisateur extends Visiteur {
	
	@Column (name = "VIS_USERNAME", nullable = false, length = 100)
	@NotEmpty(message = "Veuillez entrer votre username")
	private String username;
	
	@Column(name = "VIS_PASSWORD", length = 500)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
