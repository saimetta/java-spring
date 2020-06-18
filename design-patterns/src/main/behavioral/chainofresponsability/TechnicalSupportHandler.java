package main.behavioral.chainofresponsability;

public class TechnicalSupportHandler extends AbstractSupportHandler {
   
	public TechnicalSupportHandler(int level){
        this.level = level;
    }

	@Override
	protected String handleRequest(String message) {
        return "TechnicalSupportHandler: Processing request " + message;
	}
}