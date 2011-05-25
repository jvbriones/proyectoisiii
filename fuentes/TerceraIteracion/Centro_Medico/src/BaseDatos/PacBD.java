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
import org.hibernate.Session;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos Bermúdez. Añadidas las funciones almacenar, actualizar, eliminar y obtener.
 */
public class PacBD {


    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

    public boolean existePaciente(String Dni) throws SQLException {
        boolean existe;

       Paciente Pac = obtener(Dni);
       if (Pac!=null){
           System.out.print("el tio existe\n");
           return true;
       }
       else{
           System.out.print( " el tio NO existe\n");
           return false;
       }
    }

    // Modificado con respecto al diseño
    public void almacenarPaciente(Paciente Paciente) {

         Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Paciente);
        session.getTransaction().commit();

        
    }

    public Paciente obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Paciente Pac = (Paciente) session.get(Paciente.class, Dni);
        return Pac;
    }


/*    public Paciente obtenerPaciente(String Dni) throws SQLException {

        Paciente paciente;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Paciente WHERE DNI_PACIENTE='"+Dni+"'";
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
*/
 

    public void almacenar(Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (paciente);
        session.getTransaction().commit();
    }

    public void actualizar (Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (paciente);
        session.getTransaction().commit();
    }

    public void eliminar(Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (paciente);
        session.getTransaction().commit();

    }

}
