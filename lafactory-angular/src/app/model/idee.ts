import { Visiteur } from './visiteur';

export class Idee {
    constructor(
        public id?: number,
        public description?: string,
        public archive?: boolean,
        public visiteur?: Visiteur
    ) {}
}