package main.creational.factory;

public class CarFactory extends TransportFactory {

	@Override
	public Transport create() {
		return new Car();
	}

}
