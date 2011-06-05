package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Usuario en la base de datos.
 *  Se han mantenido las funciones implementadas en la iteración 1 para mantener el funcionamiento del código implementado entonces. Aunque en las iteraciones 2 y 3 se usarán las funciones nuevas (obtener, almacenar, actualizar y eliminar) que hacen uso de hibernate.
 *  Lo ideal sería que al final de la iteración 3 todo el proyecto fuese integrado con las nuevas funciones, permitiendo el borrado de las antiguas.
 */
public class UsuarioBD {

/*    public boolean validacion(String Dni, String Pass) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Usuario User = (Usuario) session.get(Usuario.class, Dni);
        if(User !=null && User.getContrasenia().equals(Pass))
        return true;
        else return false;

    }
*/
    public boolean existeUsuario(String Dni) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Usuario User = (Usuario) session.get(Usuario.class, Dni);
        session.getTransaction().commit();
        if(User !=null)
        return true;
        else return false;

    }

    public Usuario obtener(String Dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Usuario User = (Usuario) session.get(Usuario.class, Dni);
        session.getTransaction().commit();
       return User;
    }
    //public Usuario obtenerUsuarioNombre(String nombre) throws SQLException {}

    public void almacenar(Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (User);
        session.getTransaction().commit();
    }

    public void actualizar (Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (User);
        session.getTransaction().commit();
    }

    public void eliminar(Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (User);
        session.getTransaction().commit();

    }
}
