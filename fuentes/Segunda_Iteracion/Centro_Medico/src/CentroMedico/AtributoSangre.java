/**
 * AtributoSangre.java
 *
 * Informacion:
 * Clase encargada de modelizar un atributo correspondiente a un análisis de sangre
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.io.Serializable;

public class AtributoSangre implements Serializable{
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
