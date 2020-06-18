package main.fabrica.components.formulas;

import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;

public interface Formula {

	Boolean hasRequiredComponents(List<Component> components);
	Map<String, Integer> getRequiredComponentsMap();
	Integer getRequiredAmount(Component component);
}
