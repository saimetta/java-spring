package main.caseofstudy.modelprinter.multiplatform;

public abstract class Window {

	private WindowImplBridge windowImpl;

	public Window(WindowImplBridge windowImpl) {
		super();
		this.windowImpl = windowImpl;
	}
	
	public void setImplementation(WindowImplBridge impl) {
		windowImpl = impl;
	}
	
	public String drawWindow() {
		return this.windowImpl.drawWindow();
	}
	
}
