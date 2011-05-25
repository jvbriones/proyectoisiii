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

package Controlador;

import BaseDatos.PacBD;
import CentroMedico.Paciente;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorPacientes {

    public boolean altaPaciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, String Foto, String TipoUsuario) throws SQLException {
        boolean existe;
        PacBD bd_paciente=new PacBD();
        String Datos=new String();

        existe=bd_paciente.existePaciente(Dni);

        if(!existe) {
            String pas=new String();
            pas=generarContraseña();
            Paciente paciente=new Paciente(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto, TipoUsuario);
            bd_paciente.almacenarPaciente(paciente);

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
    
    public Paciente obtenerPaciente(String Dni) throws SQLException{
    
        PacBD pac = new PacBD();
        Paciente p= new Paciente();

        System.out.println("antes de obtener paciente");
        
        p = pac.obtener(Dni);
        return p;
        
        
    }

}
