package main.creational.abstractfactory;

public class GourmetPIzzaFactory extends BasePizzaFactory{

	private BaseToppingFactory factory;

	public GourmetPIzzaFactory() {
		factory = new GourmetToppingFactory();
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
