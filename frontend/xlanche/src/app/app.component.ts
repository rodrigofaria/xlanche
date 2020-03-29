import { Component } from '@angular/core';
import { XlancheService } from './xlanche.service';
import { Lunch } from './lunch';
import { Ingredient } from './ingredient';
import { Promotion } from './promotion';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  lunchs: Lunch[];
  ingredients: Ingredient[];
  promotions: Promotion[];

  selectedLunch: Lunch;

  constructor(private service: XlancheService) {
    this.lunchs = [];
    this.ingredients = [];
    this.promotions = [];
  }

  ngOnInit() {
    this.service.getIngredients().subscribe(
      data => {
        this.ingredients = data;
        this.ingredients.forEach(ing => ing.counter = 0);
      }
    );

    this.service.getLunchs().subscribe(
      data => this.lunchs = data
    );

    this.service.getPromotions().subscribe(
      data => this.promotions = data
    );
  }

  selectLunch(lunch: Lunch) {
    this.unselectedAllLanches();
    this.selectedLunch = new Lunch(lunch.name, lunch.ingredients);
    lunch.selected = true;
  }

  unselectedAllLanches() {
    this.lunchs.forEach(f => f.selected = false);
  }

  addIngredient(ing: Ingredient) {
    ing.counter++;
  }

  removeIngredient(ing: Ingredient) {
    if (ing.counter > 0)
      ing.counter--
  }

  listIngredientsAdded() : Ingredient[] {
    return this.ingredients.filter(i => i.counter > 0);
  }

  calcPrice() {

    let addedIngredients = this.listIngredientsAdded();

    this.selectedLunch.ingredients.forEach(e => {
      e.counter = 1;
      let matchIngredient = addedIngredients.filter(i => i.name === e.name);
      if (matchIngredient.length > 0) {
        e.counter = matchIngredient[0].counter + 1;
        let index = addedIngredients.indexOf(matchIngredient[0]);
        addedIngredients.splice(index, 1);
      }
    });

    let newLunch = new Lunch();
    newLunch.ingredients = this.selectedLunch.ingredients.concat(addedIngredients);

    this.service.calcPrice(newLunch).subscribe(
      data => this.selectedLunch.price = data.price
    );
  }
}
