/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


/**
 *
 * @author Juan Carlos
 */
public class RecetaBD {
    public void almacenar(Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Rec);
        session.getTransaction().commit();
    }
    
    public Receta obtener (int Id){
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

//Esta función queda pendiente de verificación.
    public Set<Receta> obtenerRecetasPaciente (String dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Receta> result = (List<Receta>)session.createQuery("from Receta where DNI_PACIENTE='dni'").list();
        Set<Receta> recetas = new HashSet<Receta>(result);

        session.getTransaction().commit();
        return recetas;
    }
}


