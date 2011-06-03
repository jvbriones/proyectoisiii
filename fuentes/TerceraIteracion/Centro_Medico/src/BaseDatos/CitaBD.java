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
import BaseDatos.PacienteBD;
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

    public ArrayList<Cita> VerCitas(Paciente pac) throws SQLException{

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        List<Cita> result = (List<Cita>)session.createQuery("from Cita where DNIPaciente'"+pac.getDNI()+"'").list();
        ArrayList result2 = new ArrayList(result);

        return result2;
    }

    /* SIN HACER
     * altaCita
     */
    public String AltaCita(Calendar fechaIni, Calendar fechaFin){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        return "";
}

    /*  NO FUNCIONA!
     * obtenerCita
     */
    public Cita ObtenerCita(Paciente pac) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        //Cita Ci = (Cita) session.get(Cita.class, pac);        /*****ESTO PETA******/

        Date hora = new Date();           /* PARCHE */

        //PacBD pac = new PacBD();
        //personalBD per = new personalBD();
        //Cita Ci = new Cita(true, hora, "Tarde", pac, per.obtener("33333333A")); /* PARCHE */

        return new Cita();
    }

    /* NO FUNCIONA
     * existeCita
     */
    public boolean ExisteCita(int id) throws SQLException {
        Cita cit = obtener(id);

        if (cit != null){
            System.out.print("ExisteCita: Existe la Cita");
            return true;
       }
       else{
           System.out.print("ExisteCita: No existe la cita");
           return false;
       }
    }

    /*  ¿¿¿¿¿¿¿¿¿¿¿¡¡¡¡¡¡¡SIN ARGUMENTOS???!!!!!?!!!!!!!!
     *  ObtenerTodasCitas
     */
    public Set<Cita> ObtenerTodasCitas() throws SQLException{
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        List<Cita> result = (List<Cita>)session.createQuery("from Cita").list();
        Set<Cita> citas = new HashSet<Cita>(result);

        session.getTransaction().commit();
        return  citas;
    }

}
