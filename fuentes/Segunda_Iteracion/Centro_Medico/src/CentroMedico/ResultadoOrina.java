/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.io.Serializable;

/**
 *
 * @author pope
 */
public class ResultadoOrina implements Serializable{
    private int Id;
    private String Resultado;

    private AtributoOrina Atr;

    public ResultadoOrina() {
    }

    public ResultadoOrina(AtributoOrina aO, String res){
        this.Atr = aO;
        this.Resultado = res;
    }

    public int getId(){
        return Id;
    }

    public String getResultado(){
        return Resultado;
    }

    public AtributoOrina getAtr(){
        return Atr;
    }

    public void setId(int Id){
        this.Id=Id;
    }

    public void setResultado(String Resultado){
        this.Resultado=Resultado;
    }

    public void setId(AtributoOrina Atr){
        this.Atr=Atr;
    }

    public void setAtr(AtributoOrina Atr){
        this.Atr=Atr;
    }
}
