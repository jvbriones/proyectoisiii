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

import BaseDatos.FarmaceuticoBD;
import BaseDatos.PersonalMedicoBD;
import BaseDatos.UsuarioBD;
import CentroMedico.Farmaceutico;
import CentroMedico.PersonalMedico;
import CentroMedico.Turno;
import CentroMedico.Usuario;
import java.sql.SQLException;
import java.util.Date;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorPersonal {

    public boolean altaPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String TipoUsuario) throws SQLException {
        boolean existe;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        String Datos=new String();

        existe=bd_personal.existePersonal(Dni);

        if(!existe) {
             System.out.println("vamos a Introducirlo");
            String pas=new String();
            pas=generarContraseña();
            PersonalMedico personal=new PersonalMedico(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto, TipoUsuario);
            Turno tur=null;
            personal.setTurno(tur);
            bd_personal.almacenar(personal);

            Datos="Usuario Introducido con Éxito";
        }
        else {
            Datos="Usuario ya Existe";
        }

        return existe;

    }
    public boolean altaFarmaceutico(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String TipoUsuario) throws SQLException {
        boolean existe;
        FarmaceuticoBD bd_farmaceutico=new FarmaceuticoBD();
        String Datos=new String();

        existe=bd_farmaceutico.existe(Dni);

        if(!existe) {
             System.out.println("vamos a Introducirlo");
            String pas=new String();
            pas=generarContraseña();
            Farmaceutico personal=new Farmaceutico(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto);
            bd_farmaceutico.almacenar(personal);

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
        boolean existe;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        
        existe=bd_personal.existePersonal(Dni);
        return existe;
    }
       public boolean modificarPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Pass,String Telefono, Date FecNac, String LugarNac, byte[] Foto,String Tipo) throws SQLException {
        boolean exito;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        PersonalMedico personal=bd_personal.obtener(Dni);
        personal.actualizar(Dni, Nombre, Apellidos, Direccion, Email,Pass,Telefono, FecNac, LugarNac, Foto,Tipo);
        bd_personal.actualizar(personal);
        return true;
}
       public boolean modificarPersonalFarmacia(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Pass,String Telefono, Date FecNac, String LugarNac, byte[] Foto,String Tipo) throws SQLException {
        boolean exito;
        FarmaceuticoBD bd_personal=new FarmaceuticoBD();
        Farmaceutico personal=bd_personal.obtener(Dni);
        personal.actualizar(Dni, Nombre, Apellidos, Direccion, Email,Pass,Telefono, FecNac, LugarNac, Foto,Tipo);
        bd_personal.actualizar(personal);
        return true;
}
}
