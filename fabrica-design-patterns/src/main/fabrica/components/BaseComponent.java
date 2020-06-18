package main.fabrica.components;

public abstract class BaseComponent implements Component {
	
	protected Integer price;
	//TODO: refactor to component type
	protected String name;
	
	public Integer getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}
