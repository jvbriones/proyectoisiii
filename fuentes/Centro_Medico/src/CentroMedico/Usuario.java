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

/**
 * @version     v1.0    01/04/2011
 * @author      Sub_Equipo1
 */

public class Usuario {

    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Direccion;
    private String Email;
    private String Contrasena;
    private String Telefono;
    private Date FecNac;
    private String LugarNac;
    private String Foto; //ya veremos como hacemos lo de la foto..
    private String Tipo;

    /*
     *
     * Constructores
     *
     */
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

    public Usuario(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){
        
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

    /*
     * 
     * Metodos Consultores
     *
     */
    
    String getDni(){
        return DNI;
    }

    String getNombre(){
        return  Nombre;
     }

    String getApellidos(){
        return Apellidos;
    }

    String getDireccion(){
        return  Direccion;
     }

    String getEmail(){
        return Email;
    }

    String getContrasena(){
        return  Contrasena;
     }

    String getTelefono(){
        return  Telefono;
     }

    Date getFechaNacimiento(){
        return FecNac;
    }

    String getLugarNacimiento(){
        return  LugarNac;
    }

    String getFotografia(){
        return  Foto;
    }

     String getTipo(){
        return Tipo;
    }

     /*
      *
      * Metodos Asignadores
      *
      */

    void setDni(String Dni){
        this.DNI=Dni;
    }

    void  setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    void  setApellidos(String Apellidos){
        this.Apellidos=Apellidos;
    }

    void  setDireccion(String Direccion){
        this.Direccion=Direccion;
    }
    void  setEmail(String Email){
        this.Email=Email;
    }

    void  setContrasena(String Contrasena){
        this.Contrasena=Contrasena;
    }

    void  setTelefono(String Telefono){
        this.Telefono=Telefono;
    }

    void  setFechaNacimiento(Date FecNac){
        this.FecNac=FecNac;
    }

    void  setLugarNacimiento(String LugarNac){
        this.LugarNac=LugarNac;
    }

    void  setFotografia(String Foto){
       this.Foto=Foto;
    }

    void  setTipo(String Tipo){
       this.Tipo=Tipo;
    }


}
