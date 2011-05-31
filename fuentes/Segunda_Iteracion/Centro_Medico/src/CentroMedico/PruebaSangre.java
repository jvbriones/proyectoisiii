/**
 * PruebaSangre.java
 *
 * Informacion:
 * Clase encargada de modelizar una prueba de sangre
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

public class PruebaSangre extends PruebaAnalisis{
    private Set <ResultadoSangre> ResultadosSangre = new HashSet<ResultadoSangre>(0);

    public PruebaSangre() {
    }

    public PruebaSangre(String com, Paciente pac, PersonalMedico pm){
        super(com, pac, pm);
    }

    public Set<ResultadoSangre> getResultadosSangre(){
        return ResultadosSangre;
    }

    public void setResultadosSangre( Set<ResultadoSangre> ResultadosSangre){
        this.ResultadosSangre=ResultadosSangre;
    }

    public void añadirResultadoSangre (ResultadoSangre Res){
        ResultadosSangre.add(Res);
    }
}
