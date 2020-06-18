package main.creational.prototype;

public class TAndC extends PrototypeCapableDocument {

	@Override
	public PrototypeCapableDocument cloneDocument() {
		//shallow clone
		TAndC tAndC = null;
		try {
			tAndC = (TAndC) super.clone();
		} catch (CloneNotSupportedException cloneNotSupportedException) {
			cloneNotSupportedException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return tAndC;
	}
	
    @Override
    public String toString() {
    	return String.format("TAndC Vendor: [%s], Content: [%s]", getVendorName(),getContent());
    }
}
