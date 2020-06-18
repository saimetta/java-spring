package main.behavioral.command;

public class AddTextCommand extends AbstractTextEditorCommand {

	private String text;
	private String undo;
	
	public AddTextCommand(TextEditor textEditor, String text) {
		super(textEditor);
		this.text = text;
		undo = "";
	}
	
	
	@Override
	public void execute() {
		undo = getTextEditor().getText();
		getTextEditor().setText(getTextEditor().getText() + text);

	}

	@Override
	public void undo() {
		getTextEditor().setText(undo);
	}

}
