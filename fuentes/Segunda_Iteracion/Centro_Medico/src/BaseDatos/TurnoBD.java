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
 * modificado por Juan Carlos Bermúdez. Añadidas las funciones almacenar, actualizar, eliminar y obtener
 */
package BaseDatos;

import CentroMedico.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.*;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class TurnoBD {

    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

    public boolean existeTurno(String tipo) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT Dni FROM Turnos WHERE Tipo='"+tipo+"'";
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
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "INSERT INTO Turnos VALUES ('"+tipo+"')";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public boolean puedoBorrarTurno(String Dni) throws SQLException {
        boolean puedo;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Turnos WHERE Dni='"+Dni+"'";
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
         * función devuelve un boolean, y luego en el diagrama de secuencia
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
    
    public void asignaTurno(String Dni, Date fechaInicio, Date fechaFin, String tipo) {

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "INSERT INTO Turnos VALUES ('"+Dni+"',"+fechaInicio+","+fechaFin+",'"+tipo+"')";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public void modificaTurno(String Dni, Date fechaInicio, Date fechaFin, String tipo) {

        /*
         Hay una incoherencia ya que en el diagrama de clases dice que esta
         * función devuelve un boolean, y luego en el diagrama de secuencia
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

        Turno Turno=new Turno();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Turnos WHERE Dni='"+Dni+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            Date fechaInicio=rs.getDate("FechaInicio");
            Date fechaFin=rs.getDate("FechaFin");
            String tipo=rs.getString("Tipo");

//Se ha puesto esta línea entre comentarios porque es incoherente con la nueva clase Turno.
//            Turno = new Turno(dni, fechaInicio, fechaFin, tipo);
        }
        else{
            Turno= null;
        }
        conexion.closeConnection();
        return Turno;
    }


    public ArrayList ConsultarTurnos(Date fecha) throws SQLException {

        ArrayList datos=new ArrayList();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT Dni, FechaInicio FROM Turno WHERE FechaInicio="+fecha;
        ResultSet rs = conexion.consultaSelect(Consulta);
        while(rs.next()) {
            String dni=rs.getString("Dni");
            Date fechaAux=rs.getDate("Fecha");

            datos.add(fechaAux);
            datos.add(dni);

        }
        return datos;
    }
    public void almacenar(Turno turno){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( turno );
        session.getTransaction().commit();

    }

    public Turno obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Turno turno= (Turno) session.get(Turno.class, Id);
        session.getTransaction().commit();

        return turno;
    }



    public void actualizar (Turno turno){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( turno );
        session.getTransaction().commit();
    }

    public void eliminar (Turno turno){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete ( turno );
        session.getTransaction().commit();
    }

}
