package main.caseofstudy.modelprinter.multiplatform;

public class IconWindonw extends Window {

	public IconWindonw(WindowImplBridge windowImpl) {
		super(windowImpl);
	}
	
	public String drawIconWindow() {
		return "ICON: " + drawWindow();
	}
	
	

}
