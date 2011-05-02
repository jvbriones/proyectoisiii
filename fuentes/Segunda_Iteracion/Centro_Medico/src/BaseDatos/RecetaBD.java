/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;


/**
 *
 * @author Juan Carlos
 */
public class RecetaBD {
    void almacenar(Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (Rec);
    }
    
    Receta obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Receta Rec = (Receta) session.get(Receta.class, Id);
      return Rec;
    }
    void actualizar (Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (Rec);

    }
    void eliminar (Receta Rec){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (Rec);

    }

}


