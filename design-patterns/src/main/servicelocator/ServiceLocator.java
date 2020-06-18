package main.servicelocator;
public class ServiceLocator {
 
    private static Cache cache = new Cache();
 
    public static MessagingService getService(String serviceName) {
 
        MessagingService service = cache.getService(serviceName);
 
        if (service != null) {
            return service;
        }
 
        InitialContext context = new InitialContext();
        MessagingService newService = (MessagingService) context
          .lookup(serviceName);
        cache.addService(newService);
        return newService;
    }
}