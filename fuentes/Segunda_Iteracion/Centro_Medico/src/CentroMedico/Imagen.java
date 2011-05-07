/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.io.Serializable;

/**
 *
 * @author Juan Carlos
 */
public class Imagen implements Serializable{
    private String Ruta;

    public Imagen() {
    }

    public Imagen(Imagen aux) {
        this.Ruta = aux.Ruta;
    }

    public String getRuta(){
        return Ruta;
    }

    public void setRuta( String Ruta){
        this.Ruta=Ruta;
    }
}
