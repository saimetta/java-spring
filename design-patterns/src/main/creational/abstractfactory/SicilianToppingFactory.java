package main.creational.abstractfactory;

public class SicilianToppingFactory extends BaseToppingFactory {

	@Override
	public Cheese prepareCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Sauce prepareSauce() {
		return new TomatoSauce();
	}

}
