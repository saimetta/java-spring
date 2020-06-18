package main.fabrica.components.formulas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;

public abstract class AbstractFormula implements Formula {
	
	public abstract Map<String,Integer> getRequiredComponentsMap();

	
	@Override
	public Boolean hasRequiredComponents(List<Component> components) {
		Map<String, Integer> availableComponents = new HashMap<>();
		for (Component component : components) {
			Integer amount = 1;
			if (availableComponents.containsKey(component.getName())) {
				amount += availableComponents.get(component.getName());
			}
			availableComponents.put(component.getName(), amount);
		}
		Map<String,Integer> requiredComponents = getRequiredComponentsMap();
		for (String componentName : requiredComponents.keySet()) {
			if (!availableComponents.containsKey(componentName) || availableComponents.get(componentName) < requiredComponents.get(componentName)) return false;
		}
		return true;
	}
	
	@Override
	public Integer getRequiredAmount(Component component) {
		String key = component.getName();
		if (getRequiredComponentsMap().containsKey(key)) {
			return getRequiredComponentsMap().get(key);
		}
		return 0;
	}
	
}
