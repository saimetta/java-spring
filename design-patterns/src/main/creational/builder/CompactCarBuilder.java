package main.creational.builder;

public class CompactCarBuilder implements CarBuilder {

	
	private Car car;
	public CompactCarBuilder() {
		car = new CarImpl();
	}
	
	
	
	@Override
	public void buildEngine() {
		car.setEngine("1.0 engine");

	}

	@Override
	public void buildChassis() {
		car.setChassis("two doors chassis");
	}

	@Override
	public void buildWheels() {
		car.setWheels("regular wheels");

	}

	@Override
	public void buildInterior() {
		car.setInterior("2 seats, black");

	}

	@Override
	public void paint(String color) {
		car.setColor(color);

	}

	@Override
	public Car getCar() {
		return car;
	}
}
