package test.fabrica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.BaseComponent;
import main.fabrica.components.FryingPan;
import main.fabrica.components.Handle;
import main.fabrica.components.Iron;
import main.fabrica.components.PanBody;
import main.fabrica.components.Plastic;
import main.fabrica.components.Product;

class ComponentsUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_CreateABaseComponent_ThenCorrect() {
		BaseComponent iron = new Iron();
		assertEquals(10, iron.getPrice());
	}
	
	@Test
	void When_CreateAProduct_ThenPriceIsCorrect() {
		BaseComponent iron = new Iron();
		BaseComponent plastic = new Plastic();
		Product handle = new Handle();
		handle.addComponent(iron);
		handle.addComponent(iron);
		handle.addComponent(plastic);
		
		assertEquals(25, handle.getPrice());
	}
	
	@Test
	void When_CreateAProductCompoosedByOtherProducts_ThenPriceIsCorrect() {
		BaseComponent iron = new Iron();
		BaseComponent plastic = new Plastic();
		Product handle = new Handle();
		handle.addComponent(iron);
		handle.addComponent(plastic);
		Product panBody = new PanBody();
		panBody.addComponent(iron);
		panBody.addComponent(iron);
		panBody.addComponent(iron);
		Product fryingPan = new FryingPan();
		fryingPan.addComponent(panBody);
		fryingPan.addComponent(handle);
		
		assertEquals(45, fryingPan.getPrice());
	}

}
