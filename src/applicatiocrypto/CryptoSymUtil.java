/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicatiocrypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


/**
 *
 * @author Lenovo
 */
public class CryptoSymUtil  {
    
   
    public final String algotransform="AES/CBC/PKCS5Padding";
    public final byte [] IV="AseizeCaracteres".getBytes();
    public final String kdf="PBKDF2WithHmacSHA1";
    public final String keyAlgo="AES";
    
 
     public void encrypt(Key k, String inputFile) {
 try {
    Cipher cif=Cipher.getInstance(algotransform);
    cif.init(Cipher.ENCRYPT_MODE, k, new IvParameterSpec(IV));
    FileInputStream fis = new FileInputStream(inputFile);
    CipherInputStream cis = new CipherInputStream(fis, cif);
    FileOutputStream fos = new FileOutputStream(inputFile+".cry");
    byte[] buffer = new byte[256];
    int nbBytesLu=0;
    while ((nbBytesLu = cis.read(buffer)) != -1){
         fos.write(buffer, 0, nbBytesLu);
   }
   fis.close();
   fos.close();
   
   System.out.println("encryptioneed");
   } catch (Exception ex) {
    Logger.getLogger(CryptoSymUtil.class.getName()).log(Level.SEVERE, null, ex);
   }
  }
 
    public void decrypt(Key k, String inputFile) {
 try {
 Cipher cif=Cipher.getInstance(algotransform);
 cif.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(IV));
 FileInputStream fis = new FileInputStream(inputFile);
 FileOutputStream fos = new FileOutputStream(inputFile.substring(0,
 inputFile.length()-4));
 CipherOutputStream cos = new CipherOutputStream(fos, cif);
 
 byte[] buffer = new byte[256];
 int nbBytesLu=0;
 while ((nbBytesLu = fis.read(buffer)) != -1){
 cos.write(buffer, 0, nbBytesLu);
 }
 fis.close();
 fos.close();
 
 System.out.println("Decryptioneed!!!!");
 
 } catch (Exception ex) {
 Logger.getLogger(CryptoSymUtil.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
     public SecretKey genKey(String algo, int keySize) {
         KeyGenerator keyGen;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            SecretKey key = keyGen.generateKey();
            return key;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CryptoSymUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    
    
   
    
}

    
    

   