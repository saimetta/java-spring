package test.caseofstudy.modelprinter.multiplatform;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.caseofstudy.modelprinter.multiplatform.ApplicationWindow;
import main.caseofstudy.modelprinter.multiplatform.MacWindow;
import main.caseofstudy.modelprinter.multiplatform.UnixWindow;
import main.caseofstudy.modelprinter.multiplatform.WindowImplBridge;

class MultiplatformWindowUnitTest {

	@Test
	void When_DrawApplicationUnixWindow_ThenCorrect() {
		WindowImplBridge unixWindow = new UnixWindow();
		ApplicationWindow applicationWindow = new ApplicationWindow(unixWindow);
		
		assertEquals("APP: Unix window drawn", applicationWindow.drawsApplicationWindow());
	}
	
	@Test
	void When_DrawApplicationMacWindow_ThenCorrect() {
		WindowImplBridge macWindow = new MacWindow();
		ApplicationWindow applicationWindow = new ApplicationWindow(macWindow);
		
		assertEquals("APP: Mac window drawn", applicationWindow.drawsApplicationWindow());
	}
	
	@Test
	void When_SwitchApplicationWindowImplementation_ThenCorrect() {
		WindowImplBridge macWindow = new MacWindow();
		WindowImplBridge unixWindow = new UnixWindow();
		ApplicationWindow applicationWindow = new ApplicationWindow(macWindow);
		
		assertEquals("APP: Mac window drawn", applicationWindow.drawsApplicationWindow());
		
		applicationWindow.setImplementation(unixWindow);
		
		assertEquals("APP: Unix window drawn", applicationWindow.drawsApplicationWindow());
	}
	
	

}
