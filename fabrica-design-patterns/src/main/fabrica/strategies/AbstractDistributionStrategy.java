package main.fabrica.strategies;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.machines.ProductProducer;

public abstract class AbstractDistributionStrategy implements DistributionStrategy{

	
	protected abstract List<ProductProducer> sortProducers(List<ProductProducer> producers);
	
	@Override
	public ProductProducer distribute(Component component, List<ProductProducer> producers)
			throws NotRequiredComponentException {
		
		producers = sortProducers(producers);
		for (ProductProducer productProducer : producers) {
			try {
				productProducer.add(component);
				return productProducer;
			}catch(NotRequiredComponentException notRequiredComponentException) {
				//Nothing to do
			}
			
		}
		throw new NotRequiredComponentException(String.format("The component %s is not required", component.getName()));
	}

}
