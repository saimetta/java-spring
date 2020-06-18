package main.fabrica;

import java.util.ArrayList;
import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.Product;
import main.fabrica.machines.ProductProducer;
import main.fabrica.stock.Warehouse;
import main.fabrica.strategies.DistributionStrategy;
import main.fabrica.strategies.NotRequiredComponentException;

public class Fabrica implements Mediator {
	
	private final Warehouse warehouse;
	private List<ProductProducer> producers;
	private DistributionStrategy distributionStrategy;
	
	public Fabrica(Warehouse warehouse, DistributionStrategy distributionStrategy) {
		this.warehouse = warehouse;
		producers = new ArrayList<ProductProducer>();
		this.distributionStrategy = distributionStrategy;
	}
	@Override
	public void addProducer(ProductProducer producer) {
		producers.add(producer);
	}
	@Override
	public void addComponent(Component component) {
		warehouse.add(component);
	}
	@Override
	public void addComponents(List<Component> components) {
		warehouse.add(components);
	}

	public void store(Product product) {
		warehouse.add(product);
	}
	@Override
	public void setProductionStrategy(DistributionStrategy strategy) {
		distributionStrategy = strategy;
	}
	/**
	 * Will iterate over producers and produce if they are ready
	 */
	@Override
	public void produce() {
		for (ProductProducer producer: producers) {
			if (producer.isReady()) {
				Product product = producer.produce();
				//we can use the observer here
				warehouse.add(product);
			}
		}
	}
	@Override
	public void distribute(Component component) {
		try {
			distributionStrategy.distribute(component, producers);
		} catch (NotRequiredComponentException e) {
			//TODO: verify how to handle this once obversers is fully implmented, to avoid loops
			warehouse.add(component);
		}
		
	}

}
