package main.behavioral.visitor;

public interface MailClient {
    
	String sendMail(String[] mailInfo);
    String receiveMail(String[] mailInfo);
    void accept(MailClientVisitor visitor);
}