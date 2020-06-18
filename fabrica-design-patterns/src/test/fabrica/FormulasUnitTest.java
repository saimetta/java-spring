package test.fabrica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.fabrica.components.Component;
import main.fabrica.components.Handle;
import main.fabrica.components.PanBody;
import main.fabrica.components.factories.BaseComponentFactory;
import main.fabrica.components.factories.IronFactory;
import main.fabrica.components.factories.PlasticFactory;
import main.fabrica.components.formulas.FryingPanFormula;
import main.fabrica.components.formulas.PanBodyFormula;


class FormulasUnitTest {
	
	private BaseComponentFactory ironFactory;
	private BaseComponentFactory plasticFactory;
	
	@BeforeEach
	void setUp() throws Exception {
		ironFactory = new IronFactory();
		plasticFactory = new PlasticFactory();
	}

	@Test
	void When_ValidateHandleForumla_ThenCorrect() {
		List<Component> input = ironFactory.create(3);
		assertTrue(PanBodyFormula.getInstance().hasRequiredComponents(input));
	}
	
	@Test
	void When_ValidateHandleForumlaWithLessThanRequired_ThenFail() {
		List<Component> input = ironFactory.create(2);
		assertFalse(PanBodyFormula.getInstance().hasRequiredComponents(input));
	}
	
	@Test
	void When_ValidateHandleProductForumla_ThenCorrect() {
		List<Component> input = new ArrayList<Component>();
		input.add(new PanBody());
		input.add(new Handle());
		assertTrue(FryingPanFormula.getInstance().hasRequiredComponents(input));
	}
	
	@Test
	void When_ValidateHandleProductForumlaWithLessThanRequired_ThenFail() {
		List<Component> input = new ArrayList<Component>();
		input.add(new PanBody());
		input.add(plasticFactory.create());
		assertFalse(FryingPanFormula.getInstance().hasRequiredComponents(input));
	}

}
