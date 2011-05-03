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
import java.sql.SQLException;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */
public class Usuario {

    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Direccion=null;
    private String Email=null;
    private String Contrasenia=null;
    private String Telefono=null;
    private Date FecNac=null;
    private String LugarNac=null;
    private String Foto=null;
    private String Tipo;


    /*
     *
     * Constructores
     *
     */
    public Usuario(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){
        
        this.DNI=Dni;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Direccion=Direccion;
        this.Email=Email;
        this.Contrasenia=Contrasenia;
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
    
    public String getDNI(){
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

    public String getContrasenia(){
        return  Contrasenia;
     }

    public String getTelefono(){
        return  Telefono;
     }

    public Date getFecNac(){
        return FecNac;
    }

    public String getLugarNac(){
        return  LugarNac;
    }

    public String getFoto(){
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

    public void setDNI(String Dni) throws SQLException{
        this.DNI=Dni;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
        System.out.println(Nombre);

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

    public void setContrasenia(String Contrasenia){
        this.Contrasenia=Contrasenia;
    }

    public void setTelefono(String Telefono){
        this.Telefono=Telefono;
    }

    public void setFecNac(Date FecNac){
        this.FecNac=FecNac;
    }

    public void setLugarNac(String LugarNac){
        this.LugarNac=LugarNac;
    }

    public void setFoto(String Foto){
       this.Foto=Foto;
    }

    public void setTipo(String Tipo){
       this.Tipo=Tipo;
    }

}
