package main.creational.prototype;

public class NDAgreement extends PrototypeCapableDocument {
	
	private AuthorizedSignatory authorizedSignatory;
	
	public AuthorizedSignatory getAuthorizedSignatory() {
		return authorizedSignatory;
	}

	public void setAuthorizedSignatory(AuthorizedSignatory authorizedSignatory) {
		this.authorizedSignatory = authorizedSignatory;
	}



	@Override
	public PrototypeCapableDocument cloneDocument() throws CloneNotSupportedException {
		NDAgreement nda;
		nda = (NDAgreement) super.clone();
		AuthorizedSignatory clonedAuthorizedSignatory = (AuthorizedSignatory) nda.getAuthorizedSignatory().clone();
		nda.setAuthorizedSignatory(clonedAuthorizedSignatory);
		
		return nda;
	}
	
	@Override
	public String toString() {
		return String.format("NDAgreement Vendor: [%s], Content: [%s], AuthorizedSignatory: [%s]", getVendorName(), getContent(), getAuthorizedSignatory());
	}
}
