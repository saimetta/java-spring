package test.creational.abstractfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.creational.abstractfactory.BasePizzaFactory;
import main.creational.abstractfactory.BaseToppingFactory;
import main.creational.abstractfactory.GourmetPIzzaFactory;
import main.creational.abstractfactory.GourmetToppingFactory;
import main.creational.abstractfactory.Pizza;
import main.creational.abstractfactory.SicilianPizzaFactory;

class AbstractFactoryUnitTest {

	private BasePizzaFactory gourmetFactory;
	private BasePizzaFactory sicilianFactory;
	
	@BeforeEach
	void setUp() throws Exception {
		gourmetFactory  = new GourmetPIzzaFactory();
		sicilianFactory = new SicilianPizzaFactory();
	}

	@Test
	void When_CreateVeganPizzaFromGourmetFactory_ThenCorrect() {
		Pizza pizza = gourmetFactory.createPizza("Vegan");
		assertEquals("Spcicy sauce - Brocoli and peppers - Eggplant slices - Basil", pizza.listIngredients());
	}
	
	@Test
	void When_CreateVeganPizzaFromSicilianFactory_ThenCorrect() {
		Pizza pizza = sicilianFactory.createPizza("Vegan");
		assertEquals("Tomato sauce - Brocoli and peppers - Eggplant slices - Basil", pizza.listIngredients());
	}
	
	@Test
	void When_CreateCheesePizzaFromGourmetFactory_ThenCorrect() {
		Pizza pizza = gourmetFactory.createPizza("Cheese");
		assertEquals("Goat cheese - Spcicy sauce - Oregano", pizza.listIngredients());
	}
	
	@Test
	void When_CreateCheesePizzaFromSicilianFactory_ThenCorrect() {
		Pizza pizza = sicilianFactory.createPizza("Cheese");
		assertEquals("Mozzarella - Tomato sauce - Oregano", pizza.listIngredients());
	}
}
