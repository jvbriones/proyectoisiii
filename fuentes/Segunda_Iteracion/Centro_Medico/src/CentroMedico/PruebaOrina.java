/**
 * PruebaOrina.java
 *
 * Informacion:
 * Clase encargada de modelizar una prueba de orina
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

public class PruebaOrina extends PruebaAnalisis{
    private Set <ResultadoOrina> ResultadosOrina = new HashSet<ResultadoOrina>(0);

    public PruebaOrina() {
    }

    public PruebaOrina(String Comentario) {
        super(Comentario);
    }

    public Set<ResultadoOrina> getResultadosOrina(){
        return ResultadosOrina;
    }

    public void setResultadosOrina( Set<ResultadoOrina> ResultadosOrina){
        this.ResultadosOrina=ResultadosOrina;
    }

    public void añadirResultadoOrina (ResultadoOrina Res){
        ResultadosOrina.add(Res);
    }
}
