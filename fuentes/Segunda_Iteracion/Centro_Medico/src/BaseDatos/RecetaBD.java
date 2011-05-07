/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.*;
import java.util.Set;
import org.hibernate.Session;


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

    public Set<Receta> obtenerRecetasPaciente (String dni){
        //ESTA FUNCIÓN HAY QUE IMPLEMENTARLA. OBTIENE UN SET CON TODAS LAS RECETAS DE ESE PACIENTE.


    }
}


