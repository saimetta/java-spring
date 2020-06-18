package main.caseofstudy.modelprinter.userinteraction;


public class ScreenOne {

	private UserActionCommandManager actionManager;

	public ScreenOne(UserActionCommandManager actionManager) {
		super();
		this.actionManager = actionManager;
	}
	
	public String simulateUserAction() {
		PrintTextAction action = new PrintTextAction("Screen one action");
		return actionManager.registerCommand(action);
	}
}
