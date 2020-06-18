package main.caseofstudy.modelprinter.userinteraction;


public class ScreenTwo {

	private UserActionCommandManager actionManager;

	public ScreenTwo(UserActionCommandManager actionManager) {
		super();
		this.actionManager = actionManager;
	}
	
	public String simulateUserAction() {
		PrintTextAction action = new PrintTextAction("Screen two action");
		return actionManager.registerCommand(action);
	}
}
