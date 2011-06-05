/*
 * CitasBD
 *
 * Mayo 2011
 *
 * Sub-equipo 3
 */

package BaseDatos;

import CentroMedico.Cita;
import CentroMedico.Paciente;
import java.sql.*;
import org.hibernate.*;
import java.util.*;
import java.util.Date;
import java.util.ArrayList;

public class CitaBD {

    public void eliminar(Cita Cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(Cita);
        session.getTransaction().commit();
    }

    public void almacenar(Cita Cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(Cita);
        session.getTransaction().commit();
    }

    public void actualizar(Cita Cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        try{
            session.update(Cita);
            System.out.println("Cita actualizada correctamente.");
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        session.getTransaction().commit();
    }

    public Cita obtener (int Id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        Cita Cita = (Cita) session.get(Cita.class, Id);
        session.getTransaction().commit();

        return Cita;
    }

    public boolean ExisteCita(int id) throws SQLException {
        Cita cit = obtener(id);

        if (cit != null)
            return true;
        return false;

    }

    public ArrayList<Cita> VerCitas(Paciente pac) throws SQLException{

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        List<Cita> result = (List<Cita>)session.createQuery("from Cita where DNIPaciente='"+pac.getDNI()+"'").list();
        ArrayList result2 = new ArrayList(result);

        return result2;
    }

    public Set<Cita> ObtenerTodasCitas() throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        List<Cita> result = (List<Cita>)session.createQuery("from Cita").list();
        Set<Cita> citas = new HashSet<Cita>(result);

        session.getTransaction().commit();

        return  citas;
        
    }
    
    /** SIN HACER LOS SIGUIENTES METODOS **/

    public String AltaCita(Date fechaIni, Date fechaFin){

        return "";

    }

}
