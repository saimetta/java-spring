package main.fabrica.machines;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.fabrica.components.Component;
import main.fabrica.components.Product;
import main.fabrica.components.factories.ProductFactory;
import main.fabrica.components.factories.StockManagerFactory;
import main.fabrica.components.formulas.Formula;
import main.fabrica.machines.observer.ProducerObserver;
import main.fabrica.machines.observer.ProducerSubject;
import main.fabrica.stock.StockManager;

public class Machine implements ProductProducer, ProducerSubject, ProductProducerContext {

	private final ProductFactory factory;
	private final Formula formula;
	private final String productName;
	private final StockManager stockManager;
	private List<ProducerObserver> observers;
	private int productionCount;
	private Product lastProduced;
	private ProducerState state;
	private Date lastestProduction;
	
	
	public Machine(ProductFactory factory, Formula formula,String productName) {
		this.factory = factory;
		this.formula = formula;
		this.productName = productName;
		stockManager = StockManagerFactory.createStockManager();
		observers = new ArrayList<ProducerObserver>();
		productionCount = 0;
		state = getNotReadyState();
		lastestProduction = ProductProducer.BASE_DATE;
	}

	@Override
	public void add(Component component) {
		state.add(component);
	}

	@Override
	public boolean isReady() {
		return formula.hasRequiredComponents(stockManager.getStockAsList());
	}

	@Override
	public Product produce() {
		Product product = state.produce();
		lastProduced = product;
		productionCount++;
		notifyObservers();
		lastestProduction = new Date();
		return product;
	}
	
	@Override
	public Map<String,Integer> getComponentsNeededToProduce() {
		Map<String, Integer> requiredComponentsMap = formula.getRequiredComponentsMap();
		Map<String, Integer> neededToProduce = new HashMap<String, Integer>();

		for (String componentName : requiredComponentsMap.keySet()) {
			int amountNeeded = requiredComponentsMap.get(componentName);
			int amountFromStock = stockManager.getCount(componentName);
			if (amountNeeded > amountFromStock) {
				neededToProduce.put(componentName, amountNeeded - amountFromStock);
			}
		}
		return neededToProduce;
	}
	

	@Override
	public void registerObserver(ProducerObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(ProducerObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ProducerObserver observer : observers) {
			observer.update(lastProduced);
		}
		
	}

	@Override
	public ProducerState getCompletedState() {
		return ProducerStateFactory.createCompleteState(this);
	}
	
	@Override
	public ProducerState getNotReadyState() {
		return ProducerStateFactory.createNotReadyState(this);
	}

	@Override
	public void setState(ProducerState state) {
		this.state = state;
	}

	@Override
	public String getProductName() {
		return productName;
	}

	
	@Override
	public Product getProductFromFactory(List<Component> components) {
		return factory.create(components);
	}
	
	@Override
	public List<Component> getStockToProduce() {
		Map<String, Integer> requiredComponentsMap = formula.getRequiredComponentsMap();
		List<Component> input = new ArrayList<Component>();
		for (String componentName : requiredComponentsMap.keySet()) {
			int amountNeeded = requiredComponentsMap.get(componentName);
			List<Component> componentsFromStock = stockManager.reduceSpecific(componentName, amountNeeded);
			input.addAll(componentsFromStock);
		}
		return input;
	}

	@Override
	public void addToStock(Component component) {
		stockManager.add(component);
	}

	@Override
	public void addToStock(List<Component> components) {
		stockManager.add(components);
	}

	@Override
	public Date getLastProductionDate() {
		return lastestProduction;
	}

	@Override
	public int getProductionCount() {
		return productionCount;
	}

	@Override
	public boolean isComponentRequired(Component component) {
		int requiredAmount = formula.getRequiredAmount(component);
		return requiredAmount > 0 && !stockManager.contains(component.getName(), requiredAmount);
	}

	@Override
	public int countComponentsNeededToProduce() {
		Map<String,Integer> needCompoenentsMap = getComponentsNeededToProduce();
		int total = 0;
		for (String key: needCompoenentsMap.keySet()) {
			total += needCompoenentsMap.get(key);
		}
		return total;
	}
}
