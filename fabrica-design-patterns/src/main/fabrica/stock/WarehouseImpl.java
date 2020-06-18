package main.fabrica.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;
import main.fabrica.machines.observer.ProducerObserver;
import main.fabrica.stock.observer.StockObserver;
import main.fabrica.stock.observer.StockSubject;

public class WarehouseImpl implements Warehouse, StockSubject, ProducerObserver {

	private StockManager stockManager;
	private List<StockObserver> observers;
	
	public WarehouseImpl() {
		stockManager = new StockManagerImpl();
		observers = new ArrayList<StockObserver>();
	}
	
	@Override
	public void add(Component component) {
		stockManager.add(component);
	}

	@Override
	public void add(List<Component> components) {
		stockManager.add(components);
	}

	@Override
	public void remove(Component component) {
		stockManager.remove(component);
	}

	@Override
	public void remove(List<Component> components) {
		stockManager.remove(components);
	}

	@Override
	public Map<String, Integer> getStatus() {
		return stockManager.getStatus();
	}

	@Override
	public Map<String, List<Component>> getStockMap() {
		return stockManager.getStockMap();
	}

	@Override
	public List<Component> reduceSpecific(String componentName, Integer amount) {
		return stockManager.reduceSpecific(componentName, amount);
	}
	
	@Override
	public List<Component> reduceSpecific(Map<String, Integer> componentsMap) {
		return stockManager.reduceSpecific(componentsMap);
	}

	@Override
	public boolean contains(String componentName) {
		return stockManager.contains(componentName);
	}

	@Override
	public boolean contains(String componentName, Integer amount) {
		return stockManager.contains(componentName, amount);
	}
	
	@Override
	public boolean contains(Map<String, Integer> componentsMap) {
		return stockManager.contains(componentsMap);
	}

	@Override
	public List<Component> getStockAsList() {
		return stockManager.getStockAsList();
	}

	@Override
	public void registerObserver(StockObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(StockObserver observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		for (StockObserver stockObserver : observers) {
			stockObserver.update(this);
		}	
	}
	
	@Override
	/**
	 * On machine produce, add product to stock
	 */
	public void update(Component product) {
		add(product);
	}

	@Override
	public Integer getCount(String componentName) {
		return stockManager.getCount(componentName);
	}
}
