package centro_medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import pruebamysql.BaseDatos;

/**
 *
 * @author zerosk8
 */
public class PruebaMySQL {

    public static void prueba1(){
        try{
            // Inicializamos el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Conectamos con la base de datos
            String user = new String("paciente");
            String pass = new String("paciente");
            Connection conex = DriverManager.getConnection("jdbc:mysql://localhost/centroMedico",user,pass);

            System.out.println("Se ha conectado correctamente a la base de datos como \"root\".\n");

            // Se crea un Statement, para realizar la consulta
            Statement s = conex.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            // executeQuery no vale para insert, update, delete, etc..
            // solo para consultas
            ResultSet rs = s.executeQuery("Select * from pacientes");
            //ResultSet rs = s.executeQuery("Select * from agentes");

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

        }catch(Exception e){
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

    public static void prueba2(){
        BaseDatos bd = new BaseDatos();  //Creamos el objeto conectar a la base de datos y realizar las consultas
        ArrayList<ArrayList<String> > resultado = new ArrayList(); //Almacenara la tabla con los resultados
                                                                   //de la consulta

        String user = new String("paciente"); //Variables para almacenar el usuario y contraseña
        String pass = new String("paciente");

        //Conectamos con la base de datos "centroMedico", con el usuario "paciente" y contraseña "paciente"
        bd.ConectarBD("217.216.97.75", "centroMedico", user, pass);

        //Realizamos la consutla que nos muestre todo el contenido de la tabla "pacientes"
        resultado=bd.RealizarConsulta("Select * from pacientes");

        //Mostramos el resultado de la consulta, que consistira en recorrer un ArrayList de ArrayList
        //de String
        int cont=1; //Variable que va contando el numero de tupla
        for(Iterator i=resultado.iterator(); i.hasNext();){ //Iteramos sobre el ArrayList de ArrayList
            System.out.println("Tupla "+cont);

            ArrayList<String> aux=new ArrayList();  //Creamos una ArrayList de String auxiliar
            aux=(ArrayList<String>)i.next();    //Obtenemos en "aux" el ArrayList de String que contendra una tupla

            for(Iterator j=aux.iterator(); j.hasNext();){  //Para cada elemento de la tupla, lo mostramos
                System.out.print((String)j.next()+", ");
            }
            
            System.out.println();
            System.out.println();
            
            cont++;
        }

        //Cerramos la conexion a la base de datos
        bd.DesconectarBD();
    }

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
        // TODO code application logic here
        //prueba1();
     //   prueba2();
    //}

}
