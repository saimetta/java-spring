package main.creational.abstractfactory;

public class MozzarellaCheese implements Cheese {

	public MozzarellaCheese() {
	}
	
	@Override
	public String prepareCheese() {
		return "Mozzarella";
	}

}
