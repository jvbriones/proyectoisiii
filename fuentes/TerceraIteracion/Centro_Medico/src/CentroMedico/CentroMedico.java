/**
 * CentroMedico.java
 *
 * Informacion:
 * Clase encargada de modelizar un centro médico
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class CentroMedico implements Serializable{
    private String Nombre;
    private String CIF;
    private String Direccion;
    private String Telefono;
    private String Fax;
    private String email;

    private Set<Usuario> Usuarios = new HashSet<Usuario>(0);

        /*
     *
     * Constructores
     *
     */

    public CentroMedico() {
    }

    public CentroMedico(String Nombre, String CIF, String Direccion,String Telefono, String Fax, String email){

        this.Nombre=Nombre;
        this.CIF=CIF;
        this.Direccion=Direccion;
        this.Telefono=Telefono;
        this.Fax=Fax;
        this.email=email;
    }

    /*
     *
     * Metodos Consultores
     *
     */

    public String getNombre(){
        return  Nombre;
     }

    public String getCIF(){
        return CIF;
    }

    public String getDireccion(){
        return  Direccion;
     }

    public String getEmail(){
        return email;
    }

    public String getTelefono(){
        return  Telefono;
     }

    public String getFax(){
        return  Fax;
    }

    public Set<Usuario> getUsuarios() {
        return Usuarios;
    }

     /*
      *
      * Metodos Asignadores
      *
      */

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }

    public void setCIF(String CIF){
        this.CIF=CIF;
    }

    public void setDireccion(String Direccion){
        this.Direccion=Direccion;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setTelefono(String Telefono){
        this.Telefono=Telefono;
    }

    public void setFax(String Fax){
        this.Fax=Fax;
    }
    public void setUsuarios(Set<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
}
