package main.creational.abstractfactory;

public class CheesePizza extends Pizza {

	public CheesePizza(BaseToppingFactory baseToppingFactory) {
		super();
		addCheese(baseToppingFactory.prepareCheese());
		addSauce(baseToppingFactory.prepareSauce());
		addIngredients("Oregano");
	}
}
