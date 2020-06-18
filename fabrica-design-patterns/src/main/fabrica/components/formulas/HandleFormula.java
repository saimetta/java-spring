package main.fabrica.components.formulas;

import java.util.HashMap;
import java.util.Map;


public class HandleFormula extends AbstractFormula {
	
	private static HandleFormula instance;
	private final Map<String, Integer> requiredComponents;
	
	private HandleFormula() {
		requiredComponents = new HashMap<>();
		requiredComponents.put("Iron", 1);
		requiredComponents.put("Plastic", 1);
	}
	
	public static HandleFormula getInstance() {
		if (instance == null) {
			instance = new HandleFormula();
		}
		return instance;
	}

	@Override
	public Map<String, Integer> getRequiredComponentsMap() {
		return requiredComponents;
	}

	

}
