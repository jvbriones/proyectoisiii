/**
 * ResultadoSangre.java
 *
 * Informacion:
 * Clase encargada de modelizar el resultado de una prueba de sangre
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.io.Serializable;

public class ResultadoSangre implements Serializable{
    private int Id;
    private String Resultado;

    private AtributoSangre Atr;

    public ResultadoSangre() {
    }

    public ResultadoSangre(AtributoSangre atS, String res){
        this.Atr = atS;
        this.Resultado = res;
    }


    public int getId(){
        return Id;
    }

    public String getResultado(){
        return Resultado;
    }

    public AtributoSangre getAtr(){
        return Atr;
    }

    public void setId(int Id){
        this.Id=Id;
    }

    public void setResultado(String Resultado){
        this.Resultado=Resultado;
    }

    public void setId(AtributoSangre Atr){
        this.Atr=Atr;
    }

    public void setAtr(AtributoSangre Atr){
        this.Atr=Atr;
    }

}
