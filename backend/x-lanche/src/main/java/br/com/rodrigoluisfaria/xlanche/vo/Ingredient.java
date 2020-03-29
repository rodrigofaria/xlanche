package br.com.rodrigoluisfaria.xlanche.vo;

public class Ingredient {

	private String name;
	private float value;
	private int counter;
	
	public Ingredient(String name, float value, int counter) {
		this.name = name;
		this.value = value;
		this.counter = counter;
	}

	public String getName() {
		return name;
	}

	public float getValue() {
		return value;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.value + " - " + this.counter;
	}
}
