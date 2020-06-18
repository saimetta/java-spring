package test.caseofstudy.modelprinter.userinteraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.caseofstudy.modelprinter.userinteraction.ScreenOne;
import main.caseofstudy.modelprinter.userinteraction.ScreenTwo;
import main.caseofstudy.modelprinter.userinteraction.UserActionCommandManager;

class UserInteractionUnitTest {

	@Test
	void When_RegisterCommand_ThenCorrect() {
		UserActionCommandManager actionCommandManager = new UserActionCommandManager();
		ScreenOne screenOne = new ScreenOne(actionCommandManager);
		assertEquals("Screen one action", screenOne.simulateUserAction());
	}
	
	@Test
	void When_MultipleSourcesRegistesrCommand_ThenCorrect() {
		UserActionCommandManager actionCommandManager = new UserActionCommandManager();
		ScreenOne screenOne = new ScreenOne(actionCommandManager);
		ScreenTwo screenTwo = new ScreenTwo(actionCommandManager);

		assertEquals("Screen one action", screenOne.simulateUserAction());
		assertEquals("Screen two action", screenTwo.simulateUserAction());
		assertEquals("Screen one action", screenOne.simulateUserAction());
	}
	
	@Test
	void When_UndoCommand_ThenCorrect() {
		UserActionCommandManager actionCommandManager = new UserActionCommandManager();
		ScreenOne screenOne = new ScreenOne(actionCommandManager);
		ScreenTwo screenTwo = new ScreenTwo(actionCommandManager);

		assertEquals("Screen one action", screenOne.simulateUserAction());
		assertEquals("Screen two action", screenTwo.simulateUserAction());
		assertEquals("Screen one action", screenOne.simulateUserAction());
		assertEquals("Undo printing: Screen one action", actionCommandManager.undoLastCommand());

	}

}
