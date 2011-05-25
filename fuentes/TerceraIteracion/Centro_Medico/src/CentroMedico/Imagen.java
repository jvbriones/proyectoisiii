/**
 * Imagen.java
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
import java.io.Serializable;

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
