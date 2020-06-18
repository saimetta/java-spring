package main.fabrica.strategies;

public class NotRequiredComponentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotRequiredComponentException() {
		super("The component is not required");
	}

	
	public NotRequiredComponentException(String message) {
		super(message);
	}

}
