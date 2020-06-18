package test.structural.bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.structural.bridge.EmailMessage;
import main.structural.bridge.EmailMessageSender;
import main.structural.bridge.Message;
import main.structural.bridge.TextMessage;
import main.structural.bridge.TextMessageSender;

class BridgeUnitTest {

	@Test
	void When_SendEmailMessage_ThenCorrect() {
		Message email = new EmailMessage(new EmailMessageSender());
		assertEquals("EmailMessageSender: Sending email message..." , email.send());
	}
	
	@Test
	void When_SendTextMessage_ThenCorrect() {
		Message text = new TextMessage(new TextMessageSender());
		assertEquals("TextMessageSender: Sending text message..." , text.send());
	}

}
