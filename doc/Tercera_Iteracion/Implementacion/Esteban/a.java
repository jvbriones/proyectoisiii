/**

prueba de la clase AES

*/

import CentroMedico.AES;
import java.io.*;
import java.util.*;

public class a{
	public static void main(String[] args) throws Exception {


		String mode = "encrypt";
		String text = "as";
		//String cadena = "XxO5RiI4J883iEFsiiYnHQ==";
		System.out.print("\nCadena encriptar: "+text+"\nCadena codificada: "+AES.encrypt(text)+"\n");
		//System.out.print("\nCadena desencriptar: "+cadena+"\nCadena decodificada: "+as.decrypt(cadena)+"\n");
		//as.decrypt(cadena);
	}
}


