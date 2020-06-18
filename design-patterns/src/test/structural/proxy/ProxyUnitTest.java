package test.structural.proxy;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.structural.proxy.ReportGenerator;
import main.structural.proxy.ReportGeneratorImplProxy;
import main.structural.proxy.Role;

class ProxyUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_CreateProtectionProxy_ThenCorrect() {
		Role managerRole = new Role();
		managerRole.setRole("Manager");
		ReportGenerator generator = new ReportGeneratorImplProxy(managerRole);
		assertEquals("ReportGeneratorImpl: Generating sensitive report", generator.generateSensitiveReport());
	}
	
	@Test
	void When_CreateVirtualProxy_ThenCorrect() {
		Role managerRole = new Role();
		managerRole.setRole("Manager");
		ReportGenerator generator = new ReportGeneratorImplProxy(managerRole);
		assertEquals("ReportGeneratorImpl: Generating complex report in Email format with 150 entries", generator.generateComplexReport("Email", 150));
	}

}
