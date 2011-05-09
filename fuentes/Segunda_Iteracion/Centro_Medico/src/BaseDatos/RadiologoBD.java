package BaseDatos;
import CentroMedico.Radiologo;
import org.hibernate.Session;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Radiologo en la base de datos.
 */
public class RadiologoBD {
    public void almacenar(Radiologo radiologo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( radiologo );
        session.getTransaction().commit();
    }


    public void actualizar ( Radiologo radiologo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( radiologo );
    }

    public void eliminar (Radiologo radiologo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( radiologo );
        session.getTransaction().commit();
    }

    public Radiologo obtener (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Radiologo radiologo = (Radiologo) session.get(Radiologo.class, DNI);
        session.getTransaction().commit();

        return radiologo;
    }

    public Set<Radiologo> obtenerListaRadiologos(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Radiologo> result = (List<Radiologo>)session.createQuery("from Radiologo").list();
        Set<Radiologo> radiologos = new HashSet<Radiologo>(result);

        session.getTransaction().commit();
        return radiologos;
    }
    
}
