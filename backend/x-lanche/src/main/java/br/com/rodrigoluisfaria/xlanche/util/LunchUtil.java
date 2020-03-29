package br.com.rodrigoluisfaria.xlanche.util;

import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public class LunchUtil {

	private static final String X_BACON = "X-Bacon";
	private static final String X_BURGER = "X-Burger";
	private static final String X_EGG = "X-Egg";
	private static final String X_EGG_BACON = "X-Egg Bacon";
	private static final String X_PERSONALIZED = "Personalizado";
	
	private LunchUtil() { }
	
	public static Lunch getXBacon() {
		Lunch lunch = new Lunch();
		lunch.setName(LunchUtil.X_BACON);
		lunch.getIngredients().add(IngredientUtil.getBacon());
		lunch.getIngredients().add(IngredientUtil.getHamburger());
		lunch.getIngredients().add(IngredientUtil.getCheese());
		return lunch;
	}
	
	public static Lunch getXBurger() {
		Lunch lunch = new Lunch();
		lunch.setName(LunchUtil.X_BURGER);
		lunch.getIngredients().add(IngredientUtil.getHamburger());
		lunch.getIngredients().add(IngredientUtil.getCheese());
		return lunch;
	}
	
	public static Lunch getXEgg() {
		Lunch lunch = new Lunch();
		lunch.setName(LunchUtil.X_EGG);
		lunch.getIngredients().add(IngredientUtil.getEgg());
		lunch.getIngredients().add(IngredientUtil.getHamburger());
		lunch.getIngredients().add(IngredientUtil.getCheese());
		return lunch;
	}
	
	public static Lunch getXEggBacon() {
		Lunch lunch = new Lunch();
		lunch.setName(LunchUtil.X_EGG_BACON);
		lunch.getIngredients().add(IngredientUtil.getEgg());
		lunch.getIngredients().add(IngredientUtil.getBacon());
		lunch.getIngredients().add(IngredientUtil.getHamburger());
		lunch.getIngredients().add(IngredientUtil.getCheese());
		return lunch;
	}
	
	public static Lunch getPersonalized() {
		Lunch lunch = new Lunch();
		lunch.setName(LunchUtil.X_PERSONALIZED);
		return lunch;
	}
}
