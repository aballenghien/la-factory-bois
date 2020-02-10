import { Idee } from './idee';
import { Role } from './role';

export class Visiteur {
    constructor(
        public id?: number,
        public nom?: string,
        public prenom?: string,
        public mail?: string,
        public idees?: Array<Idee>,
        public role?: Role,
    ) {}
}