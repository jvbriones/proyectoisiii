package BaseDatos;
import CentroMedico.Analista;
import java.sql.SQLException;
import org.hibernate.Session;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Analista en la base de datos.
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

    public boolean existe (String DNI){
        boolean existe;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Analista analista = (Analista) session.get(Analista.class, DNI);
        //session.getTransaction().commit();

        if(analista!=null) return true;
        else return false;
    }

    /*
     * existePaciente
     */
    public boolean existeAnalista(String Dni) throws SQLException {
        Analista analista = obtener(Dni);

        if (analista != null){
            System.out.print("existeAnalista: Existe el analista");
           return true;
       }
       else{
           System.out.print( "existeAnalista: No existe el analista\n");
           return false;
       }
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
