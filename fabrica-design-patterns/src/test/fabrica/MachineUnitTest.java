package test.fabrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.Product;
import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.FryingPanFactory;
import main.fabrica.components.factories.HandleFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PanBodyFactory;
import main.fabrica.components.factories.PlasticFactory;
import main.fabrica.components.formulas.FryingPanFormula;
import main.fabrica.components.formulas.HandleFormula;
import main.fabrica.components.formulas.PanBodyFormula;
import main.fabrica.machines.InsufficientComponentsException;
import main.fabrica.machines.Machine;
import main.fabrica.machines.ProductProducer;
import main.fabrica.machines.observer.ProducerSubject;
import main.fabrica.stock.WarehouseImpl;

class MachineUnitTest {

	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory;
	@BeforeEach
	void setUp() throws Exception {
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
		
	}

	@Test
	void When_HandleMachineProduce_ThenCorrect() {
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		assertTrue(handleMachine.isReady());
		Product handle = handleMachine.produce();
		assertEquals("Handle", handle.getName());
	}
	
	@Test
	void When_HandleMachineRunsOutOfStock_ThenNotReady() {
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		handleMachine.produce();
		assertTrue(!handleMachine.isReady());
	}
	
	@Test
	void When_HandleMachineProduceAfterRefill_ThenCorrect() {
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		handleMachine.produce();
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		assertTrue(handleMachine.isReady());
		Product handle = handleMachine.produce();
		assertEquals("Handle", handle.getName());	
	}

	@Test
	void When_NotEnoughtStock_ThenFail() {
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		handleMachine.add(ironFactory.create());
		
		assertThrows(InsufficientComponentsException.class, () -> {
			handleMachine.produce();
		});
	}
	
	@Test
	void When_ProduceAFryingPan_ThenCorrect() {
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		Product handle = handleMachine.produce();
		
		ProductProducer panBodyMachine = new Machine(new PanBodyFactory(), PanBodyFormula.getInstance(), "Pan body");
		panBodyMachine.add(ironFactory.create());
		panBodyMachine.add(ironFactory.create());
		panBodyMachine.add(ironFactory.create());

		Product panBody = panBodyMachine.produce();
		
		ProductProducer fryingPanMachine = new Machine(new FryingPanFactory(), FryingPanFormula.getInstance(), "Frying pan");
		fryingPanMachine.add(panBody);
		fryingPanMachine.add(handle);
		Product fryingPan = fryingPanMachine.produce();
		
		assertEquals("Frying pan", fryingPan.getName());
		assertEquals(15, handle.getPrice());
		assertEquals(30, panBody.getPrice());
		assertEquals(45, fryingPan.getPrice());
	}
	
	@Test
	void When_Produce_ThenNotifyObservers() {
		
		WarehouseImpl warehouse = new WarehouseImpl();
		ProductProducer handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		ProductProducer panBodyMachine = new Machine(new PanBodyFactory(), PanBodyFormula.getInstance(), "Pan body");
		ProductProducer fryingPanMachine = new Machine(new FryingPanFactory(), FryingPanFormula.getInstance(), "Frying pan");
		
		((ProducerSubject)handleMachine).registerObserver(warehouse);
		((ProducerSubject)panBodyMachine).registerObserver(warehouse);
		((ProducerSubject)fryingPanMachine).registerObserver(warehouse);
		
		
		
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		Product handle = handleMachine.produce();
		assertTrue(warehouse.contains(handle.getName()));
		
		panBodyMachine.add(ironFactory.create());
		panBodyMachine.add(ironFactory.create());
		panBodyMachine.add(ironFactory.create());
		Product panBody = panBodyMachine.produce();
		assertTrue(warehouse.contains(panBody.getName()));

		
		fryingPanMachine.add(panBody);
		fryingPanMachine.add(handle);
		Product fryingPan = fryingPanMachine.produce();
		assertTrue(warehouse.contains(fryingPan.getName()));

		System.out.println(warehouse.getStockMap());
	}

}
