package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Medicamento en la base de datos.
 */
public class MedicamentoBD  implements Serializable{


    public void almacenar(Medicamento Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save(Med);
        session.getTransaction().commit();
    }

    public Medicamento obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Medicamento Med = (Medicamento) session.get(Medicamento.class, Nombre);
        
        return Med;
    }

    public void actualizar (Medicamento Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update(Med);
        session.getTransaction().commit();
    }
    
    public void eliminar (Medicamento Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Med);
        session.getTransaction().commit();
    }
    
    public Set<Medicamento> obtenerTodosMedicamentos (){

         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Medicamento> result = (List<Medicamento>)session.createQuery("from Medicamento").list();
        Set<Medicamento> medicamentos = new HashSet<Medicamento>(result);

        session.getTransaction().commit();
        return medicamentos;
   }
}
