package test.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

import main.behavioral.templatemethod.InHouseAssortedPizzaMaker;
import main.behavioral.templatemethod.NonVegPizzaMaker;
import main.behavioral.templatemethod.PizzaMaker;
import main.behavioral.templatemethod.VegPizzaMaker;

class TemplateMethodUnitTest {

	@Test
	public void testMakePizza() throws Exception {
        System.out.println("-----Making Veg Pizza-----");
        PizzaMaker vegPizzaMaker = new VegPizzaMaker();
        vegPizzaMaker.makePizza();
        System.out.println("-----Making Non Veg Pizza-----");
        PizzaMaker nonVegPizzaMaker = new NonVegPizzaMaker();
        nonVegPizzaMaker.makePizza();
        System.out.println("-----Making In-House Assorted Pizza-----");
        PizzaMaker inHouseAssortedPizzaMaker = new InHouseAssortedPizzaMaker();
        inHouseAssortedPizzaMaker.makePizza();
    }

}
