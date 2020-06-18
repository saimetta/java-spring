package main.fabrica.machines.observer;

public interface ProducerSubject {

	public void registerObserver(ProducerObserver observer);
    public void removeObserver(ProducerObserver observer);
    public void notifyObservers();
}
