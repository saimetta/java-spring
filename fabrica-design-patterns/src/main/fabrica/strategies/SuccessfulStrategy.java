package main.fabrica.strategies;

import java.util.Comparator;
import java.util.List;

import main.fabrica.machines.ProductProducer;

public class SuccessfulStrategy extends AbstractDistributionStrategy {

private static SuccessfulStrategy instance;
	
	private SuccessfulStrategy() {}
	
	public static SuccessfulStrategy getInstance() {
		if (instance == null) {
			instance = new SuccessfulStrategy();
		}
		return instance;
	}
	
	@Override
	protected List<ProductProducer> sortProducers(List<ProductProducer> producers) {
		producers.sort(Comparator.comparing(ProductProducer::getProductionCount).reversed());
		return producers;
	}
}
