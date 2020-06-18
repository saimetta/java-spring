package main.behavioral.chainofresponsability;

public abstract class AbstractSupportHandler {
	
	public static final int TECHNICAL = 1;
	public static final int BILLING = 2;
	public static final int GENERAL = 3;
	
	protected AbstractSupportHandler nextHandler;
	protected Integer level;

	public void setNextHandler(AbstractSupportHandler handler) {
		nextHandler = handler;
	}
	
	public String receiveRequest(int level, String message) {
		if (this.level != level && nextHandler != null) {
			return nextHandler.receiveRequest(level, message);
		}else {
			return handleRequest(message);
		}
	}
	
	protected abstract String handleRequest(String message);
	
}
