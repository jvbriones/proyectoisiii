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
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */
public class personalBD {
    public boolean existePersonal(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT Dni FROM Personal WHERE Dni="+Dni;
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

    public void almacenarPersonal(Personal personal) {
        String dni=personal.getDni();
        String nombre=personal.getNombre();
        String apellidos=personal.getApellidos();
        String direccion=personal.getDireccion();
        String email=personal.getEmail();
        String contrasena=personal.getContrasena();
        String telefono=personal.getTelefono();
        Date fecNac=(Date) personal.getFechaNacimiento();
        String lugarNac=personal.getLugarNacimiento();
        String foto=personal.getFotografia();
        String tipo=personal.getTipoPersonal();

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Personal VALUES "+dni+","+nombre+","+apellidos+","+direccion+","+email+","+contrasena+","+telefono+","+fecNac+","+lugarNac+","+foto+","+tipo;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }
}
