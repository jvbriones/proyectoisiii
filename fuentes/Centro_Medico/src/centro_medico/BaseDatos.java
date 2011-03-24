/*
* @BaseDatos.java   1.0 18/03/2011
*
* Copyright (c) Proyecto ISIII
*/


/**La linea de codigo de justo debajo hay que sustituirla por el nombre del paquete
 * donde se meta este fichero .java
*/
package pruebamysql; //Cambia "pruebamysql" por el nombre de tu paquete

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
* Esta clase es la que se emplea en la capa de base de datos de la aplicacion.
* Mediante esta clase podemos conectarnos a la base de datos y realizar consultas SQL
* con la base de datos.
*
* @version  1.0 18/03/2011
* @author   Alejandro Mesa Rodriguez
*/

public class BaseDatos {
    /* Todo el codigo que este relacionado con la interaccion de la base de datos
     * hay que meterlo entre try-catch, sino no se puede compilar.
     */

    /** Variable que almacena la conexion con la base de datos */
    private Connection conexion;

    /* Constructor por defecto
     *
     * Construye el objeto
     *
     */
    public BaseDatos(){
        try{
            //Elegimos el driver para base de datos MySQL
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){
        }
    }

    /* Constructor por parámetros
     *
     * @param host: IP del servidor de la base de datos (sin incluir el protocolo "http://")
     * @param baseDatos: Nombre de la base de datos
     * @param usuario: Nombre del usuario que se quiere conectar a la base de datos
     * @param password: Contraseña para el usuario especificado
     *
     * Construye el objeto y establece la conexion con la base de datos
     *
     */
    public BaseDatos(String host,String baseDatos,String usuario,String password){
        try{
            //Elegimos el driver para base de datos MySQL
            Class.forName("com.mysql.jdbc.Driver");

            //Establecemos la conexion con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+baseDatos,usuario,password);
        }
        catch(Exception e){
        }
    }

    /* Conectar con la base de datos
     *
     * @param host: IP del servidor de la base de datos (sin incluir el protocolo "http://")
     * @param baseDatos: Nombre de la base de datos
     * @param usuario: Nombre del usuario que se quiere conectar a la base de datos
     * @param password: Contraseña para el usuario especificado
     *
     * Establece la conexion con la base de datos. Util en caso de que no se haya establecido
     * antes.
     *
     */
    public void ConectarBD(String host,String baseDatos,String usuario,String password){
        if(conexion==null){
            try{
                //Establecemos la conexion con la base de datos
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+baseDatos,usuario,password);
            }
            catch(Exception e){
            }
        }
    }

    /* Realizar una consulta generica (cualquier consulta tipo Select de MySQL)
     *
     * @query: Consulta que se quiere hacer a la base de datos
     *
     * @return Matriz de resultados que contiene las tuplas con los resultados de la consulta
     *
     * Esta funcion unicamente acepta consultas del tipo "Select"
     * y devuelve un ArrayList de ArrayList de String que contiene toda la tabla
     * que obtenemos como resultado de realizar la consulta "query".
     * Se puede entender como que devuelve una matriz de String, pero representada como
     * un ArrayList de ArrayList de String.
     *
     */
    public ArrayList RealizarConsulta(String query){
        ArrayList<ArrayList<String> > matriz = new ArrayList(); //Matriz que contendra las tuplas
        int numeroCampos;                                       //Contendra el numero de campos de una tupla
        
        try{
            //Creamos el statement para pasarle y ejecutar la consulta SQL
            Statement st = conexion.createStatement();

            //Ejecutamos la consulta y obtenemos el resultado en el resultset
            ResultSet rs = st.executeQuery(query);
            //Aqui obtenemos los metadatos del resultset
            //Esto se hace para obtener valores como numero de columnas de tupla (numero de campos), etc...
            ResultSetMetaData rsmd = rs.getMetaData();

            //Aqui obtenemos el numero de columnas de una tupla
            numeroCampos = rsmd.getColumnCount();

            //Recorremos cada tupla resultante de ejecutar la consulta en "rs"
            while(rs.next()){
                ArrayList<String> tupla=new ArrayList();    //Creamos un ArrayList "tupla"
                
                for(int i=1; i<=numeroCampos; i++){     //Damos al ArrayList "tupla" con el contenido de cada campo
                    tupla.add(rs.getString(i));
                }

                matriz.add(tupla);              //Añadimos el ArrayList "tupla" al ArrayList "matriz"
            }

            st.close(); //Hay que cerrar el statement
        }
        catch(Exception e){
        }
        
        return matriz;
    }

    /* Desconectar de la base de datos
     *
     * Cerramos la conexion con la base de datos
     *
     */
    public void DesconectarBD(){
        try{
            conexion.close(); //Cerramos la conexion con la base de datos
        }
        catch(Exception e){}
    }

}
