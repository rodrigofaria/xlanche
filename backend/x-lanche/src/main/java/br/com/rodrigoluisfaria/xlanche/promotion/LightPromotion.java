package br.com.rodrigoluisfaria.xlanche.promotion;

import java.util.List;
import java.util.Optional;

import br.com.rodrigoluisfaria.xlanche.util.IngredientUtil;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public class LightPromotion extends PromotionDecorator {
	
	public LightPromotion() {
		super();
	}
	
	public LightPromotion(PromotionDecorator promotion) {
		super(promotion);
	}
	
	@Override
	public Lunch calcDiscount(Lunch lunch) {
		boolean isApplicable = isAbleToDiscount(lunch.getIngredients());
		if (isApplicable) {
			float price = lunch.getPrice();
			price *= 0.9;
			lunch.setPrice(price);
		}
		
		return calcAnotherDiscount(lunch);
	}

	private boolean isAbleToDiscount(List<Ingredient> ingredients) {
		Optional<Ingredient> ingredientWithLettuce = ingredients.stream()
				.filter(i -> i.getName().equals(IngredientUtil.LETTUCE))
				.findFirst();
		
		Optional<Ingredient> ingredientWithBacon = ingredients.stream()
				.filter(i -> i.getName().equals(IngredientUtil.BACON))
				.findFirst();
		
		return ingredientWithLettuce.isPresent() && ingredientWithBacon.isEmpty();
	}
}
