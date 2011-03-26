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

package centro_medico.BaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version     datos de la versión (numero y fecha)
 * @author      Sub_Equipo1
 */

public class Jdbc {

    private ResultSet resultado;
    private Connection conexion;     // almacena la conexion con la base de datos


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

    public void doConnection(String host,String baseDatos,String usuario,String password){
        try {
            //Cargar el driver para Bases de Datos MySql
            Class.forName("com.mysql.jdbc.Driver");
            //Establecemos la conexion con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+baseDatos,usuario,password);

        } catch (Exception e) {
            e.printStackTrace();
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


    public void UpdateCommand(String SqlCmd) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(SqlCmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String EjecutarConsulta(String SqlCmd) throws SQLException {
        String consulta = null;
        try {
            //Hacemos la consulta
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(SqlCmd);
            while(resultado.next())
            {
                consulta = resultado.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consulta;
    }

    public List EjecutarConsultaID(String SqlCmd) throws SQLException {

         List listaId = new ArrayList();

        try {
            //Hacemos la consulta
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(SqlCmd);
            while(resultado.next())
            {
                listaId.add(resultado.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace(); ///POR AQUI PUEDE PETAR///
        }
        return listaId;
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

