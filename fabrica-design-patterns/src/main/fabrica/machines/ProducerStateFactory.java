package main.fabrica.machines;

public class ProducerStateFactory {

	public static ProducerState createCompleteState(ProductProducerContext context) {
		return new ProducerCompletedState(context);
	}
	
	public static ProducerState createNotReadyState(ProductProducerContext context) {
		return new ProducerNotReadyState(context);
	}
}
