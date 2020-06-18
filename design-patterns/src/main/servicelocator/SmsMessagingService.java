package main.servicelocator;

public class SmsMessagingService implements MessagingService {

	@Override
	public String getMessageBody() {
		return "SMS message";
	}

	@Override
	public String getServiceName() {
		return "SMSService";
	}

}
