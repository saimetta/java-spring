package main.creational.builder;

public class SportCarBuilder implements CarBuilder {

	private Car car;
	public SportCarBuilder() {
		car = new CarImpl();
	}
	
	@Override
	public void buildEngine() {
		car.setEngine("V8");

	}

	@Override
	public void buildChassis() {
		car.setChassis("racing chassis");
	}

	@Override
	public void buildWheels() {
		car.setWheels("racing wheels");

	}

	@Override
	public void buildInterior() {
		car.setInterior("competition interior one seat");

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
