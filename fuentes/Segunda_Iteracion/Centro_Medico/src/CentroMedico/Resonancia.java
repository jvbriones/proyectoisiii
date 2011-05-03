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
public class Resonancia {
    private Set<Imagen> Imagenes=new HashSet<Imagen>(0);

    public Set<Imagen> getImagenes(){
        return Imagenes;
    }

    public void setImagenes(Set<Imagen> Imagenes){
        this.Imagenes=Imagenes;
    }

    public void añadirImagen(Imagen Img){
        Imagenes.add(Img);
    }
}
