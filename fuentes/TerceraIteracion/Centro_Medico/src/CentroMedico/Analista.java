/*
 * Analista.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Analistas
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.util.*;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos Bermúdez
 */

public class Analista extends PersonalMedico{

    public Analista(String Dni, String Nombre, String Apellidos, String Direccion, String Email, String Contrasena,
            String Telefono, Date FecNac, String LugarNac, byte[] Foto) {

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, "Analista");

    }

    public Analista() {
    }



}
