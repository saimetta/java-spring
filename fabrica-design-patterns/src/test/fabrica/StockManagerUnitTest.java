package test.fabrica;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.Component;
import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PlasticFactory;
import main.fabrica.stock.NoSuchElementInStockException;
import main.fabrica.stock.StockManager;
import main.fabrica.stock.StockManagerImpl;

class StockManagerUnitTest {

	private StockManager stockManager;
	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory; 
	
	@BeforeEach
	void setUp() throws Exception {
		stockManager = new StockManagerImpl();
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
	}

	@Test
	void When_ReduceSpecificAndNoStock_ThenFail() {
		assertThrows(NoSuchElementInStockException.class, () -> {stockManager.reduceSpecific("Iron", 1);});
	}
	
	@Test
	void When_ReduceSpecificAndNotEnoughStock_ThenFail() {
		stockManager.add(ironFactory.create(5));
		assertThrows(NoSuchElementInStockException.class, () -> {stockManager.reduceSpecific("Iron", 6);});
	}
	
	@Test
	void When_ReduceAndNoStock_ThenFail() {
		assertThrows(NoSuchElementInStockException.class, () -> {stockManager.remove(ironFactory.create());});
	}
	
	@Test
	void When_Reduce_ThenCorrect() {
		stockManager.add(ironFactory.create(3));
		List<Component> extractedItems = stockManager.reduceSpecific("Iron", 2);
		assertEquals(2, extractedItems.size());
		assertEquals("Iron", extractedItems.get(0).getName());
		assertEquals("Iron", extractedItems.get(1).getName());
		assertTrue(stockManager.contains("Iron",1));
	}
	
	@Test
	void When_ReduceMap_ThenCorrect() {
		stockManager.add(ironFactory.create(3));
		stockManager.add(plasticFactory.create(2));
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Iron", 2);
		map.put("Plastic", 1);
		List<Component> extractedItems = stockManager.reduceSpecific(map);
		assertEquals(3, extractedItems.size());
		assertEquals("Iron", extractedItems.get(0).getName());
		assertEquals("Iron", extractedItems.get(1).getName());
		assertEquals("Plastic", extractedItems.get(2).getName());
		assertTrue(stockManager.contains("Iron",1));
		assertTrue(stockManager.contains("Plastic",1));
	}
	
	@Test
	void When_AddMultipleComponents_ThenCorrect() {
		stockManager.add(ironFactory.create(2));
		stockManager.add(plasticFactory.create(5));
		stockManager.add(ironFactory.create());
		assertTrue(stockManager.contains("Iron",3));
		assertTrue(!stockManager.contains("Iron",4));
		assertTrue(stockManager.contains("Plastic",5));
	}
	
	@Test
	void When_GetStockAsList_ThenCorrect() {
		stockManager.add(ironFactory.create(2));
		stockManager.add(plasticFactory.create(3));
		
		List<Component> stockAsList = stockManager.getStockAsList();
		assertEquals(2, stockAsList.stream().filter(component -> { return component.getName().equals("Iron");}).count());
		assertEquals(3, stockAsList.stream().filter(component -> { return component.getName().equals("Plastic");}).count());
	}
	
	@Test
	void When_ContainsMap_ThenCorrect() {
		stockManager.add(ironFactory.create(3));
		stockManager.add(plasticFactory.create(2));
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Iron", 2);
		map.put("Plastic", 1);
		
		assertTrue(stockManager.contains(map));
	}
	
	@Test
	void When_ContainsMap_ThenFail() {
		stockManager.add(ironFactory.create(3));
		stockManager.add(plasticFactory.create(2));
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Iron", 4);
		map.put("Plastic", 1);
		
		assertTrue(!stockManager.contains(map));
	}
	

}
