package test.creational.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.creational.singleton.Singleton;

class SingletonUnitTest {

	@Test
	void When_GetMultipleInstances_ThenAllTheSame() {
		int hashcode1 = Singleton.getInstance().getHashCode();
		int hashcode2 = Singleton.getInstance().getHashCode();
		int hashcode3 = Singleton.getInstance().getHashCode();
		
		assertEquals(hashcode1, hashcode2);
		assertEquals(hashcode2, hashcode3);
		assertEquals(hashcode3, Singleton.getInstance().getHashCode());
		assertEquals(hashcode3, Singleton.getInstance().hashCode());
		
	}

}
