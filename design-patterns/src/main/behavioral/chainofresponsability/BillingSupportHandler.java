package main.behavioral.chainofresponsability;

public class BillingSupportHandler extends AbstractSupportHandler {
    
	public BillingSupportHandler(int level){
        this.level = level;
    }
    @Override
    protected String handleRequest (String message){
        return "BillingSupportHandler: Processing request " + message;
    }
}