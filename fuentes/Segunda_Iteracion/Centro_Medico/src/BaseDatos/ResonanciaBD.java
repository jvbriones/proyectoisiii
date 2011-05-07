/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.Resonancia;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class ResonanciaBD {
    public void almacenar(Resonancia Res){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Res );
        session.getTransaction().commit();

    }

    public Resonancia obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Resonancia Res= (Resonancia) session.get(Resonancia.class, Id);
        session.getTransaction().commit();

        return Res;
    }

    public void actualizar (Resonancia Res){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( Res );
        session.getTransaction().commit();
    }

    public void eliminar (Resonancia Res){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete ( Res );
        session.getTransaction().commit();
    }
}
