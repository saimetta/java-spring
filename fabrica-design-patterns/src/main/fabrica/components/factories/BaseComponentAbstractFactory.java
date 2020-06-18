package main.fabrica.components.factories;

import java.util.ArrayList;
import java.util.List;

import main.fabrica.components.Component;

public abstract class BaseComponentAbstractFactory implements BaseComponentFactory{
	
	public abstract Component create();
	
	public List<Component> create(Integer amount) {
		List<Component> components = new ArrayList<Component>(amount);
		while(amount > 0) {
			components.add(create());
			amount--;
		}
		return components;
	}
}

