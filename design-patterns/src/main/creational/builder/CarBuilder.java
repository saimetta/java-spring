package main.creational.builder;

public interface CarBuilder {

	void buildEngine();
	void buildChassis();
	void buildWheels();
	void buildInterior();
	void paint(String color);
	Car getCar();
}
