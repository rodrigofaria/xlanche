package br.com.rodrigoluisfaria.xlanche.promotion;

import java.util.Optional;

import br.com.rodrigoluisfaria.xlanche.util.IngredientUtil;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public class HamburgerPromotion extends PromotionDecorator {
	
	public HamburgerPromotion() {
		super();
	}
	
	public HamburgerPromotion(PromotionDecorator promotion) {
		super(promotion);
	}
	
	@Override
	public Lunch calcDiscount(Lunch lunch) {
		Optional<Ingredient> ingredient = lunch.getIngredients().stream()
				.filter(i -> i.getName().equals(IngredientUtil.HAMBURGER))
				.findFirst();
		
		int quantityHamburger = ingredient.isPresent() ? ingredient.get().getCounter() : 0;
		
		int discountHamburger = quantityHamburger / 3;
		float newPrice = lunch.getPrice() - (IngredientUtil.getHamburger().getValue() * discountHamburger);
		lunch.setPrice(newPrice);
		
		return calcAnotherDiscount(lunch);
	}

}
