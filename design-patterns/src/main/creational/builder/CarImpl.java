package main.creational.builder;

public class CarImpl implements Car {

	private String engine;
	private String color;
	private String interior;
	private String chassis;
	private String wheels;
	
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getWheels() {
		return wheels;
	}
	public void setWheels(String wheels) {
		this.wheels = wheels;
	}
	
	@Override
	public String toString() {
		return "Engine: "+getEngine()+" chassis: "+getChassis()+" color: "+getColor();
	}
	
	
}
