/*
 * personalBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con el personal.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package BaseDatos;

import CentroMedico.Personal;
import CentroMedico.Radiologo;
import CentroMedico.Usuario;
import java.sql.*;
import org.hibernate.Session;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class personalBD {

    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";



   public boolean existePersonal(String Dni) throws SQLException {
        boolean existe;

       Personal Per= obtener(Dni);
       if (Per!=null){
           System.out.print("el tio existe\n");
           return true;
       }
       else{
           System.out.print( " el tio NO existe\n");
           return false;
       }
    }

    // Modificado con respecto al diseño
      public void almacenarPersonal(Personal Personal) {



         if (Personal.getTipoPersonal().equals("Radiologo")){

             Radiologo radiologo=new Radiologo(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             RadiologoBD rad=new RadiologoBD();
             rad.almacenar(radiologo);
         }
       


    }

       public Personal obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        System.out.println("llega");
        Personal Per = (Personal) session.get(Personal.class, Dni);
        System.out.println("no llega");
        return Per;
    }
}


