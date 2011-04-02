/*
 * usuarioBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los usuarios.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package CentroMedico;

import BaseDatos.*;
import java.sql.*;
import java.awt.*;

/**
 * @version     v1.0    01/04/2011
 * @author      Sub_Equipo1
 */
public class usuarioBD {

    public Boolean validacion(String Dni, String Pass) throws SQLException {

        Boolean acceso;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT Dni, Contrasena FROM Usuarios WHERE Dni="+Dni+", and Contrasena="+Pass;
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            acceso=true;
        }
        else {
            acceso=false;
        }
        conexion.closeConnection();
        return acceso;
    }

    public Usuario obtenerUsuario(String Dni) throws SQLException {

        Usuario user;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Usuarios WHERE Dni="+Dni;
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            String nombre=rs.getString("Nombre");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasena");
            String telefono=rs.getString("Telefono");
            Date fecNac=rs.getDate("FechaNacimiento");
            String lugarNac=rs.getString("LugarNacimiento");
            Image foto=null;//rs.get.getImage("Fotografia");
            String tipo=rs.getString("TipoUsuario");

            user = new Usuario(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto, tipo);
        }
        else{
            user= null;
        }
        conexion.closeConnection();
        return user;
    }
}
