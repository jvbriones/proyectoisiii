/*
 * GestorUsuarios.java
 *
 * Informacion:
 * Clase encargada de operar con los usuarios
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package CentroMedico;

import java.io.*;
import java.sql.SQLException;

/**
 * @version     v1.0    01/04/2011
 * @author      Sub_Equipo1
 */
public class GestorUsuarios {

    private Usuario user=new Usuario();
    usuarioBD usuario_bd=new usuarioBD();

    /* Función encargada de la validación de un usuario a través de su contraseña.
     *
     * @param Dni: Dni del usuario
     * @param Pass: Contraseña del usuario
     *
     */
    public Boolean validacionUsuario(String Dni, String Pass) throw Exception throws SQLException{
        Boolean acceso;
        acceso=usuarioBD.validacion(Dni, Pass);

        if(!acceso) {
            throw new Exception("Usuario o contraseña erroneos");
        }
        else {
            user=usuarioBD.obtenerUsuario(Dni);
        }

        return acceso;

    }

}
