package main.behavioral.visitor;

public class OperaMailClient implements MailClient {
    @Override
    public String sendMail(String[] mailInfo) {
        return  "OperaMailClient: Sending mail";
    }
    @Override
    public String receiveMail(String[] mailInfo) {
        return "OperaMailClient: Receiving mail";
    }

	@Override
	public void accept(MailClientVisitor visitor) {
		visitor.visit(this);
	}
}