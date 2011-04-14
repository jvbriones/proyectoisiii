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

    private String DNI=null;
    private String Nombre=null;
    private String Apellidos=null;
    private String Direccion=null;
    private String Email=null;
    private String Contrasena=null;
    private String Telefono=null;
    private Date FecNac=null;
    private String LugarNac=null;
    private String Foto=null;
    private String Tipo=null;

    /*
     *
     * Constructores
     *
     */
   
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
    
    public String getDni(){
        return DNI;
    }

    public String getNombre(){
        return  Nombre;
     }

    public String getApellidos(){
        return Apellidos;
    }

    public String getDireccion(){
        return  Direccion;
     }

    public String getEmail(){
        return Email;
    }

    public String getContrasena(){
        return  Contrasena;
     }

    public String getTelefono(){
        return  Telefono;
     }

    public Date getFechaNacimiento(){
        return FecNac;
    }

    public String getLugarNacimiento(){
        return  LugarNac;
    }

    public String getFotografia(){
        return  Foto;
    }

     public String getTipo(){
        return Tipo;
    }

     /*
      *
      * Metodos Asignadores
      *
      */

    public void setDni(String Dni){
        this.DNI=Dni;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public void setApellidos(String Apellidos){
        this.Apellidos=Apellidos;
    }

    public void setDireccion(String Direccion){
        this.Direccion=Direccion;
    }

    public void setEmail(String Email){
        this.Email=Email;
    }

    public void setContrasena(String Contrasena){
        this.Contrasena=Contrasena;
    }

    public void setTelefono(String Telefono){
        this.Telefono=Telefono;
    }

    public void setFechaNacimiento(Date FecNac){
        this.FecNac=FecNac;
    }

    public void setLugarNacimiento(String LugarNac){
        this.LugarNac=LugarNac;
    }

    public void setFotografia(String Foto){
       this.Foto=Foto;
    }

    public void setTipo(String Tipo){
       this.Tipo=Tipo;
    }


}
