package main.fabrica.machines;

public class InsufficientComponentsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientComponentsException(String message) {
		super(message);
	}
}
