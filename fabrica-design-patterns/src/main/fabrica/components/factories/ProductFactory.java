package main.fabrica.components.factories;

import java.util.List;

import main.fabrica.components.Component;
import main.fabrica.components.Product;

public interface ProductFactory {
	Product create(List<Component> components);
}
