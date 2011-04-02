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
import java.util.ArrayList;


/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */
public class citasBD {

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
            String dni=rs.getString("DniPaciente");
            String dniM=rs.getString("DniMedico");
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

    public ArrayList EstadisticasCitas(Date fecha_inicio, Date fecha_fin) throws SQLException {
        ArrayList datosAdmin = new ArrayList();

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Citas WHERE "+fecha_inicio+"<Fecha AND Fecha<"+fecha_fin;
        ResultSet rs = conexion.consultaSelect(Consulta);
        while(rs.next()) {
            String dni=rs.getString("DniPaciente");
            String dniM=rs.getString("DniMedico");
            Date fecha=rs.getDate("Fecha");
            Boolean estado=rs.getBoolean("Estado");
            String dniA=rs.getString("DniAdministrativoCita");

            datosAdmin.add(dni);
            datosAdmin.add(dniM);
            datosAdmin.add(fecha);
            datosAdmin.add(estado);
            datosAdmin.add(dniA);

        }
        return datosAdmin;
    }
}
