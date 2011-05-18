package BaseDatos;
import CentroMedico.PruebaRadiologia;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase PruebaRadiologia en la base de datos.
 */
public class PruebaRadiologiaBD {
    public void almacenar(PruebaRadiologia prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( prueba );
        session.getTransaction().commit();
    }


    public void actualizar (PruebaRadiologia prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( prueba);
        session.getTransaction().commit();
    }

    public void eliminar (PruebaRadiologia prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( prueba );
        session.getTransaction().commit();
    }

    public PruebaRadiologia obtener (int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        PruebaRadiologia prueba = (PruebaRadiologia) session.get(PruebaRadiologia.class, id);
        session.getTransaction().commit();

        return prueba;
    }
}
