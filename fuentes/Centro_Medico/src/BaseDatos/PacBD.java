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
package BaseDatos;

import CentroMedico.Paciente;
import java.sql.*;


/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */
public class PacBD {


    String IpDelServidor="217.216.97.75";
    String NombreDB="centroMedico";
    String user="personal";
    String pass="personal";

    public boolean existePaciente(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user, pass);
        String Consulta = "SELECT Dni FROM Pacientes WHERE Dni='"+Dni+"'";
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
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);

        // El diseño no se corresponde con al modelo de la base de datos
        // Hay que ejecutar estas 2 sentencias
        String Consulta = "INSERT INTO Usuarios VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+email+"','"+contrasena+"','"+telefono+"',"+fecNac+",'"+lugarNac+"','"+foto+"','"+tipo+"')";
        conexion.consultaUpdate(Consulta);

        Consulta = "INSERT INTO Pacientes VALUES ('"+dni+"')";
        conexion.consultaUpdate(Consulta);
        
        conexion.closeConnection();
        
    }


    public Paciente obtenerPaciente(String Dni) throws SQLException {

        Paciente paciente;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Pacientes WHERE Dni='"+Dni+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            String nombre=rs.getString("Nombre");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasena");
            String telefono=rs.getString("Telefono"); //Estos campos han de coincidir exactamente con los de la tabla Usuarios en la BD
            Date fecNac=rs.getDate("FechaNacimiento");//Si el Telefono es un Entero en la BD, aqui tendria que ser getInt("Telefono")
            String lugarNac=rs.getString("LugarNacimiento");
            String foto=rs.getString("Fotografia");

            paciente = new Paciente(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto);
        }
        else{
            paciente= null;
        }
        conexion.closeConnection();
        return paciente;
    }
}
