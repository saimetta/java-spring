package main.servicelocator;
public class InitialContext {
    
	public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailMessagingService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SmsMessagingService();
        }
        return null;
    }
}