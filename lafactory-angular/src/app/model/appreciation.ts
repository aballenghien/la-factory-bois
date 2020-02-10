import { Modele } from './modele';

export class Appreciation {
    constructor(
        public id?: number,
        public note?: number,
        public dateCommentaire?: Date,
        public pseudo?: string,
        public modele?: Modele) {}
}