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
public class PruebaSangre extends PruebaAnalisis{
    private Set <ResultadoSangre> ResultadosSangre = new HashSet<ResultadoSangre>(0);

    public Set<ResultadoSangre> getResultadosSangre(){
        return ResultadosSangre;
    }

    public void setResultadosSangre( Set<ResultadoSangre> ResultadosSangre){
        this.ResultadosSangre=ResultadosSangre;
    }

    void añadirResultadoSangre (ResultadoSangre Res){
        ResultadosSangre.add(Res);
    }
}
