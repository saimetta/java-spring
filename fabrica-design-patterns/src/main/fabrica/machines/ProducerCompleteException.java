package main.fabrica.machines;

public class ProducerCompleteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProducerCompleteException(String message) {
		super(message);
	}
}