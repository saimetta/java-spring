package main.behavioral.chainofresponsability;

public class GeneralSupportHandler extends AbstractSupportHandler {

	public GeneralSupportHandler(int level) {
		this.level = level;
	}
	@Override
	protected String handleRequest(String message) {
		return "GeneralSupportHandler: Processing request " + message;
	}

}
