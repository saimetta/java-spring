package main.fabrica;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.Product;
import main.fabrica.machines.ProductProducer;
import main.fabrica.strategies.DistributionStrategy;

public interface Mediator {
	
	void addProducer(ProductProducer producer);
	void addComponent(Component component);
	void addComponents(List<Component> components);
	void store(Product product); 
	void setProductionStrategy(DistributionStrategy strategy);
    void produce();
    void distribute(Component component);
}
