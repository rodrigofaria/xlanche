package br.com.rodrigoluisfaria.xlanche.util;

import br.com.rodrigoluisfaria.xlanche.vo.Promotion;

public class PromotionUtil {

	private PromotionUtil() { }

	public static Promotion promotionOne() {
		return new Promotion("Light", 
				"Se o lanche tem alface e não tem bacon, ganha 10% de desconto.");
	}
	
	public static Promotion promotionTwo() {
		return new Promotion("Muita carne", 
				"A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante!");
	}
	
	public static Promotion promotionThree() {
		return new Promotion("Muito queijo", 
				"A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante!");
	}
	
}
