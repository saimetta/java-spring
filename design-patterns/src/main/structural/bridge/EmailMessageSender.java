package main.structural.bridge;

public class EmailMessageSender implements MessageSender{
	
    @Override
    public String sendMessage(){
        return "EmailMessageSender: Sending email message...";
    }
}