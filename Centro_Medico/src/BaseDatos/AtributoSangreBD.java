package BaseDatos;

import CentroMedico.AtributoSangre;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase AtributoSangre en la base de datos.
 */
public class AtributoSangreBD {
    public void almacenar(AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Atr );
        session.getTransaction().commit();
    }


    public void actualizar (AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Atr );
        session.getTransaction().commit();
    }

    public void eliminar (AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Atr );
        session.getTransaction().commit();
    }

    public AtributoSangre obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        AtributoSangre atr = (AtributoSangre) session.get(AtributoSangre.class, Nombre);
        session.getTransaction().commit();

        return atr;
    }

    public ArrayList<AtributoSangre> obtenerListaAtributosSangre(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<AtributoSangre> result = (List<AtributoSangre>)session.createQuery("from AtributoSangre").list();
        ArrayList<AtributoSangre> atributosSangre = new ArrayList<AtributoSangre>(result);

        session.getTransaction().commit();
        return atributosSangre;
    }
}
