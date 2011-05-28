/*
 * CitasBD
 *
 * Mayo 2011
 *
 * Sub-equipo 3
 */

package BaseDatos;

import CentroMedico.Cita;
import java.sql.*;
import org.hibernate.*;

public class CitasBD {
    String IpDelServidor = "localhost";
    String NombreDB = "CentroMedico";
    String user = "generico";
    String pass = "generico";


    public String altaCita(Date fechaIni, Date fechaFin){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Date inicio = fechaIni;
        inicio.setHours(8); //Iniciar a las 8.00AM
        
        session.beginTransaction();
        
        while(inicio.compareTo(fechaFin) < 0){



            if(inicio.getHours() == 20)
                inicio.setDate(inicio.getDate() + 1);
            else
                inicio.setHours(inicio.getHours()+1);
        }

        return "Yeyo";
    }


    /*
     * almacenarCita
     * Dado un objeto Cita, lo almacena en la base de datos.
     * @param cita, Objeto Cita a almacenar
     * @post No ofrece información sobre el estado de la operacion
     */
    public void almacenar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();
    }

    
    /*
     * obtenerCita
     * Obtiene la cita relativa a un usuario dado.
     * @param Dni, Identificación del paciente del que obtener la cita.
     * @return El objeto Cita oportuno o un objeto null.
     */
    public Cita obtenerCita(String Dni) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Cita ci = (Cita) session.get(Cita.class, Dni);
        
        return ci;
    }


    /*
     * actualizar
     * Actualiza una cita existente.
     * @param cita, Objeto cita que es consultado.
     * @post No aporta información sobre la realización de la operación.
     */
    public void actualizar(Cita cita){
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

   
    /*
     * eliminar
     * Elimina un objeto Cita de la base de datos.
     * @param ci, Objeto Cita a eliminar.
     * @post No se recibe información del procesado de la operación.
     */
    public void eliminar(Cita ci){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(ci);
        session.getTransaction().commit();
    }

    /*
     * existeCita
     * Comprueba si existe una cita para un paciente concreto.
     * @param Dni, identificación del paciente a consultar.
     * @return True si existe cita, false en otro caso.
     */
    public boolean existeCita(String Dni) throws SQLException {
        Cita cit = obtenerCita(Dni);

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
