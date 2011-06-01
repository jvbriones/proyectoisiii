package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Farmaceutico en la base de datos.
 */
public class FarmaceuticoBD {

    public Farmaceutico obtener(String Dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Farmaceutico Farmaceutico = (Farmaceutico) session.get(Farmaceutico.class, Dni);
        session.getTransaction().commit();
       return Farmaceutico;
    }

    public void almacenar(Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Farmaceutico);
        session.getTransaction().commit();
    }

    public void actualizar (Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (Farmaceutico);
        session.getTransaction().commit();
    }

    public void eliminar(Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (Farmaceutico);
        session.getTransaction().commit();
    }

    public boolean existe (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Farmaceutico Farmaceutico = (Farmaceutico) session.get(Farmaceutico.class, DNI);
        session.getTransaction().commit();

        if(Farmaceutico!=null) return true;
        else return false;
    }

    public Set<Farmaceutico> obtenerListaFarmaceuticos(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<Farmaceutico> result = (List<Farmaceutico>)session.createQuery("from Farmaceutico").list();
        Set<Farmaceutico> Farmaceuticos = new HashSet<Farmaceutico>(result);

        session.getTransaction().commit();
        return Farmaceuticos;
    }
}
