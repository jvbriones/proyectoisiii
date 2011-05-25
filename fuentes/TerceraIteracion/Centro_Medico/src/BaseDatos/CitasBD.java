package BaseDatos;

import CentroMedico.Cita;
import java.sql.*;
import java.util.ArrayList;
import org.hibernate.*;

public class CitasBD {
    String IpDelServidor = "localhost";
    String NombreDB = "CentroMedico";
    String user = "generico";
    String pass = "generico";

    /*
     * existencia
     * Comprueba si existen citas para un paciente concreto.
     * HAY QUE CAMBIARLA A HIBERNATE
     *
     * Miguel-> Juanmi, Ya está cambiada
     */
    public boolean existeCita(String Dni) throws SQLException {
         Cita ci = obtenerCita(Dni);

        if (ci != null){
            System.out.print("ExisteCita: Existe la Cita");
           return true;
       }
       else{
           System.out.print( "ExisteCita: No existe la cita\n");
           return false;
       }
    }

    /*
     * almacenarCita
     * Dado un objeto Cita, lo almacena en la base de datos.
     * HAY QUE CAMBIARLA A HIBERNATE
     *
     * Miguel-> Juanmi, Ya está cambiada
     */

    public void almacenar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( cita );
        session.getTransaction().commit();
    }
 

    /*
     * obtenerCita
     * Obtiene la cita relativa a un usuario dado.
     * HAY QUE CAMBIARLA A HIBERNATE
     * Miguel.  Ya está cambiada
     */
    public Cita obtenerCita(String Dni) throws SQLException {

         
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cita ci = (Cita) session.get(Cita.class, Dni);
        return ci;
    
    }

    /*  (OPCIONAL)
     * EstadisticasCitas
     * Muestra las estadisticas relativas a las citas
     * HABRIA QUE CAMBIARLA A HIBERNATE
   
    public ArrayList EstadisticasCitas(Date fecha_inicio, Date fecha_fin) throws SQLException {
        ArrayList datosAdmin = new ArrayList();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Citas WHERE "+fecha_inicio+"<Fecha AND Fecha<"+fecha_fin;
        ResultSet rs = conexion.consultaSelect(Consulta);
        while(rs.next()) {
            String dni=rs.getString("DniPaciente");
            String dniM=rs.getString("DniMedico");
            Date fecha=rs.getDate("Fecha");
            boolean estado=rs.getBoolean("Estado");
            String dniA=rs.getString("DniAdministrativoCita");

            datosAdmin.add(dni);
            datosAdmin.add(dniM);
            datosAdmin.add(fecha);
            datosAdmin.add(estado);
            datosAdmin.add(dniA);

        }
        return datosAdmin;
    }
     *   */
     
    
   

    /*
     * actualizar
     * Actualiza una cita existente.
     * @param cita, Objeto cita que es consultado.
     */
    public void actualizar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( cita );
        session.getTransaction().commit();
    }

   
     /*
      * Miguel. Creada Eliminar Cita
     * eliminar
     * Elimina un objeto Cita de la base de datos.
     */
    public void eliminar(Cita ci){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (ci);
        session.getTransaction().commit();
    }
}
