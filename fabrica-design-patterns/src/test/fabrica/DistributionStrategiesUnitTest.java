package test.fabrica;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.HandleFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PanBodyFactory;
import main.fabrica.components.factories.PlasticFactory;
import main.fabrica.components.formulas.HandleFormula;
import main.fabrica.components.formulas.PanBodyFormula;
import main.fabrica.machines.Machine;
import main.fabrica.machines.ProductProducer;
import main.fabrica.strategies.BalancedStrategy;
import main.fabrica.strategies.GreedyStrategy;
import main.fabrica.strategies.SuccessfulStrategy;

class DistributionStrategiesUnitTest {

	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory;
	private ProductProducer handleMachine;
	private ProductProducer panBodyMachine;
	
	@BeforeEach
	void setUp() throws Exception {
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
		handleMachine = new Machine(new HandleFactory(), HandleFormula.getInstance(), "Handle");
		panBodyMachine = new Machine(new PanBodyFactory(), PanBodyFormula.getInstance(), "Pan body");
	}

	@Test
	void When_GreedyStrategyAndTwoProducer_ThenCorrect() {
		
		
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(handleMachine);
		producers.add(panBodyMachine);
		
		
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		assertTrue(!handleMachine.isReady());
		GreedyStrategy.getInstance().distribute(plasticFactory.create(), producers);
		assertTrue(handleMachine.isReady());
		assertTrue(!panBodyMachine.isReady());
		
	}
	
	@Test
	void When_GreedyStrategyOrderAssignationImportance_ThenCorrect() {
		
		
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(panBodyMachine);
		producers.add(handleMachine);
		
		
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		assertTrue(panBodyMachine.isReady());
		assertTrue(!handleMachine.isReady());
		
	}
	
	
	@Test
	void When_GreedyStrategyStockAssignation_ThenCorrect() {
		
		
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(panBodyMachine);
		producers.add(handleMachine);
		
		
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		GreedyStrategy.getInstance().distribute(plasticFactory.create(), producers);
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);
		GreedyStrategy.getInstance().distribute(ironFactory.create(), producers);

		assertTrue(panBodyMachine.isReady());
		assertTrue(!handleMachine.isReady());
		
	}
		
	@Test
	void When_BalancedStrategyDistributionBasedOnProduction_ThenCorrect() {
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(panBodyMachine);
		producers.add(handleMachine);
		
		
		BalancedStrategy.getInstance().distribute(ironFactory.create(), producers);
		BalancedStrategy.getInstance().distribute(plasticFactory.create(), producers);
		BalancedStrategy.getInstance().distribute(ironFactory.create(), producers);
		BalancedStrategy.getInstance().distribute(ironFactory.create(), producers);

		assertTrue(panBodyMachine.isReady());
		panBodyMachine.produce();
		BalancedStrategy.getInstance().distribute(ironFactory.create(), producers);
		assertTrue(handleMachine.isReady());
	}
	
	
	@Test
	void When_SuccessfulStrategyyDistribution_ThenCorrect() {
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(handleMachine);
		
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		SuccessfulStrategy.getInstance().distribute(plasticFactory.create(), producers);
		handleMachine.produce();
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		SuccessfulStrategy.getInstance().distribute(plasticFactory.create(), producers);
		handleMachine.produce();
		
		producers.add(panBodyMachine);
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		SuccessfulStrategy.getInstance().distribute(plasticFactory.create(), producers);
		assertTrue(handleMachine.isReady());
	}
	
	@Test
	void When_ProductionStrategyyDistribution_ThenCorrect() {
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(handleMachine);		
		SuccessfulStrategy.getInstance().distribute(plasticFactory.create(), producers);
		producers.add(panBodyMachine);	
		
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		assertTrue(handleMachine.isReady());
	}
	
	@Test
	void When_ProductionStrategyyDistributionInverted_ThenCorrect() {
		List<ProductProducer> producers = new ArrayList<ProductProducer>();
		producers.add(panBodyMachine);		
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		
		producers.add(handleMachine);	
		SuccessfulStrategy.getInstance().distribute(plasticFactory.create(), producers);
		
		SuccessfulStrategy.getInstance().distribute(ironFactory.create(), producers);
		assertTrue(panBodyMachine.isReady());
	}
	

}
