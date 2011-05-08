/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.PruebaOrina;
import org.hibernate.Session;

/**
 *
 * @author pope
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
