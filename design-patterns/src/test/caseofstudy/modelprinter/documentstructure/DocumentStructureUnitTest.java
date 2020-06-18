package test.caseofstudy.modelprinter.documentstructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.caseofstudy.modelprinter.documentstructure.BaseObject;
import main.caseofstudy.modelprinter.documentstructure.Circle;
import main.caseofstudy.modelprinter.documentstructure.CompositeImpl;
import main.caseofstudy.modelprinter.documentstructure.Square;

class DocumentStructureUnitTest {

	@Test
	void When_PrintSimpleObject_ThenCorrect() {
		assertEquals("Circle", new Circle("Circle").print());
	}
	
	@Test
	void When_PrintComplexObject_ThenCorrect() {
		BaseObject circle = new Circle("Circle");
		BaseObject square = new Square("Square");
		CompositeImpl figure = new CompositeImpl("Figure");
		figure.addComponent(circle);
		figure.addComponent(square);
		assertEquals("Figure Circle Square", figure.print());
	}
	
	
	@Test
	void When_PrintComplexObjectComposedByAnotherComplexObject_ThenCorrect() {
		BaseObject circle = new Circle("Circle");
		BaseObject square = new Square("Square");
		CompositeImpl figure = new CompositeImpl("Figure");
		CompositeImpl twoCircles = new CompositeImpl("TwoCircles");
		twoCircles.addComponent(circle);
		twoCircles.addComponent(circle);
		
		figure.addComponent(circle);
		figure.addComponent(square);
		figure.addComponent(twoCircles);
		assertEquals("Figure Circle Square TwoCircles Circle Circle", figure.print());
	}
	

}
