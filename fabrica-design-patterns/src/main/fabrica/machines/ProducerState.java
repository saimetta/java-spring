package main.fabrica.machines;

import main.fabrica.components.Component;
import main.fabrica.components.Product;

public interface ProducerState {

	void add(Component component);
	Product produce();
}
