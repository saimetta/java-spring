package main.servicelocator;

public class EmailMessagingService implements MessagingService {

	@Override
	public String getMessageBody() {
		return "Email message";
	}

	@Override
	public String getServiceName() {
		return "EmailService";
	}

}
