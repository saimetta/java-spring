package main.creational.builder;

public class CarBuilderDirector {
	
	private CarBuilder builder;
	
	public CarBuilderDirector(CarBuilder builder) {
		this.builder = builder;
	}

	public void construct(String color) {
		builder.buildChassis();
		builder.buildEngine();
		builder.buildInterior();
		builder.buildWheels();
		builder.paint(color);
	}
	
	public Car getResult() {
		return builder.getCar();
	}
	
	
	
	
}
