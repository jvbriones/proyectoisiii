/*
 * turnoBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los turnos.
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
public class turnoBD {
    public Boolean existeTurno(String tipo) throws SQLException {
        Boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT Dni FROM Turnos WHERE Tipo="+tipo;
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

    public void altaTurno(String tipo) {

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Turnos VALUES Tipo="+tipo;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public Boolean puedoBorrarTurno(String Dni) throws SQLException {
        Boolean puedo;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Turnos WHERE Dni="+Dni;
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            puedo=true;
        }
        else {
            puedo=false;
        }
        conexion.closeConnection();
        return puedo;
    }

    public void borraTurno(String Dni) {

        /*
         Hay una incoherencia ya que en el diagrama de clases dice que esta
         * función devuelve un Boolean, y luego en el diagrama de secuencia
         * por el contrario, no devuelove nada (void).
         */
        /*
        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "DELETE * FROM Turnos WHERE Dni="+Dni;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();
        */

    }
    
    public void altaTurno(String Dni, Date fechaInicio, Date fechaFin, String tipo) {

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Turnos VALUES "+Dni+","+fechaInicio+","+fechaFin+","+tipo;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public void modificaTurno(String Dni, Date fechaInicio, Date fechaFin, String tipo) {

        /*
         Hay una incoherencia ya que en el diagrama de clases dice que esta
         * función devuelve un Boolean, y luego en el diagrama de secuencia
         * por el contrario, no devuelove nada (void).
         */
        /*
        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "Update Turnos SET VALUES"+Dni+","+fechaInicio+","+fechaFin+","+tipo"WHERE Turno.Dni="+Dni;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();
        */

    }

    public Turno obtenerTurno(String Dni) throws SQLException {

        Turno Turno;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Turnos WHERE Turnos.Dni="+Dni;
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            Date fechaInicio=rs.getDate("FechaInicio");
            Date fechaFin=rs.getDate("FechaFin");
            String tipo=rs.getString("Tipo");

            Turno = new Turno(dni, fechaInicio, fechaFin, tipo);
        }
        else{
            Turno= null;
        }
        conexion.closeConnection();
        return Turno;
    }

}
