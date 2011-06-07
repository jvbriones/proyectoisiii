/**

prueba de la clase AES

*/

import CentroMedico.AES;
import java.io.*;
import java.util.*;

public class a{
	public static void main(String[] args) throws Exception {

/*
		String mode = "encrypt";
		String text = "as";
		String cadena = "LJYejAf7fUE8a9ZW5t+1vQ==";
		System.out.print("\nCadena encriptar: "+text+"\nCadena codificada: "+AES.encrypt(text)+"\n");
		System.out.print("\nCadena desencriptar: "+cadena+"\nCadena decodificada: "+AES.decrypt(cadena)+"\n");
		//as.decrypt(cadena);
	*/	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String text = "as";
		String cad;
		Boolean salir=false;
		System.out.println("**********************************************************************");
        System.out.println("**** Programa para obtener una clave cifrada usando AES 128 bits.*****");
        while(!salir){
			System.out.println("\n\tOpciones del programa:\n\n\t\t[1]: Imprimir clave predefinida\n\t\t[2]: Obtener clave introducia\n\t\t[0]: Salir\n\n");
			System.out.print("Elige: ");
			 cad = in.readLine();
			
			switch (Integer.parseInt(cad)){
				case 1:
					System.out.print("\nCadena encriptar: "+text+"\nCadena codificada: "+AES.encrypt(text)+"\n");
					System.out.println("_______________________________");
					break;
				case 2:
				    System.out.print("\nIntroduce una clave: ");
				    cad = in.readLine();
				    System.out.print("\nCadena encriptar: "+cad+"\nCadena codificada: "+AES.encrypt(cad)+"\n");
				    System.out.println("_______________________________");
				    break;
				case 0:
				    salir=true;
				    System.out.println("Saliendo...");
				    break;
			};
			
		}
        
		

		
	}
}


