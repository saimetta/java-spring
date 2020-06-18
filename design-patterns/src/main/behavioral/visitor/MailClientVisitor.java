package main.behavioral.visitor;

public interface MailClientVisitor {
	void visit(OperaMailClient client);
	void visit(SquirrelMailClient client);
	void visit(MozillaMailClient client);
}
