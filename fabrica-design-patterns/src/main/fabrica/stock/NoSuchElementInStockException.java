package main.fabrica.stock;

public class NoSuchElementInStockException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchElementInStockException(String elementName) {
		super(String.format("There is no element with name %s in stock",elementName));
	}
}
