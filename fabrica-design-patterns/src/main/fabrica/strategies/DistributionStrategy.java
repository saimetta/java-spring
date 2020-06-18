package main.fabrica.strategies;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.machines.ProductProducer;

public interface DistributionStrategy {
	
	/**
	 * Will return a ready producer or throw an exception if its not possible 
	 * @param input
	 * @param producers
	 * @return
	 * 
	 */
	ProductProducer distribute(Component component, List<ProductProducer> producers) throws NotRequiredComponentException;
}
