package main.fabrica.components.formulas;

import java.util.HashMap;
import java.util.Map;

public class FryingPanFormula extends AbstractFormula {

	private static FryingPanFormula instance;
	private final Map<String, Integer> requiredComponents;
	
	private FryingPanFormula() {
		requiredComponents = new HashMap<>();
		requiredComponents.put("Pan body", 1);
		requiredComponents.put("Handle", 1);
	}
	
	public static FryingPanFormula getInstance() {
		if (instance == null) {
			instance = new FryingPanFormula();
		}
		return instance;
	}

	@Override
	public Map<String, Integer> getRequiredComponentsMap() {
		return requiredComponents;
	}

}
