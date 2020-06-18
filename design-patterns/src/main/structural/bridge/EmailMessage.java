package main.structural.bridge;

public class EmailMessage extends Message{
	
    public EmailMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public String send(){
        return messageSender.sendMessage();
    }
}