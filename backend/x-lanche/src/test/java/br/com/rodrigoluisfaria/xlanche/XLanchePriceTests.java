package br.com.rodrigoluisfaria.xlanche;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rodrigoluisfaria.xlanche.service.XLunchService;
import br.com.rodrigoluisfaria.xlanche.util.IngredientUtil;
import br.com.rodrigoluisfaria.xlanche.util.LunchUtil;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

@SpringBootTest
public class XLanchePriceTests {

	@Autowired
	private XLunchService service;
	
	@Test
	public void calcPrice_whenLunchIsXBacon_shouldReturnPrice() {
		Lunch xBacon = LunchUtil.getXBacon();
		
		double price = xBacon.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(xBacon);
		
		assertEquals((float) price, xBacon.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsXBurger_shouldReturnPrice() {
		Lunch xBurger = LunchUtil.getXBurger();
		
		double price = xBurger.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(xBurger);
		
		assertEquals((float) price, xBurger.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsXEgg_shouldReturnPrice() {
		Lunch xEgg = LunchUtil.getXEgg();
		
		double price = xEgg.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(xEgg);
		
		assertEquals((float) price, xEgg.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsXEggBacon_shouldReturnPrice() {
		Lunch xEggBacon = LunchUtil.getXEggBacon();
		
		double price = xEggBacon.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(xEggBacon);
		
		assertEquals((float) price, xEggBacon.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsPersonalized_shouldReturnPriceZero() {
		Lunch personalized = LunchUtil.getPersonalized();
		
		double price = personalized.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(personalized);
		
		assertEquals((float) price, personalized.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsAbleToLightPromotion_shouldReturnPriceWithDiscount() {
		Lunch personalized = LunchUtil.getPersonalized();
		personalized.getIngredients().add(IngredientUtil.getCheese());
		personalized.getIngredients().add(IngredientUtil.getEgg());
		personalized.getIngredients().add(IngredientUtil.getHamburger());
		personalized.getIngredients().add(IngredientUtil.getLettuce());
		
		double price = personalized.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		float fPrice = (float) price;
		fPrice *= 0.9f;
		
		service.calcPrice(personalized);
		
		assertEquals((float) fPrice, personalized.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsNotAbleToLightPromotion_shouldReturnPriceWithoutDiscount() {
		Lunch personalized = LunchUtil.getPersonalized();
		personalized.getIngredients().add(IngredientUtil.getCheese());
		personalized.getIngredients().add(IngredientUtil.getEgg());
		personalized.getIngredients().add(IngredientUtil.getHamburger());
		personalized.getIngredients().add(IngredientUtil.getLettuce());
		personalized.getIngredients().add(IngredientUtil.getBacon());
		
		double price = personalized.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		service.calcPrice(personalized);
		
		assertEquals((float) price, personalized.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsAbleToHamburgerPromotion_shouldReturnPriceWithDiscount() {
		int numberOfHamburger = 7;

		Ingredient hamburger = IngredientUtil.getHamburger();
		hamburger.setCounter(numberOfHamburger);
		
		Lunch personalized = LunchUtil.getPersonalized();
		personalized.getIngredients().add(IngredientUtil.getCheese());
		personalized.getIngredients().add(IngredientUtil.getEgg());
		personalized.getIngredients().add(hamburger);
		
		double price = personalized.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		float fPrice = (float) price;
		int discountItems = (numberOfHamburger / 3);
		fPrice -= hamburger.getValue() * discountItems;
		
		service.calcPrice(personalized);
		
		assertEquals((float) fPrice, personalized.getPrice());
	}
	
	@Test
	public void calcPrice_whenLunchIsAbleToCheesePromotion_shouldReturnPriceWithDiscount() {
		int numberOfCheese = 9;

		Ingredient cheese = IngredientUtil.getCheese();
		cheese.setCounter(numberOfCheese);
		
		Lunch personalized = LunchUtil.getPersonalized();
		personalized.getIngredients().add(IngredientUtil.getHamburger());
		personalized.getIngredients().add(IngredientUtil.getEgg());
		personalized.getIngredients().add(cheese);
		
		double price = personalized.getIngredients()
				.stream()
				.mapToDouble(ingredient -> ingredient.getCounter() * ingredient.getValue())
				.sum();
		
		float fPrice = (float) price;
		int discountItems = (numberOfCheese / 3);
		fPrice -= cheese.getValue() * discountItems;
		
		service.calcPrice(personalized);
		
		assertEquals((float) fPrice, personalized.getPrice());
	}

}
