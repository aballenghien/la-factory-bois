function ajouterCategorie() {
	let elementListCategories=document.getElementById("categorie");
	let idCategorie=elementListCategories.options[elementListCategories.selectedIndex].value;
	let nomCategorie=elementListCategories.options[elementListCategories.selectedIndex].text;
	let textArea=document.getElementById("listeDesCategories");
	if(idCategorie != 0){
		textArea.value = textArea.value+idCategorie+":"+nomCategorie+"\n";
	}
}