package main.caseofstudy.modelprinter.multiplatform;

public class ApplicationWindow extends Window {

	public ApplicationWindow(WindowImplBridge windowImpl) {
		super(windowImpl);
	}
	
	public String drawsApplicationWindow() {
		return "APP: " + drawWindow();
		
	}

}
