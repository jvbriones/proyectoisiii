/*
 * turnoBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los turnos.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * modificado por Juan Carlos Bermúdez. Añadidas las funciones almacenar, actualizar, eliminar y obtener
 */
package BaseDatos;

import CentroMedico.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.*;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class TurnoBD {

    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

    public boolean existeTurno(String Dni) throws SQLException {
         Turno tur = obtener(Dni);

        if (tur != null){
            System.out.print("ExisteTurno: Existe el Turno");
           return true;
       }
       else{
           System.out.print( "ExisteTurno: No existe el turno\n");
           return false;
       }
    }

    public void altaTurno(String Dni,String Tipo,Date ini,Date fin) {

        Turno tur=new Turno();

        if (Tipo.equals("Mañana")){
            tur.setTipo("Mañana");
        }

         if (Tipo.equals("Tarde")){
            tur.setTipo("Tarde");
        }

         if (Tipo.equals("Noche")){
            tur.setTipo("Noche");
    }

            tur.setFechaInicio(ini);
            tur.setFechaFin(fin);
            tur.setDni(Dni);
            
            System.out.println(" El turno tiene dni = "+tur.getDni());

         Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(tur);
        session.getTransaction().commit();

    }

    public void borraTurno(String Dni) throws SQLException {

             Turno tur=obtener(Dni);


            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction ();
            session.delete (tur);
            session.getTransaction().commit();
        
    }
    
 

     public Turno obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
 
       Turno tur = (Turno) session.get(Turno.class, Dni);
        return tur;
    }



    public void actualizar (Turno turno){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update ( turno );
        session.getTransaction().commit();
    }


}
