package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase LoteMedicamento en la base de datos.
 */
public class LoteMedicamentoBD {
    
    public void almacenar(LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save(Lote);
    }

    public LoteMedicamento obtener (String CodBarras){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        LoteMedicamento Lote = (LoteMedicamento) session.get(LoteMedicamento.class, CodBarras);
        session.getTransaction().commit();
        return Lote;
    }

    public void actualizar (LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update(Lote);
        session.getTransaction().commit();
    }

    public void eliminar (LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Lote);
        session.getTransaction().commit();
    }
   
    public void eliminarLote (String CodBarras){
        LoteMedicamento Lote = new LoteMedicamento();
        Lote = obtener (CodBarras);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Lote);
        session.getTransaction().commit();
    }
}