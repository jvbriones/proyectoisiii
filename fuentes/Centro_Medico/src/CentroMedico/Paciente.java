/*
 * Paciente.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Pacientes
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.util.*;

/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */

public class Paciente extends Usuario {
  


    public Paciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Foto){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, "Paciente");
    }

    public Paciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, Tipo);
    }
    

}
