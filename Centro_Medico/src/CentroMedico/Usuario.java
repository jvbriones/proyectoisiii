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
import java.io.Serializable;

import java.util.*;
import java.sql.SQLException;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos Bermúdez
 */
public class Usuario implements Serializable{


    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Direccion;
    private String Email;
    private String Contrasenia;
    private String Telefono;
    private Date FecNac;
    private String LugarNac;
    private byte[] Foto;
    private String Tipo;


    /*
     *
     * Constructores
     *
     */

    /*
        Constructor por defecto de la clase Usuario. Pone todos sus atributos como NULL.
     */
    public Usuario() {
    }


    /**
     * Constructor por parámetros de la clase Usuario.
     * Da el valor de entrada a cada uno de los parámetros.
     * Este constructor inicializa todos los atributos de la clase.
     */
    public Usuario(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String Tipo){
   
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
        return this.DNI;
    }

    public String getNombre(){
        return  this.Nombre;
     }

    public String getApellidos(){
        return this.Apellidos;
    }

    public String getDireccion(){
        return  this.Direccion;
     }

    public String getEmail(){
        return this.Email;
    }

    public String getContrasenia(){
        return  this.Contrasenia;
     }

    public String getTelefono(){
        return  this.Telefono;
     }

    public Date getFecNac(){
        return this.FecNac;
    }

    public String getLugarNac(){
        return  this.LugarNac;
    }

    public byte[] getFoto(){
        return  this.Foto;
    }

     public String getTipo(){
        return this.Tipo;
    }

     /*
      *
      * Metodos Asignadores
      *
      */

    public void setDNI(String Dni){
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

    public void setFoto(byte[] Foto){
       this.Foto=Foto;
    }

    public void setTipo(String Tipo){
       this.Tipo=Tipo;
    }

}
