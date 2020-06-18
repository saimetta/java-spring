package main.fabrica.components;

import java.util.ArrayList;
import java.util.List;

public abstract class Product extends BaseComponent implements Composite {

	protected List<Component> components;
	
	public Product() {
		components = new ArrayList<Component>();
	}
	
	@Override
	public void addComponent(Component component) {
		components.add(component);
	}
	
	@Override
	public Integer getPrice() {
		Integer price = 0;
		for (Component component : components) {
			price += component.getPrice();
		}
		return price;
	}
}
