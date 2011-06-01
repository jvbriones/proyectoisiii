package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Administrativo en la base de datos.
 */
public class AdministrativoBD {

    public Administrativo obtener(String Dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Administrativo Administrativo = (Administrativo) session.get(Administrativo.class, Dni);
        session.getTransaction().commit();
       return Administrativo;
    }

    public void almacenar(Administrativo Administrativo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Administrativo);
        session.getTransaction().commit();
    }

    public void actualizar (Administrativo Administrativo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (Administrativo);
        session.getTransaction().commit();
    }

    public void eliminar(Administrativo Administrativo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (Administrativo);
        session.getTransaction().commit();
    }
}
