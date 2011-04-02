/*
 * PacBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los pacientes.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package CentroMedico;

import BaseDatos.*;
import java.sql.*;


/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */
public class PacBD {


    public Boolean existePaciente(String Dni) throws SQLException {
        Boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT Dni FROM Pacientes WHERE Dni="+Dni;
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

    public void almacenarPaciente(Paciente Paciente) {
        String dni=Paciente.getDni();
        String nombre=Paciente.getNombre();
        String apellidos=Paciente.getApellidos();
        String direccion=Paciente.getDireccion();
        String email=Paciente.getEmail();
        String contrasena=Paciente.getContrasena();
        String telefono=Paciente.getTelefono();
        Date fecNac=(Date) Paciente.getFechaNacimiento();
        String lugarNac=Paciente.getLugarNacimiento();
        String foto=Paciente.getFotografia();
        String tipo=Paciente.getTipo();

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Pacientes VALUES "+dni+","+nombre+","+apellidos+","+direccion+","+email+","+contrasena+","+telefono+","+fecNac+","+lugarNac+","+foto+","+tipo;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();
        
    }


}
