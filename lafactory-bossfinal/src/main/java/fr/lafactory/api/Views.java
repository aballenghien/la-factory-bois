package fr.lafactory.api;

import com.fasterxml.jackson.annotation.JsonView;

@JsonView
public class Views {

	public static class Common {}
	
	public static class Categorie extends Common {}
	
	public static class CategorieWithCatFilles extends Categorie {}
	
	public static class Modele extends Common{}
	
	public static class ModeleWithCategories extends Modele {}
}
