package main.caseofstudy.modelprinter.documentstructure;

public class BaseObjectImpl implements BaseObject {

	private String name;
	
	
	
	public BaseObjectImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String print() {
		return name;
	}

}
