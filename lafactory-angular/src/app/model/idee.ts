import { Utilisateur } from './utilisateur';

export class Idee {
    constructor(
        public id?: number,
        public description?: string,
        public archive?: boolean,
        public utilisateur?: Utilisateur
    ) {}
}