import { Etape } from './etape';
import { Categorie } from './categorie';

export class Modele {
    constructor(
        public id?: number,
        public nom?: string,
        public tempsrealisation?: number,
        public niveau?: string,
        public qteBoisNecessaire?: number,
        public noteMoy?: number,
        public visible?: boolean,
        public lienVideo?: string,
        public etapes?: Array<Etape>,
        public categories?: Array<Categorie>
    ) {}
}