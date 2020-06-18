package main.fabrica.machines;

import main.fabrica.components.Component;
import main.fabrica.components.Product;

public class ProducerCompletedState implements ProducerState {

	private ProductProducerContext productProducer;
	
	public ProducerCompletedState(ProductProducerContext productProducer) {
		this.productProducer = productProducer;
	}
	@Override
	public void add(Component component) {
		throw new ProducerCompleteException("The producer has the needed components to produce");
	}

	@Override
	public Product produce() {
		Product product = productProducer.getProductFromFactory(productProducer.getStockToProduce());
		productProducer.setState(productProducer.getNotReadyState());
		return product;
	}
}
