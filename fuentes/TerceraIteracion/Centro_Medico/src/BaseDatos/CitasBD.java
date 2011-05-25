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
     */
    public boolean existeCita(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT DniPaciente FROM Citas WHERE DniPaciente='"+Dni+"' And Estado=true";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            existe=true;
        }
        else {
            existe=false;
        }
        conexion.closeConnection();
        return existe;
    }

    /*
     * almacenarCita
     * Dado un objeto Cita, lo almacena en la base de datos.
     * HAY QUE CAMBIARLA A HIBERNATE
     */
    public void almacenarCita(Cita cita) {
        String dni=cita.getPaciente().getDNI();
        String dniM=cita.getPersonalMedico().getDNI();
        Date fecha=(Date) cita.getFecha();
        boolean estado=cita.getEstado();


        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "INSERT INTO Citas VALUES ('"+dni+"','"+dniM+"',"+fecha+","+estado+")";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    /*
     * obtenerCita
     * Obtiene la cita relativa a un usuario dado.
     * HAY QUE CAMBIARLA A HIBERNATE
     */
    public Cita obtenerCita(String Dni) throws SQLException {
        Cita cita=new Cita();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT * FROM Citas WHERE DniPaciente='"+Dni+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("DniPaciente");
            String dniM=rs.getString("DniMedico");
            Date fecha=rs.getDate("Fecha");
            boolean estado=rs.getBoolean("Estado");

//Esta línea se ha puesto entre comentarios porque es incoherente con el nuevo constructor.
//            cita = new Cita(dni, dniM, fecha, estado);
        }
        else{
            cita= null;
        }
        conexion.closeConnection();
        return cita;
    }

    /*  (OPCIONAL)
     * EstadisticasCitas
     * Muestra las estadisticas relativas a las citas
     * HABRIA QUE CAMBIARLA A HIBERNATE
     */
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
    
    /*
     * almacenar
     * Guarda un objeto Cita en la base de datos.
     * @param cita, Objeto Cita que es insertado
     */
    public void almacenar(Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( cita );
        session.getTransaction().commit();
    }

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
     * eliminar
     * Elimina una cita existente.
     * @param cita, Objeto cita que es eliminado.
     */
    public void eliminar (Cita cita){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete ( cita );
        session.getTransaction().commit();
    }
}
