package main.behavioral.strategy;
public class Encryptor {
    
	private EncryptionStrategy strategy;
    
    public Encryptor(EncryptionStrategy strategy){
        this.strategy = strategy;
    }
    public String encrypt(String plainText){
        return strategy.encryptData(plainText);
    }
    
    public void setEncryptionStrategy(EncryptionStrategy strategy) {
    	this.strategy = strategy;
    }
}