package BaseDatos;
import CentroMedico.Medico;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Medico en la base de datos.
 */
public class MedicoBD {
    public void almacenar(Medico Medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Medico );
        session.getTransaction().commit();
    }


    public void actualizar ( Medico Medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Medico );
    }

    public void eliminar (Medico Medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Medico );
        session.getTransaction().commit();
    }

    public Medico obtener (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Medico Medico = (Medico) session.get(Medico.class, DNI);
        session.getTransaction().commit();

        return Medico;
    }


}
