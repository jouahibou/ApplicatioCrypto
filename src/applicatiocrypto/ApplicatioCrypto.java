/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicatiocrypto;

import java.io.File;
import java.security.Key;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;

/**
 *
 * @author Lenovo
 */
public class ApplicatioCrypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    
         CryptoSymUtil util = new CryptoSymUtil();
          SecretKey key = util.genKey("AES", 128);
          
          
      JFileChooser jfc = new JFileChooser();
       int  option1 = jfc.showOpenDialog(jfc);
       
        if(option1 == JFileChooser.APPROVE_OPTION){
            String files = jfc.getSelectedFile().getAbsolutePath();
             util.encrypt(key, files);
             util.decrypt(key,files);
        }
          
          
          
       // System.out.println(key.getEncoded().length);
        //util.encrypt(key, "C:\\salla/jouahibou.txt");
         //String encoding1 = Base64.getEncoder().encodeToString(key.getEncoded());
        //System.out.println(encoding1);
        //util.decrypt(key, "C:\\salla/jouahibou.txt.cry");
         

} }
