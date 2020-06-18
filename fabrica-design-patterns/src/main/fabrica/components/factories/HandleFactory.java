package main.fabrica.components.factories;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.Handle;
import main.fabrica.components.Product;

public class HandleFactory implements ProductFactory {

	@Override
	public Product create(List<Component> components) {
		
		Product handle = new Handle();
		for (Component component : components) {
			handle.addComponent(component);
		}
		return handle;	
	}

}
