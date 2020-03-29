package br.com.rodrigoluisfaria.xlanche.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoluisfaria.xlanche.service.XLunchService;
import br.com.rodrigoluisfaria.xlanche.vo.Ingredient;
import br.com.rodrigoluisfaria.xlanche.vo.Lunch;
import br.com.rodrigoluisfaria.xlanche.vo.Promotion;

@RestController
@RequestMapping("/xlanche")
public class XLancheAPI {

	@Autowired
	private XLunchService lancheService;
	
	@GetMapping(path = "/ingredients", produces = "application/json")
	public List<Ingredient> listIngredients() {
		return lancheService.listIngredients();
	}
	
	@GetMapping(path = "/lunchs", produces = "application/json")
	public List<Lunch> listLunchs() {
		return lancheService.listLunch();
	}
	
	@GetMapping(path = "/promotions", produces = "application/json")
	public List<Promotion> listPromotions() {
		return lancheService.listPromotions();
	}
	
	@PostMapping(path = "/price", consumes = "application/json", produces = "application/json")
	public Lunch calcPrice(@RequestBody Lunch lunch) {
		return lancheService.calcPrice(lunch);
	}
	
}
