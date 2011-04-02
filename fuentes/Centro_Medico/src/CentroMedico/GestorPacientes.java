/*
 * Paciente.java
 *
 * Informacion:
 * Clase encargada de operar con los pacientes
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package CentroMedico;

import java.io.*;

/**
 * @version     datos de la versión (numero y fecha)
 * @author      Sub_Equipo1
 */

public class GestorPacientes {


    PacBD bd_paciente=new PacBD();


/* Funcion encargada de solicitar el alta de un nuevo paciente
     *
     * @param nombre: Nombre del paciente
     * @param dni: Dni del paciente
     * @param bla bla
     *
     */
 public void altaPaciente (String Dni,String Nombre)throws Exception {

        Paciente nuevoPaciente=new Paciente(Dni,Nombre);
        bd_paciente.almacenaPaciente(nuevoPaciente);

    }

 public void buscarPaciente (String Dni)throws Exception {
        //bd_paciente.buscarPaciente(Dni);

    }

 /* Funcion encargada de modificar los datos de un paciente
     *
     * @param dni: Dni del paciente
     * @param nombre: Nombre del paciente
     * @param bla bla
     *
     */
/* public void modificarPaciente(String Dni, String Nombre) throws Exception{

        Modifica
        y Guarda otra vez el paciente en la BD.

    }*/


/****
 * 
 * ESTE MAIN NO EXISTIRA,ESTA SOLO PARA MOSTRAR EL FUNCIONAMIENTO.
 * 
 * EN LAS CLASES DE GESTION SOLO VAN METODOS.
 * LA INTERFAZ GRAFICA RECOGERA LOS DATOS Y LLAMARA A DICHOS METODOS
 * 
 * 
 ****/

/*public static void main(String args[]) {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String nombre,dni;

    try {

        System.out.println("Nombre del paciente a dar de alta:");
        nombre=in.readLine();
        System.out.println("DNI del paciente a dar de alta:");
        dni=in.readLine();

        altaPaciente(nombre,dni);

        //Consulta a la BD para mostrar que se ha creado

        System.out.println("Introduce el DNI del paciente a buscar");
        dni=in.readLine();
        //Me voy a la cama,mñn lo termino..
       // buscarPaciente(dni);
        //...



        

    }catch (Exception Exception){
        System.err.println(Exception);
    }

}*/

}
