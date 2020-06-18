package main.fabrica.components.factories;

import main.fabrica.stock.StockManager;
import main.fabrica.stock.StockManagerImpl;

public class StockManagerFactory {
	
	public static StockManager createStockManager() {
		return new StockManagerImpl();
	}
}
