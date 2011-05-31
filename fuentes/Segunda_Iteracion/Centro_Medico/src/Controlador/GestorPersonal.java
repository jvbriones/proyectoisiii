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

package Controlador;

import CentroMedico.*;
import BaseDatos.*;
import java.sql.SQLException;
import java.util.Date;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorPersonal {

    public boolean altaPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, String Foto, String TipoUsuario) throws SQLException {
        boolean existe=true;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        PersonalMedico pm =null;

        String Datos=new String();


        pm = bd_personal.obtener(Dni);
        if( pm ==null)
            existe =false;


        if(!existe) {
            String pas=new String();
            pas=generarContraseña();
            PersonalMedico personal=new PersonalMedico(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto, TipoUsuario);
            bd_personal.almacenar(personal);

            Datos="Usuario Introducido con Éxito";
        }
        else {
            Datos="Usuario ya Existe";
        }

        return existe;

    }

    private String generarContraseña() {
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

    public boolean existePersonal(String Dni) throws SQLException {
        boolean existe=true;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        PersonalMedico pm = null;


        pm=bd_personal.obtener(Dni);
        if(pm==null)
            return false;
        else
            return true;
    }
}
