package main.structural.facade;

public class OrderServiceFacadeImpl implements OrderServiceFacade {

	public OrderServiceFacadeImpl() {
	}
	
	@Override
	public boolean placeOrder(int productId) {
		Boolean orderFullfiled = false;
		Product product = new Product();
		product.productId = productId;
		if (InventoryService.isAvailable(product)) {
			PaymentService.makePayment();
			ShippingService.shipProduct(product);
			orderFullfiled = true;
		}
		
		return orderFullfiled;
	}	
}
