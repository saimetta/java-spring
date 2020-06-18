package main.creational.abstractfactory;

public class PepperoniPizza extends Pizza {

	public PepperoniPizza(BaseToppingFactory baseToppingFactory) {
		super();
		addCheese(baseToppingFactory.prepareCheese());
		addSauce(baseToppingFactory.prepareSauce());
		addIngredients("Salami slices");
	}
}
