package BaseDatos;

import CentroMedico.Enfermedad;
import java.sql.*;
import org.hibernate.Session;
import org.hibernate.*;
import java.util.ArrayList;
import java.util.Set;

public class EnfermedadBD{

	String	IpDelServidor = "localhost";
	String	NombreDB = "CentroMedico";
	String user = "generico";
	String pass = "generico";

        /*
         * Almacenar
         */
	public void Almacenar(Enfermedad enfmd){
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();
            session.save(enfmd);
            session.getTransaction().commit();
        }

        /*  FALTA REVISAR EL ATRIBUTO
         * Obtener
         */
	public Enfermedad Obtener(Integer id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Enfermedad enfmd = (Enfermedad) session.get(Enfermedad.class, id);
            return enfmd;
        }

        /* 
         * Actualizar
         */
	public void Actualizar(Enfermedad enfmd){

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
         * Eliminar
         */
	public void Eliminar(Enfermedad enfmd){

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(enfmd); /* NO FUNCIONA */
            session.getTransaction().commit();
        }

        /*
         * ObtenerEnfermedades
         */
	//public Set<Enfermedad> ObtenerEnfermedades(String dni){
          //  return new Set;
        //}

}
