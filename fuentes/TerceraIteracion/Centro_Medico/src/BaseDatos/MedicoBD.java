/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.Medico;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Manolo5
 */
public class MedicoBD {
     public void almacenar(Medico medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( medico );
        session.getTransaction().commit();
    }


    public void actualizar ( Medico medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update(medico );
      
    }

    public void eliminar (Medico medico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(medico );
        session.getTransaction().commit();
    }

    public Medico obtener (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Medico medico = (Medico) session.get(Medico.class, DNI);
        //session.getTransaction().commit();

        return medico;
    }

    public boolean existe (String DNI){
        boolean existe;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Medico medico = (Medico) session.get(Medico.class, DNI);
        //session.getTransaction().commit();

        if(medico!=null) return true;
        else return false;
    }

    public Set<Medico> obtenerListaMedicos(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<Medico> result = (List<Medico>)session.createQuery("from Medico").list();
        Set<Medico> medicos = new HashSet<Medico>(result);

        session.getTransaction().commit();
        return medicos;
    }


}
