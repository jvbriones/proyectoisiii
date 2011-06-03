package BaseDatos;

import CentroMedico.Enfermedad;
import java.sql.*;
import org.hibernate.Session;
import org.hibernate.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnfermedadBD{
        /*
         * almacenar
         */
	public void almacenar(Enfermedad enfmd){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();
            session.save(enfmd);
            session.getTransaction().commit();
        }

        /*  FALTA REVISAR EL ATRIBUTO
         * Obtener
         */
	public Enfermedad obtener(Integer id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Enfermedad enfmd = (Enfermedad) session.get(Enfermedad.class, id);
        session.getTransaction().commit();
            return enfmd;
        }

        /* 
         * actualizar
         */
	public void actualizar(Enfermedad enfmd){

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction ();
            try{
                session.update(enfmd);
                System.out.println("Cita actualizada correctamente.");
            }catch(HibernateException ex){
                System.err.println(ex.getMessage());
            }
            session.getTransaction().commit();

        }

        /*
         * eliminar
         */
	public void eliminar(Enfermedad enfmd){

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(enfmd); /* NO FUNCIONA */
            session.getTransaction().commit();
        }

        /*
         * ObtenerEnfermedades
         */
        
	public ArrayList<Enfermedad> ObtenerEnfermedades(String dni){
             Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<Enfermedad> result = (List<Enfermedad>)session.createQuery("from Enfermedad where DNI_PACIENTE='" + dni + "'").list();
        ArrayList<Enfermedad> enf = new ArrayList<Enfermedad>(result);
        session.getTransaction().commit();
        return enf;
        }

}
