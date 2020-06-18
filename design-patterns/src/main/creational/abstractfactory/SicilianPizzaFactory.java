package main.creational.abstractfactory;

public class SicilianPizzaFactory extends BasePizzaFactory {

	private BaseToppingFactory factory;
	
	public SicilianPizzaFactory() {
		factory = new SicilianToppingFactory();
	}
	
	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		switch (type) {
		case "Cheese":
			pizza = new CheesePizza(factory);
			break;
		case "Vegan":
			pizza = new VeganPizza(factory);
			break;
		case "Pepperoni":
			pizza = new PepperoniPizza(factory);
			break;
		default: throw new NoSuchPizzaException(type);
		}
		
		return pizza;
	}

}
