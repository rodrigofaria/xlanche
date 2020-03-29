package br.com.rodrigoluisfaria.xlanche.vo;

import java.util.ArrayList;
import java.util.List;

public class Lunch {

	private String name;
	private List<Ingredient> ingredients;
	private float price;

	public Lunch() {
		ingredients = new ArrayList<>();
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
