/*
 * citasBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con las citas.
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
public class citasBD {
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

    public Boolean existeCita(String Dni) throws SQLException {
        Boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT DniPaciente FROM Citas WHERE DniPaciente="+Dni+"And Estado=true";
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

    public void almacenarCita(Cita cita) {
        String dni=cita.getDniPaciente();
        String dniM=cita.getDniMedico();
        Date fecha=(Date) cita.getFecha();
        Boolean estado=cita.getEstado();


        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Citas VALUES DniPaciente="+dni+",DniMedico="+dniM+",Fecha="+fecha+",Estado="+estado;
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public Cita obtenerCita(String Dni) throws SQLException {

        Cita cita;

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Citas WHERE DniPaciente="+Dni;
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            String dniM=rs.getString("DniM");
            Date fecha=rs.getDate("Fecha");
            Boolean estado=rs.getBoolean("Estado");

            cita = new Cita(dni, dniM, fecha, estado);
        }
        else{
            cita= null;
        }
        conexion.closeConnection();
        return cita;
    }
}
