package BaseDatos;

import CentroMedico.AtributoOrina;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase AtributoOrina en la base de datos.
 */
public class AtributoOrinaBD {
    public void almacenar(AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Atr );
        session.getTransaction().commit();
    }


    public void actualizar (AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Atr );
        session.getTransaction().commit();
    }

    public void eliminar (AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Atr );
        session.getTransaction().commit();
    }

    public AtributoOrina obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        AtributoOrina atr = (AtributoOrina) session.get(AtributoOrina.class, Nombre);
        session.getTransaction().commit();

        return atr;
    }

}
