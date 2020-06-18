package main.fabrica.components.factories;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.PanBody;
import main.fabrica.components.Product;

public class PanBodyFactory implements ProductFactory {

	@Override
	public Product create(List<Component> components) {
		
		Product panBody = new PanBody();
		for (Component component : components) {
			panBody.addComponent(component);
		}
		return panBody;	
	}

}