package test.structural.decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.structural.decorator.FlowerBouquet;
import main.structural.decorator.FlowerBouquetDecorator;
import main.structural.decorator.OrchidBouquet;
import main.structural.decorator.PaperWrapper;
import main.structural.decorator.RibbonBow;

class DecoratorUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_BasicBouquet_ThenCorrect() {
		FlowerBouquet bouquet = new OrchidBouquet();
		assertEquals("Orchid bouquet", bouquet.getDescription());
		assertEquals(29.0, bouquet.cost());
	}
	
	@Test
	void When_BasicBouquetPaperWrapped_ThenCorrect() {
		FlowerBouquet bouquet = new OrchidBouquet();
		bouquet = new PaperWrapper(bouquet);
		assertEquals("Orchid bouquet, paper wrap", bouquet.getDescription());
		assertEquals(32.0, bouquet.cost());
	}
	
	@Test
	void When_BasicBouquetDoublePaperWrapWithRibbon_ThenCorrect() {
		FlowerBouquet bouquet = new OrchidBouquet();
		bouquet = new PaperWrapper(bouquet);
		bouquet = new PaperWrapper(bouquet);
		bouquet = new RibbonBow(bouquet);
		assertEquals("Orchid bouquet, paper wrap, paper wrap, ribbon bow", bouquet.getDescription());
		assertEquals(41.5, bouquet.cost());
	}

}
