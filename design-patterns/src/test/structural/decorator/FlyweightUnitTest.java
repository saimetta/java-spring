package test.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.structural.flyweight.CarFactory;
import main.structural.flyweight.RaceCar;
import main.structural.flyweight.RaceCarClient;

class FlyweightUnitTest {

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_CompareTwoMidgets_ThenEquals() {
		RaceCar midgetA = CarFactory.getRaceCar("Midget"); 
		RaceCar midgetB = CarFactory.getRaceCar("Midget");
		assertEquals(midgetA, midgetB);
	}
	
	@Test
	void When_CompareTwoRaceCarClient_ThenNotEquals() {
		RaceCarClient midgetA = new RaceCarClient("Midget");
		RaceCarClient midgetB = new RaceCarClient("Midget");
		assertNotEquals(midgetA, midgetB);
	}
	
	@Test
	void When_MoveTwoCars_ThenCorrect() {
		RaceCarClient midgetA = new RaceCarClient("Midget");
		RaceCarClient midgetB = new RaceCarClient("Midget");
		
		midgetA.moveCar(10, 25);
		midgetB.moveCar(10, 55);
		
		assertEquals(25, midgetA.getCurrentY());
		assertEquals(55, midgetB.getCurrentY());
	}

}
