package BaseDatos;
import CentroMedico.PruebaOrina;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase PruebaOrina en la base de datos.
 */
public class PruebaOrinaBD {
    public void almacenar(PruebaOrina prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( prueba );
        session.getTransaction().commit();
    }


    public void actualizar (PruebaOrina prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( prueba);
    }

    public void eliminar (PruebaOrina prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( prueba );
        session.getTransaction().commit();
    }

    public PruebaOrina obtener (int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        PruebaOrina prueba = (PruebaOrina) session.get(PruebaOrina.class, id);
        session.getTransaction().commit();

        return prueba;
    }

}
