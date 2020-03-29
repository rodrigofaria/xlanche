package br.com.rodrigoluisfaria.xlanche.promotion;

import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public abstract class PromotionDecorator implements Promotion {

	protected PromotionDecorator promotion;

	public PromotionDecorator() {
		promotion = null;
	}
	
	public PromotionDecorator(PromotionDecorator promotion) {
		this.promotion = promotion;
	}
	
	@Override
	public abstract Lunch calcDiscount(Lunch lunch);
	
	protected Lunch calcAnotherDiscount(Lunch lunch) {
		if (promotion == null) {
			return lunch;
		}
		return promotion.calcDiscount(lunch);
	}

}
