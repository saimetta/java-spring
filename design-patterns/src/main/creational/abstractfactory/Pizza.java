package main.creational.abstractfactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

	protected List<String> ingredients;
	
	public Pizza() {
		ingredients = new ArrayList<String>();
		
	}
	
	public String listIngredients() {
		return String.join(" - ", ingredients);
	}
	
	protected void addIngredients(String ingredient) {
		ingredients.add(ingredient);
	}
	
	protected void addCheese(Cheese cheese) {
		addIngredients(cheese.prepareCheese());
	}
	
	protected void addSauce(Sauce sauce) {
		addIngredients(sauce.prepareSauce());
	}
	
	
}
