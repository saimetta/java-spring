package main.creational.abstractfactory;

public class NoSuchPizzaException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchPizzaException(String type) {
		super(type);
	}
}
