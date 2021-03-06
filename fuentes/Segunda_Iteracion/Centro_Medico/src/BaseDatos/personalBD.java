/*
 * personalBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con el personal.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package BaseDatos;

import CentroMedico.Personal;
import java.sql.*;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class personalBD {

    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

    public boolean existePersonal(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT Dni FROM Personal WHERE Dni='"+Dni+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            existe=true;
        }
        else {
            existe=false;
        }
        conexion.closeConnection();
        return existe;
    }

    // Modificado con respecto al diseño
    public void almacenarPersonal(Personal personal) {
        String dni=personal.getDNI();
        String nombre=personal.getNombre();
        String apellidos=personal.getApellidos();
        String direccion=personal.getDireccion();
        String email=personal.getEmail();
        String contrasena=personal.getContrasenia();
        String telefono=personal.getTelefono();
        Date fecNac=(Date) personal.getFecNac();
        String lugarNac=personal.getLugarNac();
        String foto=personal.getFoto();
        String tipo=personal.getTipoPersonal();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);

        // El diseño no se corresponde con al modelo de la base de datos
        // Hay que ejecutar estas 2 sentencias
        String Consulta = "INSERT INTO Usuarios VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+email+"','"+contrasena+"','"+telefono+"',"+fecNac+",'"+lugarNac+"','"+foto+"','"+tipo+"')";
        conexion.consultaUpdate(Consulta);

        Consulta = "INSERT INTO Personal VALUES ('"+dni+"','"+tipo+"')";
        conexion.consultaUpdate(Consulta);

        if(tipo.equals("Radiologo")){
            Consulta = "INSERT INTO Radiologos VALUES ('"+dni+"')";
            conexion.consultaUpdate(Consulta);
        }

        conexion.closeConnection();

    }
}
