package main.fabrica.machines;

import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;
import main.fabrica.components.Product;

public interface ProductProducerContext extends ProductProducer {
		
	Map<String,Integer> getComponentsNeededToProduce();
	ProducerState getCompletedState();
	void setState(ProducerState state);
	String getProductName();
	Product getProductFromFactory(List<Component> components);
	List<Component> getStockToProduce();
	ProducerState getNotReadyState();
	void addToStock(Component component);
	void addToStock(List<Component> component);
}
