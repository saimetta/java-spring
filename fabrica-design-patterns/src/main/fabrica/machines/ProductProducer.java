package main.fabrica.machines;

import java.util.Date;
import java.util.Map;

import main.fabrica.components.Component;
import main.fabrica.components.Product;

public interface ProductProducer {
	
	public Date BASE_DATE = new Date(Long.MIN_VALUE);
	void add(Component component);
	boolean isReady();
	Product produce();
	Map<String,Integer> getComponentsNeededToProduce();
	Date getLastProductionDate();
	int getProductionCount();
	boolean isComponentRequired(Component component);
	int countComponentsNeededToProduce();
}
