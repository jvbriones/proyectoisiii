package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase PersonalMedico en la base de datos.
 */
public class PersonalMedicoBD {

    //public Usuario obtenerUsuarioNombre(String nombre) throws SQLException {}

/*      public void almacenarPersonal(PersonalMedico Personal) {
         if (Personal.getTipo().equals("Radiologo")){
             Radiologo radiologo=new Radiologo(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             RadiologoBD rad=new RadiologoBD();
             rad.almacenar(radiologo);
         }

          if (Personal.getTipo().equals("Analista")){

             Analista ana=new Analista(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             AnalistaBD analis=new AnalistaBD();
             analis.almacenar(ana);
         }

         if (Personal.getTipo().equals("Medico")){

             System.out.println("Es un medico el que vamos a introducir");

             Medico med=new Medico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             MedicoBD medico=new MedicoBD();
             medico.almacenar(med);
         }

            if (Personal.getTipo().equals("Farmaceutico")){

            Farmaceutico farma =new Farmaceutico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             FarmaceuticoBD farmabd=new FarmaceuticoBD();
             farmabd.almacenar(farma);
         }
    }
*/
/*    public void actualizar (PersonalMedico Personal){
        if (Personal.getTipo().equals("Radiologo")){
             Radiologo radiologo=new Radiologo(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             RadiologoBD rad=new RadiologoBD();
             rad.actualizar(radiologo);
         }

          if (Personal.getTipo().equals("Analista")){

             Analista ana=new Analista(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             AnalistaBD analis=new AnalistaBD();
             analis.actualizar(ana);
         }

         if (Personal.getTipo().equals("Medico")){

             System.out.println("Es un medico el que vamos a introducir");

             Medico med=new Medico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             MedicoBD medico=new MedicoBD();
             medico.actualizar(med);
         }

            if (Personal.getTipo().equals("Farmaceutico")){

            Farmaceutico farma =new Farmaceutico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             FarmaceuticoBD farmabd=new FarmaceuticoBD();
             farmabd.actualizar(farma);
         }
    }
*/
/*    public void eliminar(PersonalMedico Personal){
        if (Personal.getTipo().equals("Radiologo")){
             Radiologo radiologo=new Radiologo(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             RadiologoBD rad=new RadiologoBD();
             rad.eliminar(radiologo);
         }

          if (Personal.getTipo().equals("Analista")){

             Analista ana=new Analista(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             AnalistaBD analis=new AnalistaBD();
             analis.eliminar(ana);
         }

         if (Personal.getTipo().equals("Medico")){

             System.out.println("Es un medico el que vamos a introducir");

             Medico med=new Medico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             MedicoBD medico=new MedicoBD();
             medico.eliminar(med);
         }

            if (Personal.getTipo().equals("Farmaceutico")){

            Farmaceutico farma =new Farmaceutico(Personal.getDNI(),Personal.getNombre(),Personal.getApellidos(),Personal.getDireccion(),Personal.getEmail(),Personal.getContrasenia(),Personal.getTelefono(),Personal.getFecNac(),Personal.getLugarNac(),Personal.getFoto());
             FarmaceuticoBD farmabd=new FarmaceuticoBD();
             farmabd.eliminar(farma);
         }
    }

       public boolean existePersonal(String Dni) throws SQLException {

       PersonalMedico Per= obtener(Dni);
       if (Per!=null){
           System.out.print("el tio existe\n");
           return true;
       }
       else{
           System.out.print( " el tio NO existe\n");
           return false;
       }
    }
*/
    public void eliminar(PersonalMedico PersonalMedico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (PersonalMedico);
        session.getTransaction().commit();

    }

    public PersonalMedico obtener(String Dni){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        PersonalMedico PersonalMedico = (PersonalMedico) session.get(PersonalMedico.class, Dni);
        session.getTransaction().commit();
       return PersonalMedico;
    }

    public void almacenar(PersonalMedico PersonalMedico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (PersonalMedico);
        session.getTransaction().commit();
    }

    public void actualizar (PersonalMedico PersonalMedico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (PersonalMedico);
        session.getTransaction().commit();
    }

}
