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
import BaseDatos.PacBD;
import java.sql.*;
import org.hibernate.*;
import java.util.*;
import java.util.Date;

public class CitasBD {
    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

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
    public void Almacenar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();
    }

    /*  NO FUNCIONA!
     * obtenerCita
     * Obtiene la cita relativa a un usuario dado.
     * @param Dni, Identificación del paciente del que obtener la cita.
     * @return El objeto Cita oportuno o un objeto null.
     */
    public Cita ObtenerCita(Paciente pac) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        //Cita Ci = (Cita) session.get(Cita.class, pac);        /*****ESTO PETA******/

        Date hora = new Date();           /* PARCHE */

        //PacBD pac = new PacBD();
        personalBD per = new personalBD();
        Cita Ci = new Cita(true, hora, "Tarde", pac, per.obtener("33333333A")); /* PARCHE */

        return Ci;
    }

    /* SIN HACER
     * actualizar
     * Actualiza una cita existente.
     * @param cita, Objeto cita que es consultado.
     * @post No aporta información sobre la realización de la operación.
     */
    public void Actualizar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        try{
            session.update(cita);
            System.out.println("Cita actualizada correctamente.");
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        session.getTransaction().commit();

    }

    /* NO FUNCIONA
     * eliminar
     * Elimina un objeto Cita de la base de datos.
     * @param ci, Objeto Cita a eliminar.
     * @post No se recibe información del procesado de la operación.
     */
    public void Eliminar(Cita ci){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(ci); /* NO FUNCIONA */
        session.getTransaction().commit();
    }

    /* NO FUNCIONA
     * existeCita
     * Comprueba si existe una cita para un paciente concreto.
     * @param Dni, identificación del paciente a consultar.
     * @return True si existe cita, false en otro caso.
     */
    public boolean ExisteCita(Paciente pac) throws SQLException {
        Cita cit = ObtenerCita(pac);

        if (cit != null){
            System.out.print("ExisteCita: Existe la Cita");
            return true;
       }
       else{
           System.out.print("ExisteCita: No existe la cita");
           return false;
       }
    }

}
