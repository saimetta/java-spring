package main.fabrica.components.factories;

import main.fabrica.components.Component;
import main.fabrica.components.Iron;

public class IronFactory extends BaseComponentAbstractFactory {

	@Override
	public Component create() {
		return new Iron();
	}
}
