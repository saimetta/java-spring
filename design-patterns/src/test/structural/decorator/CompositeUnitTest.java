package test.structural.decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.structural.composite.CatalogComponent;
import main.structural.composite.Product;
import main.structural.composite.ProductCatalog;

class CompositeUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void When_ProductTriesToAddComponent_ThenFail() {
		assertThrows(UnsupportedOperationException.class, () -> { 
			CatalogComponent componentA = new Product("Test A", 10);
			CatalogComponent componentB = new Product("Test B", 10);
			componentA.add(componentB);
		});
	}

	@Test
	void When_CreateCatalog_ThenCorrect() {
		CatalogComponent tShirt = new Product("TShirt", 10.99);
		CatalogComponent trousers = new Product("Trousers", 10.99);
		CatalogComponent mensCatalog = new ProductCatalog("Men's catalog");
		mensCatalog.add(tShirt);
		mensCatalog.add(trousers);
		
		assertEquals("Product name: TShirt Price: 10.99 - Product name: Trousers Price: 10.99", mensCatalog.print());
	}
	
	@Test
	void When_CreateNestedProducCatalog_ThenCorrect() {
		CatalogComponent tShirt = new Product("TShirt", 10.99);
		CatalogComponent trousers = new Product("Trousers", 10.99);
		CatalogComponent mensCatalog = new ProductCatalog("Men's catalog");
		CatalogComponent dress = new Product("Dress", 30.99);
		CatalogComponent vNeckTshirt = new Product("vNeckTshirt", 8.99);
		CatalogComponent womenCatalog = new ProductCatalog("Women's catalog");
		mensCatalog.add(tShirt);
		mensCatalog.add(trousers);
		womenCatalog.add(vNeckTshirt);
		womenCatalog.add(dress);
		CatalogComponent clothes = new ProductCatalog("Clothes");
		clothes.add(mensCatalog);
		clothes.add(womenCatalog);
		
		assertEquals("Product name: TShirt Price: 10.99 - Product name: Trousers Price: 10.99 - Product name: vNeckTshirt Price: 8.99 - Product name: Dress Price: 30.99", clothes.print());
	}

}
