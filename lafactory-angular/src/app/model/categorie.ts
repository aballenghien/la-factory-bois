import { Modele } from './modele';

export class Categorie {
    constructor(
        public id?: number,
        public nom?: string,
        public catMere?: Categorie,
        public catFilles?: Array<Categorie>,
        public modeles?: Array<Modele>
    ) {}
}