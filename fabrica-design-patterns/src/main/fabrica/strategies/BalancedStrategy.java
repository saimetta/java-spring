package main.fabrica.strategies;

import java.util.Comparator;
import java.util.List;

import main.fabrica.machines.ProductProducer;

public class BalancedStrategy extends AbstractDistributionStrategy {

	
	private static BalancedStrategy instance;
	
	private BalancedStrategy() {}
	
	public static BalancedStrategy getInstance() {
		if (instance == null) {
			instance = new BalancedStrategy();
		}
		return instance;
	}
	
	@Override
	protected List<ProductProducer> sortProducers(List<ProductProducer> producers) {
		producers.sort(Comparator.comparing(ProductProducer::getLastProductionDate));
		return producers;
	}

}
