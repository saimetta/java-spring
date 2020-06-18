package main.behavioral.command;

public abstract class AbstractTextEditorCommand implements Command{

	private TextEditor textEditor;
	
	public AbstractTextEditorCommand(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
	
	public TextEditor getTextEditor() {
		return textEditor;
	}
}
