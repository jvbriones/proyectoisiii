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
public class PruebaOrina extends PruebaAnalisis{
    private Set <ResultadoOrina> ResultadosOrina = new HashSet<ResultadoOrina>(0);

    public Set<ResultadoOrina> getResultadosOrina(){
        return ResultadosOrina;
    }

    public void setResultadosOrina( Set<ResultadoOrina> ResultadosOrina){
        this.ResultadosOrina=ResultadosOrina;
    }

    void añadirResultadoOrina (ResultadoOrina Res){
        ResultadosOrina.add(Res);
    }
}
