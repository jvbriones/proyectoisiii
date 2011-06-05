/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroMedico;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;

/**
 * Clase para encriptar/desencriptar string mediante el algoritmo AES de 128 bits
 * 
 * @author Esteban Dorado Roldán
 * @date 
 */
public class AES {
    
    public static SecretKeySpec getKeySpec() throws IOException, NoSuchAlgorithmException {
	byte[] bytes = new byte[16];
	File f = new File("keygen");
	SecretKey key = null;
	SecretKeySpec spec = null;
	if (f.exists()) {
	  new FileInputStream(f).read(bytes);
	} else {
	   KeyGenerator kgen = KeyGenerator.getInstance("AES");
	   kgen.init(128);
	   key = kgen.generateKey();
	   bytes = key.getEncoded();
	   new FileOutputStream(f).write(bytes);
	}
	spec = new SecretKeySpec(bytes,"AES");
	return spec;
  }
  public static String encrypt(String text) throws Exception {
    SecretKeySpec spec = getKeySpec();
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, spec);
    //System.out.print("La clavea a encriptar es: "+ text +"\n Y obtenemos: ");
    //System.out.println(Base64Coder.encode(cipher.doFinal(text.getBytes())));
    return Base64Coder.encodeLines(cipher.doFinal(text.getBytes()));
  }
  public static String decrypt(String text) throws Exception {
	SecretKeySpec spec = getKeySpec();
	Cipher cipher = Cipher.getInstance("AES");
	cipher.init(Cipher.DECRYPT_MODE, spec);
	//System.out.print("La clavea desencriptar es: "+ text +"\n Y obtenemos: ");
        //System.out.println(new String(cipher.doFinal(Base64Coder.decode(text))));
        String s = new String(cipher.doFinal(Base64Coder.decode(text)));
        return s;
  }
    
}
