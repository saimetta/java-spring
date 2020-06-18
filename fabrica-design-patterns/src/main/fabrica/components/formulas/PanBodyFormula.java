package main.fabrica.components.formulas;

import java.util.HashMap;
import java.util.Map;

public class PanBodyFormula extends AbstractFormula{
	
	private static PanBodyFormula instance;
	private final Map<String, Integer> requiredComponents;
	
	private PanBodyFormula() {
		requiredComponents = new HashMap<>();
		requiredComponents.put("Iron", 3);
	}
	
	public static PanBodyFormula getInstance() {
		if (instance == null) {
			instance = new PanBodyFormula();
		}
		return instance;
	}

	@Override
	public Map<String, Integer> getRequiredComponentsMap() {
		return requiredComponents;
	}
}
