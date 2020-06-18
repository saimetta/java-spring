package main.creational.abstractfactory;

public class GourmetToppingFactory extends BaseToppingFactory {

	@Override
	public Cheese prepareCheese() {
		return new GoatCheese();
	}

	@Override
	public Sauce prepareSauce() {
		return new SpicySauce();
	}

}
