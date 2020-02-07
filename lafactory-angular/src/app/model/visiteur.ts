import { Idee } from './idee';

export class Visiteur {
    constructor(
        public id?: number,
        public nom?: string,
        public prenom?: string,
        public mail?: string,
        public idees?: Array<Idee>,
        public role?: string,
    ) {}
}