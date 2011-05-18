package BaseDatos;
import CentroMedico.Radiografia;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Radiografia en la base de datos.
 */
public class RadiografiaBD {
    public void almacenar(Radiografia Rad){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Rad );
        session.getTransaction().commit();

    }

    public Radiografia obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Radiografia Rad = (Radiografia) session.get(Radiografia.class, Id);
        session.getTransaction().commit();

        return Rad;
    }

    public void actualizar (Radiografia Rad){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( Rad );    
        session.getTransaction().commit();
    }

    public void eliminar (Radiografia Rad){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete ( Rad );
        session.getTransaction().commit();
    }
}
