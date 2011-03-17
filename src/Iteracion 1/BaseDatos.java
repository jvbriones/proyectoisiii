/**La linea de codigo de justo debajo hay que sustituirla por el nombre del paquete
 * donde se meta este fichero .java
*/
package pruebamysql; //Cambia "pruebamysql" por el nombre de tu paquete

import java.sql.*;

public class BaseDatos {
    private Connection conexion;

    /* Constructor por defecto
     *
     * Construye el objeto
     *
     */
    public BaseDatos(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
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
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+baseDatos,usuario,password);
        }
        catch(Exception e){}
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
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+baseDatos,usuario,password);
            }
            catch(Exception e){}
        }
    }

    /* Realizar una consulta (tipo Select de MySQL)
     *
     * @query: Consulta que se quiere hacer a la base de datos
     *
     * @return Devuelve true, si se ha realizado con exito la consulta, y false
     * en caso contrario
     *
     * ESTA FUNCION HAY QUE CAMBIARLA Y ACABARLA!
     *
     */
    public boolean RealizarConsulta(String query){
        boolean exito=false;

        try{
            Statement st = conexion.createStatement();
            
            ResultSet rs = st.executeQuery(query);

            //Aqui trabajamos con el resultado de la consulta
            //Esto hay que acabarlo

            rs.close();

            exito=true;
        }
        catch(Exception e){}

        return exito;
    }

    /* Desconectar de la base de datos
     *
     * Cerramos la conexion con la base de datos
     *
     */
    public void DesconectarBD(){
        try{
            conexion.close();
        }
        catch(Exception e){}
    }

}
