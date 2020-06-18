package main.behavioral.visitor;

public class WindowsClientVisitor implements MailClientVisitor {

	@Override
	public void visit(OperaMailClient client) {
		System.out.println("Configuration of Opera mail client for Windows complete");
	}

	@Override
	public void visit(SquirrelMailClient client) {
		System.out.println("Configuration of Squirrel mail client for Windows complete");
	}

	@Override
	public void visit(MozillaMailClient client) {
		System.out.println("Configuration of Mozilla mail client for Windows complete");		
	}

}
