package br.com.rodrigoluisfaria.xlanche.promotion;

import br.com.rodrigoluisfaria.xlanche.vo.Lunch;

public interface Promotion {

	Lunch calcDiscount(Lunch lunch);
	
}
