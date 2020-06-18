package test.creational.prototype;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.creational.prototype.DocumentPrototypeManager;
import main.creational.prototype.PrototypeCapableDocument;

class PrototypeUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_CreateTAndC_ThenCorrect() {
		PrototypeCapableDocument tAndC = DocumentPrototypeManager.getClonedDocument("TAndC");
		tAndC.setVendorName("Apple");
		tAndC.setContent("Terms and conditions for 2020");
		assertEquals("TAndC Vendor: [Apple], Content: [Terms and conditions for 2020]", tAndC.toString());
	}
	
	@Test
	void When_CreateMultipleTAndC_ThenCorrect() {
		PrototypeCapableDocument tAndCA = DocumentPrototypeManager.getClonedDocument("TAndC");
		tAndCA.setVendorName("Apple");
		tAndCA.setContent("Terms and conditions for 2020");
		assertEquals("TAndC Vendor: [Apple], Content: [Terms and conditions for 2020]", tAndCA.toString());
	
		PrototypeCapableDocument tAndCM = DocumentPrototypeManager.getClonedDocument("TAndC");
		tAndCM.setVendorName("Microsoft");
		tAndCM.setContent("Terms and conditions for 2020");
		assertEquals("TAndC Vendor: [Microsoft], Content: [Terms and conditions for 2020]", tAndCM.toString());
	}
	
	@Test
	void When_CreateNdaIT_ThenCorrect() {
		PrototypeCapableDocument ndaIT = DocumentPrototypeManager.getClonedDocument("NdAIT");
		ndaIT.setVendorName("Apple");
		ndaIT.setContent("NDA for 2020");
		assertEquals("NDAgreement Vendor: [Apple], Content: [NDA for 2020], AuthorizedSignatory: [AuthorizedSignatory Name: [Santiago], Designation: [CTO]]", ndaIT.toString());
	}
	
	@Test
	void When_CreateNdaSales_ThenCorrect() {
		PrototypeCapableDocument ndaIT = DocumentPrototypeManager.getClonedDocument("NdASales");
		ndaIT.setVendorName("Apple");
		ndaIT.setContent("NDA for 2020");
		assertEquals("NDAgreement Vendor: [Apple], Content: [NDA for 2020], AuthorizedSignatory: [AuthorizedSignatory Name: [Andres], Designation: [Sales]]", ndaIT.toString());
	}

}
