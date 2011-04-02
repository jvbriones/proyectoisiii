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

import java.sql.SQLException;

/**
 * @version     1.0    02/04/2011
 * @author      Sub_Equipo1
 */

public class GestorUsuarios {

    private Usuario user = null;
    usuarioBD usuario_bd = new usuarioBD();



    /* Función encargada de la validación de un usuario a través de su contraseña.
     *
     * @param Dni: Dni del usuario
     * @param Pass: Contraseña del usuario
     *
     */
    public Boolean validacionUsuario(String Dni, String Pass) throws SQLException, Exception {
        Boolean acceso;
        acceso=usuario_bd.validacion(Dni, Pass);

        if(!acceso) {
            throw new Exception("Usuario o contraseña erroneos");
        }
        else {
            user=usuario_bd.obtenerUsuario(Dni);
        }

        return acceso;

    }

   /* modificarDatosPersonalesAdmin()

    modificarDatosPersonales()

    consultarDatosPersonalesAdmin()

    consultarDatosPersonales()*/



}
