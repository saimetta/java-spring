package test.behavioral.observer;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.observer.Bidder;
import main.behavioral.observer.Observer;
import main.behavioral.observer.Product;
import main.behavioral.observer.Subject;


class ObserverUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testObserver() throws Exception {
        Subject product=new Product("36 inch LED TV",new BigDecimal(350));
        
        Observer bidder1=new Bidder("Alex Parker");
        Observer bidder2=new Bidder("Henry Smith");
        Observer bidder3=new Bidder("Mary Peterson");
       
        product.registerObserver(bidder1);
        product.registerObserver(bidder2);
        product.registerObserver(bidder3);
        product.setBidAmount(bidder1, new BigDecimal(375));
        product.removeObserver(bidder2);
        product.setBidAmount(bidder3, new BigDecimal(400));
   }

}
