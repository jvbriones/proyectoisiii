/**
 * Resonancia.java
 *
 * Informacion:
 * Clase encargada de modelizar una resonancia
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

public class Resonancia extends PruebaRadiologia{
    private Set<Imagen> Resonancias=new HashSet<Imagen>(0);

    public Resonancia() {
    }

    public Resonancia(String Comentario) {
        super(Comentario);
    }

    public Set<Imagen> getResonancias(){
        return Resonancias;
    }

    public void setResonancias(Set<Imagen> Resonancias) {
        this.Resonancias = Resonancias;
    }

    public void añadirImagen(Imagen Img){
        Resonancias.add(Img);
    }
}
