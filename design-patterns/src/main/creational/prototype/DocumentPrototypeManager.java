package main.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class DocumentPrototypeManager {
	
	private static Map<String, PrototypeCapableDocument> prototypes = new HashMap<String, PrototypeCapableDocument>();
	
	static {
		TAndC tAndC = new TAndC();
		tAndC.setVendorName("Vendor name placeholder");
		tAndC.setContent("Please read and accept the terms and conditions...");
		prototypes.put("TAndC", tAndC);
		
		AuthorizedSignatory authorizedSignatorySanti = new AuthorizedSignatory();
		authorizedSignatorySanti.setName("Santiago");
		authorizedSignatorySanti.setDesignation("CTO");
		NDAgreement ndAgreementIT = new NDAgreement();
		ndAgreementIT.setVendorName("Vendor name placeholder");
		ndAgreementIT.setContent("Please read and accept the NDA...");
		ndAgreementIT.setAuthorizedSignatory(authorizedSignatorySanti);
		prototypes.put("NdAIT", ndAgreementIT);
		
		AuthorizedSignatory authorizedSignatoryAndres = new AuthorizedSignatory();
		authorizedSignatoryAndres.setName("Andres");
		authorizedSignatoryAndres.setDesignation("Sales");
		NDAgreement ndAgreementSales = new NDAgreement();
		ndAgreementSales.setVendorName("Vendor name placeholder");
		ndAgreementSales.setContent("Please read and accept the NDA...");
		ndAgreementSales.setAuthorizedSignatory(authorizedSignatoryAndres);
		prototypes.put("NdASales", ndAgreementSales);
			
	}
	
	public static PrototypeCapableDocument getClonedDocument(final String type) {
		PrototypeCapableDocument document = null;
		PrototypeCapableDocument clonable = prototypes.get(type);
		
		if (clonable != null) {
			try {
				document = clonable.cloneDocument();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return document;
		}else {
			throw new DocumentTypeNotSupportedException(type);
		}
	}
}
