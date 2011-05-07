/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.*;
import org.hibernate.Session;
import java.util.Set;
import java.io.Serializable;
import org.hibernate.Criteria;

/**
 *
 * @author pope
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
        session.getTransaction().commit();
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


        Criteria criteria = session.createCriteria ( Medicamento.class );
        System.out.println ("Medicamentos Encontrados:" + criteria.list ().size ());
        for ( Object medicamento_obj : criteria.list () )
        {
            Medicamento med = (Medicamento) medicamento_obj;
            if(med.getNombre() == null ? Dni == null : paciente.getDni().equals(Dni)) {
                System.out.println ( " Encontrado " );
                session.getTransaction ().commit ();
                return paciente;
            }
        }



        return null;
    }
}
