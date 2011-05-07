/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

/**
 *
 * @author Juan Carlos
 */
public class Imagen {
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
