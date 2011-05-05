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
public class Radiografia extends PruebaRadiologia{
    private Set<Imagen> Radiografias=new HashSet<Imagen>(0);

    public Radiografia() {
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
