/*
 * Personal.java
 *
 * Informacion:
 * Clase encargada de modelizar al personal del Centro Medico
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
public abstract class Personal {

   private String dni;
   private String nombre;
   private String apellidos;
   private String domicilio;
   private String telefono;
   private String email;
   private String fechaNacimiento; //Seria de tipo Date pero me pitaba..
   private String lugarNacimiento;
   private String fotografia; //ya veremos como hacemos esto..
   //private Turno turno=null;



   /**
    *Este constructor es llamado por el constructor de los medicos,especialistas,etc..
    * Mirar codigo del Medico
    */

    Personal(String dnei,String nom) {
        dni=dnei;
        nombre=nom;
        //etc..
        //turno=null;
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
                                        //Posibles metodos
    //abstract double NoseMeOcure();
            //Estoy empezando a pensar que si no tienen un metodo abstracto en comun..
            //Es porque no deberia estar representado así, quizas en vez de ser
            //una generalizacion deberian de estar en un paquete, y cada uno por su cuenta.

            //Porque una cosa en comun serian las citas asignadas, pero no todo el personal tiene..

   /* void estableceTurno(Turno tur){
        turno=tur;
    }*/

    //etc


}
