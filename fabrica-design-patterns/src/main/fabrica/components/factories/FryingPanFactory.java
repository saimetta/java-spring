package main.fabrica.components.factories;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.FryingPan;
import main.fabrica.components.Product;

public class FryingPanFactory implements ProductFactory {

	@Override
	public Product create(List<Component> components) {
		
		Product fryingPan = new FryingPan();
		for (Component component : components) {
			fryingPan.addComponent(component);
		}
		return fryingPan;	
	}

}