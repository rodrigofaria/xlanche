export class Ingredient {

    name: string;
    value: number;
    counter: number;

    constructor(name?: string, value?: number, counter?: number) {
        this.name = name;
        this.value = value;
        this.counter = counter;
    }
}