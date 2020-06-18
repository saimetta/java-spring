package main.fabrica.components.factories;

import main.fabrica.components.Component;
import main.fabrica.components.Plastic;

public class PlasticFactory extends BaseComponentAbstractFactory {

	@Override
	public Component create() {
		return new Plastic();
	}

}
