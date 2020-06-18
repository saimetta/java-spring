package main.fabrica.strategies;

import java.util.List;

import main.fabrica.machines.ProductProducer;

public class GreedyStrategy extends AbstractDistributionStrategy {

	private static GreedyStrategy instance;
	
	private GreedyStrategy() {
	}
	
	public static GreedyStrategy getInstance() {
		if (instance == null) {
			instance = new GreedyStrategy();
		}
		return instance;
	}


	@Override
	protected List<ProductProducer> sortProducers(List<ProductProducer> producers) {
		return producers;
	}

}
