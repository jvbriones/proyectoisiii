/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.Radiografia;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class RadiografiaBD {
    public void almacenar(Radiografia Rad){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Rad );

    }

    public Radiografia obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Radiografia Rad = (Radiografia) session.get(Radiografia.class, Id);

        return Rad;
    }

    public void actualizar (Radiografia Rad){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( Rad );    
    }

    public void eliminar (Radiografia Rad){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete ( Rad );
    }
}
