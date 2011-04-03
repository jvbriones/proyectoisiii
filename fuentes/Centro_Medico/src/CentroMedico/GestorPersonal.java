/*
 * GestorPersonal.java
 *
 * Informacion:
 * Clase encargada de operar con el personal
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.sql.SQLException;
import java.util.Date;

/**
 * @version     1.0    02/04/2011
 * @author      Sub_Equipo1
 */

public class GestorPersonal {


    personalBD bd_personal=new personalBD();

    public Boolean altaPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, String Foto, String TipoUsuario) throws SQLException {
        Boolean existe;
        String Datos;

        existe=bd_personal.existePersonal(Dni);

        if(!existe) {
            String pas;
            pas=generarContraseña();
            Personal personal=new Personal(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto, TipoUsuario);
            bd_personal.almacenarPersonal(personal);

            Datos="Usuario Introducido con Éxito";
        }
        else {
            Datos="Usuario ya Existe";
        }

        return existe;

    }

    public String generarContraseña() {
        String numeros = "0123456789";
	String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String minusculas = "abcdefghijklmnopqrstuvwxyz";
        int tama=8;

        String contrasena = "";

        for (int i = 0; i < tama; i++) {
                contrasena+=((numeros+mayusculas+minusculas).charAt((int)(Math.random() * (numeros+mayusculas+minusculas).length())));
        }

        return contrasena;
    }

    public Boolean existePersonal(String Dni) throws SQLException {
        Boolean existe;
        existe=bd_personal.existePersonal(Dni);
        return existe;
    }
}
