package main.behavioral.visitor;

public class MozillaMailClient implements MailClient {

 	@Override
    public String sendMail(String[] mailInfo) {
        return  "MozillaMailClient: Sending mail";
    }
    @Override
    public String receiveMail(String[] mailInfo) {
        return "MozillaMailClient: Receiving mail";
    }

	@Override
	public void accept(MailClientVisitor visitor) {
		visitor.visit(this);
	}
}
