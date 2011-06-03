package BaseDatos;

import CentroMedico.PruebaSangre;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase PruebaSangre en la base de datos.
 */
public class PruebaSangreBD {

    public void almacenar(PruebaSangre prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( prueba );
        session.getTransaction().commit();
    }

    public void actualizar (PruebaSangre prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( prueba);
        session.getTransaction().commit();
    }

    public void eliminar (PruebaSangre prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( prueba );
        session.getTransaction().commit();
    }

    public PruebaSangre obtener (int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        PruebaSangre prueba = (PruebaSangre) session.get(PruebaSangre.class, id);
        session.getTransaction().commit();

        return prueba;
    }
}
