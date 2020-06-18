package main.caseofstudy.modelprinter.userinteraction;

public interface UserActionCommand {
	
	String execute();
	String undo();
}
