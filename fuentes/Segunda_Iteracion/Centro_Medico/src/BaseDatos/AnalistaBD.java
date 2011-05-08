/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.Analista;
import org.hibernate.Session;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author pope
 */
public class AnalistaBD {
    public void almacenar(Analista analista){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( analista );
        session.getTransaction().commit();
    }


    public void actualizar ( Analista analista){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( analista );
    }

    public void eliminar (Analista analista){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( analista );
        session.getTransaction().commit();
    }

    public Analista obtener (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Analista analista = (Analista) session.get(Analista.class, DNI);
        session.getTransaction().commit();

        return analista;
    }

    public Set<Analista> obtenerListaAnalistas(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Analista> result = (List<Analista>)session.createQuery("from Analista").list();
        Set<Analista> analistas = new HashSet<Analista>(result);

        session.getTransaction().commit();
        return analistas;
    }


}
