package fr.lafactory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("visiteur")
public class Visiteur extends Personne {
	
}
