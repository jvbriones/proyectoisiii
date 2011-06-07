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

import BaseDatos.*;
import CentroMedico.*;
import java.sql.SQLException;
import java.util.Date;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2, Sub_Equipo3
 */

public class GestorPersonal {

    public boolean altaPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String TipoUsuario) throws Exception, SQLException {
        boolean existe;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        String Datos=new String();


        existe=bd_personal.existePersonal(Dni);

        if(!existe) {
             String pas=new String();
            pas=generarContraseña();
            String n=new String();
            n = AES.encrypt(pas);
            pas=LimpiarString(n);
            if(TipoUsuario=="Analista"){
                Analista personal=new Analista(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto);
                Turno tur=null;
                personal.setTurno(tur);
                AnalistaBD ana=new AnalistaBD();
                ana.almacenar(personal);
            }
            if(TipoUsuario=="Medico"){
                Medico personal=new Medico(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto);
                Turno tur=null;
                personal.setTurno(tur);
                MedicoBD medi=new MedicoBD();
                medi.almacenar(personal);
            }
            if(TipoUsuario=="Radiologo"){
                Radiologo personal=new Radiologo(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto);
                Turno tur=null;
                personal.setTurno(tur);
                RadiologoBD radi=new RadiologoBD();
                radi.almacenar(personal);
            }
            
            
           

            Datos="Usuario Introducido con Éxito";
        }
        else {
            Datos="Usuario ya Existe";
        }

        return existe;

    }
    
    private String LimpiarString(String s){
       String a= new String();
       for (int x=0; x < s.length(); x++) {
            if (s.charAt(x) != '\n')
                a += s.charAt(x);
        }
       return a;
   }

    public boolean altaFarmaceutico(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String TipoUsuario) throws Exception, SQLException {
        boolean existe;
        FarmaceuticoBD bd_farmaceutico=new FarmaceuticoBD();
        String Datos=new String();

        existe=bd_farmaceutico.existe(Dni);

        if(!existe) {
            String pas=new String();
            pas=generarContraseña();
            String n=new String();
            n = AES.encrypt(pas);
            pas=LimpiarString(n);
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

    public boolean modificarPersonal(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Pass,String Telefono, Date FecNac, String LugarNac, byte[] Foto,String Tipo) throws Exception, SQLException {
        boolean exito;
        PersonalMedicoBD bd_personal=new PersonalMedicoBD();
        PersonalMedico personal=bd_personal.obtener(Dni);
        String n=new String();
        String m=new String();
            n = AES.encrypt(Pass);
            m=LimpiarString(n);
        personal.actualizar(Dni, Nombre, Apellidos, Direccion, Email,m,Telefono, FecNac, LugarNac, Foto,Tipo);
        bd_personal.actualizar(personal);
        return true;
}

    public boolean modificarPersonalFarmacia(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Pass,String Telefono, Date FecNac, String LugarNac, byte[] Foto,String Tipo) throws Exception, SQLException {
        boolean exito;
        FarmaceuticoBD bd_personal=new FarmaceuticoBD();
        Farmaceutico personal=bd_personal.obtener(Dni);
        String n=new String();
        String m=new String();
            n = AES.encrypt(Pass);
            m=LimpiarString(n);
        personal.actualizar(Dni, Nombre, Apellidos, Direccion, Email,m,Telefono, FecNac, LugarNac, Foto,Tipo);
        bd_personal.actualizar(personal);
        return true;
}
}
