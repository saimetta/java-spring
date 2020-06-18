package main.fabrica.components.factories;

import java.util.List;

import main.fabrica.components.Component;

public interface BaseComponentFactory {

	Component create();
	List<Component> create(Integer amount);
}
