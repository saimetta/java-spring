package test.behavioral.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.command.AddTextCommand;
import main.behavioral.command.ClearTextCommand;
import main.behavioral.command.Command;
import main.behavioral.command.TextEditor;

class CommandUnitTest {

	private TextEditor textEditor;
	@BeforeEach
	void setUp() throws Exception {
		textEditor = new TextEditor();
	}

	@Test
	void When_ExecuteAddCommand_ThenCorrect() {
		
		Command addText = new AddTextCommand(textEditor, "Hello world\n");
		textEditor.executeAction(addText);
		assertEquals("Hello world\n", textEditor.getText());
	}
	
	@Test
	void When_ExecuteUndoAddCommand_ThenCorrect() {
		
		textEditor.executeAction(new AddTextCommand(textEditor, "Hello world\n"));
		textEditor.executeAction(new AddTextCommand(textEditor, "Bye world\n"));
		textEditor.undo();
		assertEquals("Hello world\n", textEditor.getText());
	}
	
	@Test
	void When_ExecuteClearTextCommand_ThenCorrect() {
		
		textEditor.executeAction(new AddTextCommand(textEditor, "Hello world\n"));
		textEditor.executeAction(new ClearTextCommand(textEditor));
		assertEquals("", textEditor.getText());
	}
	
	@Test
	void When_ExecuteUndoClearTextCommand_ThenCorrect() {
		
		textEditor.executeAction(new AddTextCommand(textEditor, "Hello world\n"));
		textEditor.executeAction(new ClearTextCommand(textEditor));
		textEditor.undo();
		assertEquals("Hello world\n", textEditor.getText());
	}
	
	@Test
	void When_ExecuteUndoMultipleTimesThenCorrect_ThenCorrect() {
		
		textEditor.executeAction(new AddTextCommand(textEditor, "Hello world\n"));
		textEditor.executeAction(new AddTextCommand(textEditor, "Bye world\n"));
		textEditor.executeAction(new ClearTextCommand(textEditor));
		textEditor.executeAction(new AddTextCommand(textEditor, "New text\n"));
		assertEquals("New text\n", textEditor.getText());
		textEditor.undo();
		assertEquals("", textEditor.getText());
		textEditor.undo();
		assertEquals("Hello world\nBye world\n", textEditor.getText());
		textEditor.undo();
		assertEquals("Hello world\n", textEditor.getText());
		textEditor.undo();
		assertEquals("", textEditor.getText());
	}

}
