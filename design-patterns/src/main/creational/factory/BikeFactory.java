package main.creational.factory;

public class BikeFactory extends TransportFactory {

	@Override
	public Transport create() {
		return new Bike();
	}

}
