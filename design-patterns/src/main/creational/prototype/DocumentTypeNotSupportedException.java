package main.creational.prototype;

public class DocumentTypeNotSupportedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1362179089498902101L;

	public DocumentTypeNotSupportedException(String type) {
		super(String.format("The type [%s] is not supported", type));
	}
}
