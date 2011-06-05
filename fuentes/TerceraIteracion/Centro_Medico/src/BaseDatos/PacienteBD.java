package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Paciente en la base de datos.
 */
public class PacienteBD {

    public Paciente obtener(String Dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Paciente Paciente = (Paciente) session.get(Paciente.class, Dni);
        session.getTransaction().commit();
       return Paciente;
    }

    public void almacenar(Paciente Paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Paciente);
        session.getTransaction().commit();
    }

    public void actualizar (Paciente Paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (Paciente);
        session.getTransaction().commit();
    }

    public void eliminar(Paciente Paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (Paciente);
        session.getTransaction().commit();

    }

    public boolean existePaciente(String Dni) throws SQLException {
        Paciente Pac = obtener(Dni);

        if (Pac != null)
           return true;
       return false;

    }

}
