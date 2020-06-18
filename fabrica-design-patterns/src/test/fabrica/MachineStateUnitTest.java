package test.fabrica;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.HandleFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PlasticFactory;
import main.fabrica.components.formulas.HandleFormula;
import main.fabrica.machines.InsufficientComponentsException;
import main.fabrica.machines.Machine;
import main.fabrica.machines.ProducerCompleteException;
import main.fabrica.machines.ProductProducer;

class MachineStateUnitTest {

	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory;
	private ProductProducer handleMachine;
	
	@BeforeEach
	void setUp() throws Exception {
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
		handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
	}

	@Test
	void When_MachineIsNotReady_ThenAddingIsAllowed() {
		handleMachine.add(ironFactory.create());
		assertTrue(!handleMachine.isReady());
		handleMachine.add(plasticFactory.create());
		assertTrue(handleMachine.isReady());
	}
	
	@Test
	void When_MachineIsRady_ThenAddingIsNotAllowed() {
		handleMachine.add(ironFactory.create());
		handleMachine.add(plasticFactory.create());
		assertThrows(ProducerCompleteException.class, () -> {
			handleMachine.add(plasticFactory.create());
		});
	}
	
	@Test
	void When_MachineIsNotReady_ThenProduceIsNotAllowed() {
		handleMachine.add(ironFactory.create());
		assertThrows(InsufficientComponentsException.class, () -> {
			handleMachine.produce();
		});
	}
}
