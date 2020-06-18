package main.fabrica.stock;

import java.util.List;

import main.fabrica.components.Component;

public interface StockItem {

	Integer getAmount();
	List<Component> getList();
	void addItem(Component component);
	List<Component> reduceItem(Integer amount);
}
