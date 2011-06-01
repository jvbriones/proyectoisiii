package BaseDatos;
import CentroMedico.PruebaAnalisis;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase PruebaAnalisis en la base de datos.
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
        session.getTransaction().commit();
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
    public ArrayList obtenerPruebasAnalisis( String dniPaciente)throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<PruebaAnalisis> result = (List<PruebaAnalisis>)session.createQuery("from PruebaAnalisis").list();
        Set<PruebaAnalisis> analisis = new HashSet<PruebaAnalisis>(result);

        session.getTransaction().commit();
        return (ArrayList) analisis;
    }

}
