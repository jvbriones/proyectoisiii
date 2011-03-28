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

    Paciente(String dnei,String nom) {
        dni=dnei;
        nombre=nom;
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
    
    void setDni(String d){
        dni=d;
    }

    void setNombre(String n){
        nombre=n;
    }

   /* void estableceMedico(Medico med){     //Esto son posibles operaciones
        medico=med;
    }*/

    /*void quitaMedico(Medico med) {        
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

