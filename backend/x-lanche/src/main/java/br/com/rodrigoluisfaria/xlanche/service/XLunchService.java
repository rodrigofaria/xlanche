package br.com.rodrigoluisfaria.xlanche.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rodrigoluisfaria.xlanche.promotion.CheesePromotion;
import br.com.rodrigoluisfaria.xlanche.promotion.HamburgerPromotion;
import br.com.rodrigoluisfaria.xlanche.promotion.LightPromotion;
import br.com.rodrigoluisfaria.xlanche.promotion.PromotionDecorator;
import br.com.rodrigoluisfaria.xlanche.util.IngredientUtil;
import br.com.rodrigoluisfaria.xlanche.util.LunchUtil;
import br.com.rodrigoluisfaria.xlanche.util.PromotionUtil;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;
import br.com.rodrigoluisfaria.xlanche.vo.Promotion;

@Service
public class XLunchService {

	public List<Ingredient> listIngredients() {
		return List.of(
				IngredientUtil.getLettuce(),
				IngredientUtil.getBacon(),
				IngredientUtil.getHamburger(),
				IngredientUtil.getEgg(),
				IngredientUtil.getCheese()
			);
	}
	
	public List<Lunch> listLunch() {
		return List.of(
				LunchUtil.getXBacon(),
				LunchUtil.getXBurger(),
				LunchUtil.getXEgg(),
				LunchUtil.getXEggBacon(),
				LunchUtil.getPersonalized()
			);
	}
	
	public List<Promotion> listPromotions() {
		return List.of(
				PromotionUtil.promotionOne(),
				PromotionUtil.promotionTwo(),
				PromotionUtil.promotionThree()
			);
	}
	
	public Lunch calcPrice(Lunch lunch) {
		double sum = lunch.getIngredients().stream().mapToDouble(i -> i.getValue() * i.getCounter()).sum();
		
		lunch.setPrice((float) sum);

		PromotionDecorator promotions = 
				new HamburgerPromotion(new CheesePromotion(new LightPromotion()));
		
		return promotions.calcDiscount(lunch);
	}

}
