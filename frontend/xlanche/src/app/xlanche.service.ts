import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ingredient } from './ingredient';
import { Lunch } from './lunch';
import { Promotion } from './promotion';

const httpOption = {
  headers : new HttpHeaders({"Content-Type" : "application/json"})
};

@Injectable({
  providedIn: 'root'
})
export class XlancheService {

  private url = 'http://localhost:8080/xlanche';

  constructor(private http: HttpClient) { }

  getIngredients() : Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.url + '/ingredients');
  }

  getLunchs() : Observable<Lunch[]> {
    return this.http.get<Lunch[]>(this.url + '/lunchs');
  }
  
  getPromotions() : Observable<Promotion[]> {
    return this.http.get<Promotion[]>(this.url + '/promotions');
  }

  calcPrice(lunch : Lunch) : Observable<Lunch> {
    return this.http.post<Lunch>(this.url + '/price', lunch, httpOption);
  }
}
