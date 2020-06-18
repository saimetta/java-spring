package main.fabrica.strategies;

import java.util.Comparator;
import java.util.List;

import main.fabrica.machines.ProductProducer;

public class ProductionStrategy extends AbstractDistributionStrategy {

	
	private static ProductionStrategy instance;
	
	private ProductionStrategy() {}
	
	public static ProductionStrategy getInstance() {
		if (instance == null) {
			instance = new ProductionStrategy();
		}
		return instance;
	}

	@Override
	protected List<ProductProducer> sortProducers(List<ProductProducer> producers) {
		producers.sort(Comparator.comparing(ProductProducer::countComponentsNeededToProduce).reversed());
		return producers;
	}
	

}
