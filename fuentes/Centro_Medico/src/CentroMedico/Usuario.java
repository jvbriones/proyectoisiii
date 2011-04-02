/*
 * Usuario.java
 *
 * Informacion:
 * Clase encargada de modelizar a los usuarios
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */


package CentroMedico;

import java.util.*;
import java.awt.*;

/**
 * @version     v1.0    01/04/2011
 * @author      Sub_Equipo1
 */
public class Usuario {

    private String Nombre;
    private String Apellidos;
    private String DNI;
    private String Direccion;
    private String Email;
    private String Contrasena;
    private String Telefono;
    private Date FecNac;
    private String LugarNac;
    private Image Foto;
    private String Tipo;

    public Usuario(){
        this.DNI=null;
        this.Nombre=null;
        this.Apellidos=null;
        this.Direccion=null;
        this.Email=null;
        this.Contrasena=null;
        this.Telefono=null;
        this.FecNac=null;
        this.LugarNac=null;
        this.Foto=null;
        this.Tipo=null;
    }

    public Usuario(String Dni, String Nombre, String Apellidos, String Direccion, String Email, String Contrasena, String Telefono, Date FecNac, String LugarNac, Image Foto, String Tipo){
        this.DNI=Dni;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Direccion=Direccion;
        this.Email=Email;
        this.Contrasena=Contrasena;
        this.Telefono=Telefono;
        this.FecNac=FecNac;
        this.LugarNac=LugarNac;
        this.Foto=Foto;
        this.Tipo=Tipo;
    }

}
