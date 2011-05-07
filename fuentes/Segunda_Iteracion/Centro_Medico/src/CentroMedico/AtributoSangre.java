/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

/**
 *
 * @author pope
 */
public class AtributoSangre {
    private String Nombre;

    public AtributoSangre() {
    }

    public AtributoSangre(String Nom){
        this.Nombre = Nom;
    }


    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
}
