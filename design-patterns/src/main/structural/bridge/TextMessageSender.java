package main.structural.bridge;

public class TextMessageSender implements MessageSender {
	
    @Override
    public String sendMessage(){
        return "TextMessageSender: Sending text message...";
    }
}