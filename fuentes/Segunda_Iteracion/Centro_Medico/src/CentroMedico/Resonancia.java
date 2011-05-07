/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author pope
 */
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
