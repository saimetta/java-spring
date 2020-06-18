package main.fabrica.machines;

import main.fabrica.components.Component;
import main.fabrica.components.Product;
import main.fabrica.strategies.NotRequiredComponentException;

public class ProducerNotReadyState implements ProducerState {

	private ProductProducerContext productProducer;
	
	public ProducerNotReadyState(ProductProducerContext productProducer) {
		this.productProducer = productProducer;
	}
	@Override
	public void add(Component component) {
		if (!productProducer.isComponentRequired(component)) {
			throw new NotRequiredComponentException(String.format("The component %s is not required", component.getName()));
		}
		
		productProducer.addToStock(component);
		if (productProducer.isReady()) {
			productProducer.setState(productProducer.getCompletedState());
		}

	}

	@Override
	public Product produce() {
		throw new InsufficientComponentsException("Insufficient components to produce : " + productProducer.getProductName());
	}

}
