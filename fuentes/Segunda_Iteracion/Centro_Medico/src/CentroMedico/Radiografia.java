/**
 * Radiografia.java
 *
 * Informacion:
 * Clase encargada de modelizar una radiografía
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

public class Radiografia extends PruebaRadiologia{
    private Set<Imagen> Radiografias=new HashSet<Imagen>(0);

    public Radiografia() {
    }

    public Radiografia(String Comentario, Paciente Pac, PersonalMedico Rad) {
        super(Comentario, Pac, Rad);

    }

    public Set<Imagen> getRadiografias(){
        return Radiografias;
    }

    public void setRadiografias(Set<Imagen> Radiografias){
        this.Radiografias=Radiografias;
    }

    public void añadirImagen(Imagen Img){
        Radiografias.add(Img);
    }
}
