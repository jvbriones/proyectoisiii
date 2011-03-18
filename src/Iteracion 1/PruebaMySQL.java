/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author zerosk8
 */
public class PruebaMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            // Inicializamos el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Conectamos con la base de datos
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/centroMedico","root","zerosk8");

            // Se crea un Statement, para realizar la consulta
            Statement s = conex.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            // executeQuery no vale para insert, update, delete, etc..
            // solo para consultas
            ResultSet rs = s.executeQuery("Select * from pacientes");

             while (rs.next()){
                 System.out.println("DNI: "+rs.getString("DNI"));
                 System.out.println("nombre: "+rs.getString("nombre"));
                 System.out.println("Apellidos: "+rs.getString("apellidos"));
                 System.out.println();
             }

            //Cerramos el Statement
            s.close();

            //Cerramos la conexion a la BD
            conex.close();


            System.out.println("Se ha conectado correctamente a la base de datos como \"root\".");
        }catch(Exception e){
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

}
