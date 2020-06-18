package test.fabrica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.Component;
import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PlasticFactory;


class BaseComponentFactoryUnitTest {

	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory;
	@BeforeEach
	void setUp() throws Exception {
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
	}

	@Test
	void When_CreateBaseObject_ThenCorrect() {
		
		assertEquals("main.fabrica.components.Plastic", plasticFactory.create().getClass().getName());
		assertEquals("main.fabrica.components.Iron", ironFactory.create().getClass().getName());
	}
	
	@Test
	void When_CreateMultipleBaseObjects_ThenCorrect() {
		List<Component> iron = ironFactory.create(3);
		List<Component> plastic = plasticFactory.create(2);
		
		assertEquals("main.fabrica.components.Plastic",plastic.get(0).getClass().getName());
		assertEquals("main.fabrica.components.Iron", iron.get(0).getClass().getName());
		assertEquals(3, iron.size());
		assertEquals(2, plastic.size());
	}

}
