package br.com.rodrigoluisfaria.xlanche.util;

import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;

public class IngredientUtil {

	private IngredientUtil() { }
	
	public static final String BACON = "Bacon";
	public static final String LETTUCE = "Alface";
	public static final String HAMBURGER = "Hambúrguer de carne";
	public static final String EGG = "Ovo";
	public static final String CHEESE = "Queijo";
	
	public static Ingredient getBacon() {
		return new Ingredient(BACON, 2.00f, 1);
	}
	public static Ingredient getLettuce() {
		return new Ingredient(LETTUCE, 0.40f, 1);
	}
	public static Ingredient getHamburger() {
		return new Ingredient(HAMBURGER, 3.00f, 1);
	}
	public static Ingredient getEgg() {
		return new Ingredient(EGG, 0.80f, 1);
	}
	public static Ingredient getCheese() {
		return new Ingredient(CHEESE, 1.50f, 1);
	}
}
