package main.behavioral.command;

public class ClearTextCommand extends AbstractTextEditorCommand {

	private String undo;
	
	public ClearTextCommand(TextEditor editor) {
		super(editor);
		undo = "";
	}

	@Override
	public void execute() {
		undo = getTextEditor().getText();
		getTextEditor().setText("");
		
	}

	@Override
	public void undo() {
		getTextEditor().setText(undo);
	}
}
