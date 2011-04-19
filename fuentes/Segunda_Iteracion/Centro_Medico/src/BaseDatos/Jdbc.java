/*
 * Jdbc.java
 *
 * Informacion:
 * Realiza peticiones directamente al
 * servidor de la BD usando el conector JDBC
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package BaseDatos;

import java.sql.*;


/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */

public class Jdbc {

    private Connection conexion;    // almacena la conexion con la base de datos
    private ResultSet resultado;    // almacena el resultado de las consultas


    /* Conectar con la base de datos
     *
     * @param host: IP del servidor de la base de datos (sin incluir el protocolo "http://")
     * @param baseDatos: Nombre de la base de datos
     * @param usuario: Nombre del usuario que se quiere conectar a la base de datos
     * @param password: Contraseña para el usuario especificado
     *
     * Establece la conexion con la base de datos.
     *
     */

    public void doConnection(String Host,String BaseDatos,String Usuario,String Password){
        try {
            //Cargar el driver para Bases de Datos MySql
            Class.forName("com.mysql.jdbc.Driver");
            //Establecemos la conexion con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://"+Host+"/"+BaseDatos,Usuario,Password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Realizar comandos que MODIFIQUEN el contenido de la BD (INSERT,UPDATE,DELETE..)
     *
     * @query: Comando que se quiere realizar a la base de datos
     *
     * Esta funcion devolverá error en si no se puede realizar la operación
     *
     */

    public void consultaUpdate(String SqlCmd) { 
        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(SqlCmd);
            //st.close(); //Hay que cerrar el statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Realizar comandos consultores tipo Select
     *
     * @query: Consulta que se quiere realizar a la base de datos
     * @return resultado: ResulSet con el resultado de la consulta
     *
     * Esta funcion devolverá error en si no se puede realizar la operación
     *
     */
    
    public ResultSet consultaSelect(String SqlCmd) throws SQLException {
        try {
            //Ejecutamos la consulta y obtenemos el resultado en el ResultSet 'resultado'
            Statement st = conexion.createStatement();
            resultado = st.executeQuery(SqlCmd);
            //st.close(); //Hay que cerrar el statement
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /* Desconectar de la base de datos
     *
     * Cerramos la conexion con la base de datos
     *
     */

    public void closeConnection() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

