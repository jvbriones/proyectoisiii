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
public class Medico extends Personal{

  // private List Citas = null;
 //El modelado está fatal,han puesto que solo tienen citas los medicos,cuando los especialistas tb tienen..

   Medico(String Dni,String Nom){
     super(Dni,Nom);
    // Citas=null;
   }

   /*void añadeCita(Cita cit)throws Exception{
       if(no puedo trabajar mas)
           throw new Exception ("Estoy hasta los huevos y no cojo mas pacientes");
       else
           Citas.add(cit);
   }*/



}
