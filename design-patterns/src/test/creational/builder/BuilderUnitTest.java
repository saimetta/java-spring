package test.creational.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.creational.builder.Car;
import main.creational.builder.CarBuilderDirector;
import main.creational.builder.CompactCarBuilder;
import main.creational.builder.SportCarBuilder;

class BuilderUnitTest {

	@Test
	void When_BuildSportCar_ThenCorrect() {
		
		CarBuilderDirector director = new CarBuilderDirector(new SportCarBuilder());
		
		director.construct("black");
		Car blackSportCar = director.getResult();
		
		assertEquals("Engine: V8 chassis: racing chassis color: black", blackSportCar.toString());

	}
	
	@Test
	void When_BuildCompactCar_ThenCorrect() {
		
		CarBuilderDirector director = new CarBuilderDirector(new CompactCarBuilder());
		
		director.construct("black");
		Car blackCompactCar = director.getResult();
		
		assertEquals("Engine: 1.0 engine chassis: two doors chassis color: black", blackCompactCar.toString());

	}

}
