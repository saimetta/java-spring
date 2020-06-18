package test.behavioral.chainofresponsability;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.chainofresponsability.AbstractSupportHandler;
import main.behavioral.chainofresponsability.RequestorClient;

class ChainOfResponsabilityUnitTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void When_BillingRequest_ThenCorrect() {
		assertEquals("BillingSupportHandler: Processing request Billing request", RequestorClient.getHandlerChain().receiveRequest(AbstractSupportHandler.BILLING, "Billing request"));
	}
	
	@Test
	void When_TechnicalRequest_ThenCorrect() {
		assertEquals("TechnicalSupportHandler: Processing request Technical request", RequestorClient.getHandlerChain().receiveRequest(AbstractSupportHandler.TECHNICAL, "Technical request"));
	}
	
	@Test
	void When_GeneralRequest_ThenCorrect() {
		assertEquals("GeneralSupportHandler: Processing request General request", RequestorClient.getHandlerChain().receiveRequest(AbstractSupportHandler.GENERAL, "General request"));
	}

}
