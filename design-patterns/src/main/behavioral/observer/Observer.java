package main.behavioral.observer;

import java.math.BigDecimal;

public interface Observer {
	
    public void update(Observer observer,String productName, BigDecimal bidAmount);

}