package main.fabrica.stock.observer;

public interface StockSubject {
	
	public void registerObserver(StockObserver observer);
    public void removeObserver(StockObserver observer);
    public void notifyObservers();
}
