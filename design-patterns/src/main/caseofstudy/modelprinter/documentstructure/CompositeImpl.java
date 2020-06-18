package main.caseofstudy.modelprinter.documentstructure;

import java.util.ArrayList;
import java.util.List;

public class CompositeImpl extends BaseObjectImpl implements Composite {

	
	private List<BaseObject> components;
	
	public CompositeImpl(String name) {
		super(name);
		components = new ArrayList<>();
	}
	
	public void addComponent(BaseObject components)  {
		this.components.add(components);
	}
	
	@Override
	public String print() {
		List<String> toPrint = new ArrayList<>();
		toPrint.add(getName());
		components.forEach(component -> {
			toPrint.add(component.print());
		});
		return String.join(" ", toPrint);
	}
	
	

}
