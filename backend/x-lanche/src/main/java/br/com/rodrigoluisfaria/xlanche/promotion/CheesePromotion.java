package br.com.rodrigoluisfaria.xlanche.promotion;

import java.util.Optional;

import br.com.rodrigoluisfaria.xlanche.util.IngredientUtil;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public class CheesePromotion extends PromotionDecorator {
	
	public CheesePromotion() {
		super();
	}
	
	public CheesePromotion(PromotionDecorator promotion) {
		super(promotion);
	}
	
	@Override
	public Lunch calcDiscount(Lunch lunch) {
		Optional<Ingredient> ingredient = lunch.getIngredients().stream()
				.filter(i -> i.getName().equals(IngredientUtil.CHEESE))
				.findFirst();
		
		int quantityCheese = ingredient.isPresent() ? ingredient.get().getCounter() : 0;
		
		int discountCheese = quantityCheese / 3;
		float newPrice = lunch.getPrice() - (IngredientUtil.getCheese().getValue() * discountCheese);
		lunch.setPrice(newPrice);
		
		return calcAnotherDiscount(lunch);
	}

}
