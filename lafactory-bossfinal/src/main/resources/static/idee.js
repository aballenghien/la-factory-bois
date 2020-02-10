

function afficherIdeeArchive() {
	// Creation des elements du tableau

	console.log("on entre");
	fetch('http://172.16.44.102:8080/api/idee/listeIdee')
		.then(resp => resp.json())
		.then(idees => {
			idees.forEach( i => {
				let row = document.createElement('tr');
				let colDescription = document.createElement('td');
				let colVisiteur = document.createElement('td');
				let colMailVisiteur = document.createElement('td');
				row.append(colDescription);
				row.append(colVisiteur);
				row.append(colMailVisiteur);
				document.querySelector('tbody').prepend(row);
				colDescription.innerHTML = i.description;
				colVisiteur.innerHTML = i.visiteur.nom + i.visiteur.prenom;
				colVisiteur.innerHTML = i.visiteur.mail;
			})
		})
		.catch(err => {
			console.log(err)
		});
}


document.querySelector('#bouton')
		.addEventListener('click', (event) => {
			console.log("ici");
			afficherIdeeArchive();
			console.log("la");
		})
//
//const findListIdeeWithArchive = async (event) => {
//	event.preventDefault();
//	let booleen = {
//			booleen: true
//		};
//	
//	let ideesRecu = await fetch('http://172.16.44.102:8080/lafactory-bossfinal/api/idee/listeIdee', {
//		method: 'GET',
//		headers: {
//			'Content-Type': 'application/json'
//		},
//		body: JSON.stringify(booleen)
//	}).then(resp => resp.json());
//	
//	afficherIdee(ideesRecu);
//}
