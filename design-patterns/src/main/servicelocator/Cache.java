package main.servicelocator;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    
	private Map<String,MessagingService> services = new HashMap<String,MessagingService>();
 
    public MessagingService getService(String serviceName) {
        return services.get(serviceName);
    }
 
    public void addService(MessagingService newService) {
        services.put(newService.getServiceName(),  newService);
    }
}