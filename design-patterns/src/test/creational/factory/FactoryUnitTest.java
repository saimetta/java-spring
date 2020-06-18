package test.creational.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.creational.factory.BikeFactory;
import main.creational.factory.CarFactory;
import main.creational.factory.Transport;
import main.creational.factory.TransportFactory;

class FactoryUnitTest {

	private TransportFactory bikeFactory;
	private TransportFactory carFactory;
	
	
	@BeforeEach
	void setUp() throws Exception {
		bikeFactory = new BikeFactory();
		carFactory = new CarFactory();
	}

	@Test
	void When_CreateBike_ThenCorrect() {
		Transport bike = bikeFactory.create();
		assertEquals("Driving a bike", bike.drive());	
	}
	
	@Test
	void When_SwitchGenericFactory_ThenCorrect() {
		TransportFactory genericFactory = bikeFactory;
		Transport bike = genericFactory.create();
		genericFactory = carFactory;
		Transport car = genericFactory.create();
		assertEquals("Driving a bike", bike.drive());
		assertEquals("Driving a car", car.drive());
	}

}
