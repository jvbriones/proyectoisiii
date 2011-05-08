/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.PruebaAnalisis;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class PruebaAnalisisBD {
    public void almacenar(PruebaAnalisis prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( prueba );
        session.getTransaction().commit();
    }


    public void actualizar (PruebaAnalisis prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( prueba);
    }

    public void eliminar (PruebaAnalisis prueba){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( prueba );
        session.getTransaction().commit();
    }

    public PruebaAnalisis obtener (int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        PruebaAnalisis prueba = (PruebaAnalisis) session.get(PruebaAnalisis.class, id);
        session.getTransaction().commit();

        return prueba;
    }

}
