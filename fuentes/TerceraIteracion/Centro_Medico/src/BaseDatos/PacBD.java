package BaseDatos;

import CentroMedico.Paciente;
import java.sql.*;
import org.hibernate.Session;

public class PacBD {
    String IpDelServidor = "localhost";
    String NombreDB = "CentroMedico";
    String user = "generico";
    String pass = "generico";

    /*
     * existePaciente
     */
    public boolean existePaciente(String Dni) throws SQLException {
        Paciente Pac = obtener(Dni);
        
        if (Pac != null){
            System.out.print("ExistePaciente: Existe el paciente");
           return true;
       }
       else{
           System.out.print( "ExistePaciente: No existe el paciente\n");
           return false;
       }
    }

    /*
     * almacenarPaciente
     */
    public void almacenarPaciente(Paciente Paciente) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(Paciente);
        session.getTransaction().commit();
    }

    /*
     * obtener
     * Devuelve un objeto Paciente.
     */
    public Paciente obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Paciente Pac = (Paciente) session.get(Paciente.class, Dni);
        return Pac;
    }

    /*
     * almacenar
     * Guarda un objeto Paciente en la base de datos.
     */
    public void almacenar(Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (paciente);
        session.getTransaction().commit();
    }

    /*
     * actualizar
     * Actualiza la información relativa a un paciente en la base de datos.
     */
    public void actualizar (Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (paciente);
        session.getTransaction().commit();
    }

    /*
     * eliminar
     * Elimina un objeto Paciente de la base de datos.
     */
    public void eliminar(Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (paciente);
        session.getTransaction().commit();
    }
}
