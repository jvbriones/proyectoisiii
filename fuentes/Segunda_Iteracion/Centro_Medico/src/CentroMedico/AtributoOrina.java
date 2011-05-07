/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.io.Serializable;

/**
 *
 * @author pope
 */
public class AtributoOrina implements Serializable{
    private String Nombre;

    public AtributoOrina() {
    }

    public AtributoOrina(String Nom){
        this.Nombre=Nom;
    }


    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
}
