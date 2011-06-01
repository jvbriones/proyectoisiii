/**
 * AtributoOrina.java
 *
 * Informacion:
 * Clase encargada de modelizar un atributo correspondiente a un análisis de orina
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.io.Serializable;

public class AtributoOrina implements Serializable{
    private String Nombre;
    private String Unidad;
    private float LimSup;
    private float LimInf;



    public AtributoOrina() {
    }

    public AtributoOrina(String Nombre, float LimSup, float LimInf, String Unidad) {
        this.Nombre = Nombre;
        this.Unidad = Unidad;
        this.LimSup = LimSup;
        this.LimInf = LimInf;
    }



    public String getNombre(){
        return Nombre;
    }

    public float getLimInf() {
        return LimInf;
    }

    public float getLimSup() {
        return LimSup;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }

    public void setLimInf(float LimInf) {
        this.LimInf = LimInf;
    }

    public void setLimSup(float LimSup) {
        this.LimSup = LimSup;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }
}
