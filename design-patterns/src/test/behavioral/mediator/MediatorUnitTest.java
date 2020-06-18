package test.behavioral.mediator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.mediator.ArmedUnit;
import main.behavioral.mediator.Commander;
import main.behavioral.mediator.Mediator;
import main.behavioral.mediator.SoldierUnit;
import main.behavioral.mediator.TankUnit;

class MediatorUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_UnitAttack_ThenOtherUnitCeaseAttack() {
		Mediator commander = new Commander();
		ArmedUnit tankUnit = new TankUnit(commander);
		ArmedUnit soldierUnit = new SoldierUnit(commander);
		commander.registerArmedUnits(soldierUnit, tankUnit);
		
		commander.startAttack(tankUnit);
		assertFalse(commander.canAttack());
		commander.ceaseAttack(tankUnit);
		assertTrue(commander.canAttack());
		commander.startAttack(soldierUnit);
		commander.startAttack(tankUnit);
	}

}
