import { Ingredient } from './ingredient';

export class Lunch {

    name: string;
    ingredients: Ingredient[];
    price: number;
    selected: boolean;

    constructor(name?: string, ingredients?: Ingredient[], price?: number) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.selected = false;
    }

}