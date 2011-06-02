package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Receta en la base de datos.
 */
public class RecetaBD {

    public void almacenar(Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Rec);
        session.getTransaction().commit();
    }
    
    public Receta obtenerReceta(int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Receta Rec = (Receta) session.get(Receta.class, Id);
        session.getTransaction().commit();
      return Rec;
    }

    public void actualizar (Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (Rec);
        session.getTransaction().commit();

    }

    public void eliminar (Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (Rec);
        session.getTransaction().commit();
    }

    public Set<Receta> obtenerRecetas (String dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Receta> result = (List<Receta>)session.createQuery("from Receta where DNI_PACIENTE='"+dni+"'").list();
        Set<Receta> recetas = new HashSet<Receta>(result);

        return recetas;
    }

}


