package main.behavioral.visitor;

public class SquirrelMailClient implements MailClient {
    @Override
    public String sendMail(String[] mailInfo) {
        return  "SquirrelMailClient: Sending mail";
    }
    @Override
    public String receiveMail(String[] mailInfo) {
        return "SquirrelMailClient: Receiving mail";
    }

	@Override
	public void accept(MailClientVisitor visitor) {
		visitor.visit(this);
	}
}