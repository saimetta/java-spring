package main.caseofstudy.modelprinter.userinteraction;

import java.util.LinkedList;
import java.util.Queue;

public class UserActionCommandManager {

	private Queue<UserActionCommand> queue;
	private UserActionCommand lastCommand;
	
	public UserActionCommandManager() {
		queue = new LinkedList<UserActionCommand>();
	}
	
	public String registerCommand(UserActionCommand command) {
		lastCommand = command;
		queue.add(command);
		return command.execute();
	}
	
	public String undoLastCommand() {
		return lastCommand.undo();
	}
	
	
	
	
}
