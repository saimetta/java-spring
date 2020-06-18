package main.caseofstudy.modelprinter.userinteraction;


public class PrintTextAction implements UserActionCommand {

	private String text;
	
	
	public PrintTextAction(String text) {
		super();
		this.text = text;
	}

	@Override
	public String execute() {
		return text;

	}

	@Override
	public String undo() {
		return "Undo printing: "+text;

	}

}
