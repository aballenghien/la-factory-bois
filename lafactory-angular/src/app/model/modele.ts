import { Etape } from './etape';
import { Categorie } from './categorie';
import { Niveau } from './niveau';
import { Appreciation } from './appreciation';

export class Modele {
    constructor(
        public id?: number,
        public nom?: string,
        public tempsRealisation?: number,
        public niveau?: Niveau,
        public qteBoisNecessaire?: number,
        public noteMoy?: number,
        public visible?: boolean,
        public lienVideo?: string,
        public etapes?: Array<Etape>,
        public appreciations?: Array<Appreciation>,
        public categories?: Array<Categorie>,
        public urlImage?: string,
        public description?: string
    ) {}
}