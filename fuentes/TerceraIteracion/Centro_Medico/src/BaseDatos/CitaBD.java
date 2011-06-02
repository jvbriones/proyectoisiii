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







    /* SIN HACER
     * altaCita
     */
    public String AltaCita(Calendar fechaIni, Calendar fechaFin){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        return "";
}

    /*
     * almacenarCita
     * Dado un objeto Cita, lo almacena en la base de datos.
     * @param cita, Objeto Cita a almacenar
     * @post No ofrece información sobre el estado de la operacion
     */

    /*  NO FUNCIONA!
     * obtenerCita
     * Obtiene la cita relativa a un usuario dado.
     * @param Dni, Identificación del paciente del que obtener la cita.
     * @return El objeto Cita oportuno o un objeto null.
     */
/*    public Cita ObtenerCita(Paciente pac) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        //Cita Ci = (Cita) session.get(Cita.class, pac);        /*****ESTO PETA******/

  /*      Date hora = new Date();           /* PARCHE */

/*        //PacBD pac = new PacBD();
        personalBD per = new personalBD();
        Cita Ci = new Cita(true, hora, "Tarde", pac, per.obtener("33333333A")); /* PARCHE */
/*
        return Ci;
    }
*/
    /* NO FUNCIONA
     * existeCita
     * Comprueba si existe una cita para un paciente concreto.
     * @param Dni, identificación del paciente a consultar.
     * @return True si existe cita, false en otro caso.
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

    /*
     * Ver Citas
     */
    public ArrayList VerCitas(Paciente pac) throws SQLException{
        return new ArrayList();
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
