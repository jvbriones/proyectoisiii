/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.util.Set;

/**
 *
 * @author pope
 */
public class MedicamentoBD {


    public void almacenar(Medicamento Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save(Med);
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
    }
    
    public void eliminar (Medicamento Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Med);
    }
    
    public Set<Medicamento> obtenerTodosMedicamentos (){



        return null;
    }
}
