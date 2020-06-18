package main.fabrica.stock;

import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;

public interface StockManager {
	
	void add(Component component);
	void add(List<Component> components);
	void remove(Component component);
	void remove(List<Component> components);
	Map<String, Integer> getStatus();
	Map<String, List<Component>> getStockMap();
	List<Component> reduceSpecific(String componentName, Integer amount);
	List<Component> reduceSpecific(Map<String,Integer> componentsMap);
	boolean contains(String componentName);
	boolean contains(String componentName, Integer amount);
	boolean contains(Map<String,Integer> componentsMap);
	Integer getCount(String componentName);
	List<Component> getStockAsList();
}
