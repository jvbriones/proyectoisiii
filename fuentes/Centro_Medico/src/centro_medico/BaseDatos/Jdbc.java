
package centro_medico.BaseDatos;



import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 *
        Briones Rodríguez, Fco Javier
 		xoys@correo.ugr.es		Fecha: 21/06/2010
	De la Torre Dumont, Jose Pablo
 		erkt@correo.ugr.es

 */

public class Jdbc {

    private ResultSet resultado;
    private Connection miConexion;

    public void doConnection() {
        try {
            //Cargar el driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Crear conexion, IMPORTANTE ,la entrada DSN del OBCD ha de llamarse 'dbSAD'
            miConexion = DriverManager.getConnection("jdbc:odbc:dbSAD");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateCommand(String SqlCmd) {
        try {
            Statement sentencia = miConexion.createStatement();
            sentencia.executeUpdate(SqlCmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String EjecutarConsulta(String SqlCmd) throws SQLException {
        String consulta = null;
        try {
            //Hacemos la consulta
            Statement sentencia = miConexion.createStatement();
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
            Statement sentencia = miConexion.createStatement();
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

    public void CloseConnectionDB() {
        try {
            miConexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

