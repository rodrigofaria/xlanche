package br.com.rodrigoluisfaria.xlanche.vo;

public class Promotion {

	private String name;
	private String rule;

	public Promotion(String name, String rule) {
		this.name = name;
		this.rule = rule;
	}
	
	public String getName() {
		return name;
	}

	public String getRule() {
		return rule;
	}
	
}
