package BaseDatos;

import CentroMedico.Medico;
import java.sql.*;
import org.hibernate.Session;

public class MedicoBD {
    String IpDelServidor = "localhost";
    String NombreDB = "CentroMedico";
    String user = "generico";
    String pass = "generico";

    /*
     * Medico
     */
    public boolean existeMedico(String Dni) throws SQLException {
        Medico med = obtener(Dni);

        if (med != null){
            System.out.print("ExisteMedico: Existe el paciente");
           return true;
       }
       else{
           System.out.print( "ExisteMedico: No existe el paciente\n");
           return false;
       }
    }

    /*
     * almacenarMedico
     */
    public void almacenarMedico(Medico med) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(med);
        session.getTransaction().commit();
    }

    /*
     * obtener
     * Devuelve un objeto Medico
     */
    public Medico obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Medico med = (Medico) session.get(Medico.class, Dni);
        return med;
    }


    /*
     * actualizar
     * Actualiza la información relativa a un medico en la base de datos.
     */
    public void actualizar (Medico med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (med);
        session.getTransaction().commit();
    }

    /*
     * eliminar
     * Elimina un objeto Paciente de la base de datos.
     */
    public void eliminar(Medico med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (med);
        session.getTransaction().commit();
    }
}
