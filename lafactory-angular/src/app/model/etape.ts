import { Modele } from './modele';

export class Etape {
    constructor(
        public id?: number,
        public ordre?: number,
        public titre?: string,
        public texte?: string,
        public image?: string,
        public modele?: Modele
    ) {}
}