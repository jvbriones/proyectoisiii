/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.Farmaceutico;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Manolo5
 */
public class FarmaceuticoBD {
    public void almacenar(Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Farmaceutico );
        session.getTransaction().commit();
    }


    public void actualizar ( Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Farmaceutico );
        session.getTransaction().commit();
    }

    public void eliminar (Farmaceutico Farmaceutico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Farmaceutico );
        session.getTransaction().commit();
    }

    public Farmaceutico obtener (String DNI){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Farmaceutico Farmaceutico = (Farmaceutico) session.get(Farmaceutico.class, DNI);
        //session.getTransaction().commit();

        return Farmaceutico;
    }

    public boolean existe (String DNI){
        boolean existe;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Farmaceutico Farmaceutico = (Farmaceutico) session.get(Farmaceutico.class, DNI);
        //session.getTransaction().commit();

        if(Farmaceutico!=null) return true;
        else return false;
    }

    public Set<Farmaceutico> obtenerListaFarmaceuticos(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<Farmaceutico> result = (List<Farmaceutico>)session.createQuery("from Farmaceutico").list();
        Set<Farmaceutico> Farmaceuticos = new HashSet<Farmaceutico>(result);

        session.getTransaction().commit();
        return Farmaceuticos;
    }


}
