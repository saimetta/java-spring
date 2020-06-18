package main.behavioral.command;

import java.util.Stack;

public class TextEditor {

	private String text;
	private Stack<Command> stack;
	
	public TextEditor() {
		stack = new Stack<Command>();
		text = "";
	}
	
	public void executeAction(Command command) {
		command.execute();
		stack.push(command);
	}
	
	public void undo() {
		Command action = stack.pop();
		if (action != null) action.undo();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
