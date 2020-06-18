package main.creational.abstractfactory;

public class VeganPizza extends Pizza {

	public VeganPizza(BaseToppingFactory baseToppingFactory) {
		super();
		addSauce(baseToppingFactory.prepareSauce());
		addIngredients("Brocoli and peppers");
		addIngredients("Eggplant slices");
		addIngredients("Basil");
	}
}
