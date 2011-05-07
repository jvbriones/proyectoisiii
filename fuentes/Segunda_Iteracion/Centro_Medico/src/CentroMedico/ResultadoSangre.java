/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

/**
 *
 * @author pope
 */
public class ResultadoSangre {
    private int Id;
    private String Resultado;

    private AtributoSangre Atr;

    public ResultadoSangre() {
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
