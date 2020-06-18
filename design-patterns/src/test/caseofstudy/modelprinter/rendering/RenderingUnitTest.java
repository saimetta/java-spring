package test.caseofstudy.modelprinter.rendering;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.caseofstudy.modelprinter.documentstructure.Circle;
import main.caseofstudy.modelprinter.rendering.BaseObjectRenderer;
import main.caseofstudy.modelprinter.rendering.DetailedRenderer;
import main.caseofstudy.modelprinter.rendering.QuickRenderer;
import main.caseofstudy.modelprinter.rendering.RenderSystemImpl;
import main.caseofstudy.modelprinter.rendering.RenderingSystem;

class RenderingUnitTest {

	@Test
	void When_SwitchRenderStrategy_ThenCorrect() {
		
		Circle circle = new Circle("Circle");
		BaseObjectRenderer detailedRenderer = new DetailedRenderer();
		BaseObjectRenderer quickRenderer = new QuickRenderer();
		
		RenderingSystem renderer = new RenderSystemImpl();
		
		renderer.setRenderer(quickRenderer);
		assertEquals("Quick Render:Circle", renderer.render(circle));
		
		renderer.setRenderer(detailedRenderer);
		assertEquals("Detailed Render:Circle", renderer.render(circle));
	}

}
