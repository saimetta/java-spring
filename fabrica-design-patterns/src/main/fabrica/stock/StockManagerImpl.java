package main.fabrica.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;

public class StockManagerImpl implements StockManager {
	
	private Map<String,StockItem> stockMap;
	
	public StockManagerImpl() {
		stockMap = new HashMap<String, StockItem>();
	}

	@Override
	public void add(Component component) {
		String key = component.getName();
		StockItem stockItem;
		if (!stockMap.containsKey(key)) {
			stockItem = new StockItemImpl();
		}else {
			stockItem = stockMap.get(key);
		}
		stockItem.addItem(component);
		stockMap.put(key, stockItem);

	}

	@Override
	public void add(List<Component> components) {
		for (Component component : components) {
			add(component);
		}
	}

	@Override
	public void remove(Component component) {
		String key = component.getName();
		if (!stockMap.containsKey(key)) {
			throw new NoSuchElementInStockException(component.getName());
		}
		stockMap.get(key).reduceItem(1);

	}

	@Override
	public void remove(List<Component> components) {
		for (Component component : components) {
			remove(component);
		}
	}

	@Override
	public Map<String, Integer> getStatus() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String key : stockMap.keySet()) {
			result.put(key, stockMap.get(key).getAmount());
		}
		return result;
	}

	@Override
	public Map<String, List<Component>> getStockMap() {
		Map<String, List<Component>> result = new HashMap<String, List<Component>>();
		for (String key : stockMap.keySet()) {
			result.put(key, stockMap.get(key).getList());
		}
		return result;
	}

	@Override
	public List<Component> reduceSpecific(String componentName, Integer amount) {
		if (!stockMap.containsKey(componentName) || stockMap.get(componentName).getAmount() < amount) {
			throw new NoSuchElementInStockException(componentName);
		}
		return stockMap.get(componentName).reduceItem(amount);
	}
	
	@Override
	public List<Component> reduceSpecific(Map<String, Integer> componentsMap) {
		List<Component> components = new ArrayList<Component>();
		for (String componentName : componentsMap.keySet()) {
			components.addAll(reduceSpecific(componentName,componentsMap.get(componentName)));
		}
		return components;
	}

	@Override
	public boolean contains(String componentName) {
		return stockMap.containsKey(componentName);
	}

	@Override
	public boolean contains(String componentName, Integer amount) {
		return stockMap.containsKey(componentName) && stockMap.get(componentName).getAmount() >= amount;
	}
	
	@Override
	public boolean contains(Map<String, Integer> componentsMap) {
		for (String componentName : componentsMap.keySet()) {
			if (!contains(componentName,componentsMap.get(componentName))) return false; 
		}
		return true;
	}

	@Override
	public List<Component> getStockAsList() {
		List<Component> result = new ArrayList<Component>();
		for (String key : stockMap.keySet()) {
			result.addAll(stockMap.get(key).getList());
		}
		return result;
	}

	@Override
	public Integer getCount(String componentName) {
		if (contains(componentName)) {
			return stockMap.get(componentName).getAmount();
		}
		return 0;
	}
}
