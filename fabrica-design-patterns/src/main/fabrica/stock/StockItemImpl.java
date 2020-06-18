package main.fabrica.stock;

import java.util.ArrayList;
import java.util.List;

import main.fabrica.components.Component;

public class StockItemImpl implements StockItem {

	private List<Component> components;
	
	public StockItemImpl() {
		components = new ArrayList<Component>();
	}
	
	@Override
	public Integer getAmount() {
		return components.size();
	}

	@Override
	public List<Component> getList() {
		return components;
	}

	@Override
	public void addItem(Component component) {
		components.add(component);
	}

	@Override
	public List<Component> reduceItem(Integer amount) {
		List<Component> extracted = new ArrayList<Component>(amount);
		while(amount > 0) {
			extracted.add(components.remove(components.size()-1));
			amount--;
		}
		return extracted;
	}
}
