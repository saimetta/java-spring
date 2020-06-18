package main.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AesEncryptionStrategy implements EncryptionStrategy{
   @Override
    public String encryptData(String plaintext) {
       System.out.println("-------Encrypting data using AES algorithm-------");
       try {
           KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
           keyGenerator.init(128);
           SecretKey secretKey = keyGenerator.generateKey();
           byte[] plaintTextByteArray = plaintext.getBytes("UTF8");
           Cipher cipher = Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           byte[] cipherText = cipher.doFinal(plaintTextByteArray);
           List<String> encrypted = new ArrayList<String>();
           for (int i = 0; i < cipherText.length; i++) {
        	   encrypted.add(cipherText[i] + " ");
           }
           return String.join("", encrypted);
       }
       catch(Exception ex){
           ex.printStackTrace();
           return "";
       }
   }
}