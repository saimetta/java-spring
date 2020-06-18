package test.behavioral.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.behavioral.strategy.AesEncryptionStrategy;
import main.behavioral.strategy.BlowfishEncryptionStrategy;
import main.behavioral.strategy.Encryptor;

class StrategyUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_SwitchEncryptionStrategy_ThenCorrect() {
		Encryptor encryptor = new Encryptor(new AesEncryptionStrategy());
		System.out.println(encryptor.encrypt("Hello world"));
		encryptor.setEncryptionStrategy(new BlowfishEncryptionStrategy());
		System.out.println(encryptor.encrypt("Hello world"));
	}

}
