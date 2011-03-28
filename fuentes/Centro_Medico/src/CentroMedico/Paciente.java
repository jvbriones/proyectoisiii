/*
 * Paciente.java
 *
 * Informacion:
 * Clase encargada de modelizar a los pacientes
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

/**
 * @version     datos de la versión (numero y fecha)
 * @author      Sub_Equipo1
 */

public class Paciente {

   private String dni;
   private String nombre;
  /* private String apellidos;
   private String domicilio;
   private String telefono;
   private String email;
   private String fechaNacimiento; //Seria de tipo Date pero me pitaba..
   private String lugarNacimiento;
   private String fotografia; //ya veremos como hacemos esto..
   private Medico medico=null;
   private Citas cita=null;*/

    Paciente(String Dni,String Nom) {
        dni=Dni;
        nombre=Nom;
        //etc..
        //medico=null;
        //cita=null;
    }

    String getDni(){
        return this.dni;
    }

    String getNombre(){
        return  this.nombre;
     }
    
    void setDni(String Dni){
        dni=Dni;
    }

    void setNombre(String Nom){
        nombre=Nom;
    }

   /* void estableceMedico(Medico Med){     //Esto son posibles operaciones
        medico=Med;
    }*/

    /*void quitaMedico(Medico Med) {
        medico=null;
    }*/

     /* String dimeDniMedico(){
        return (medico.getDni());
    }*/

    /* boolean tieneCita(){
        if(cita!=null)
            return true;
        else  return false;
    }*/

    
   
}

