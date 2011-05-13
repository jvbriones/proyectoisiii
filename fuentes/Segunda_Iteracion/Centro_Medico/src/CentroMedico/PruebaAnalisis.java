/**
 * PruebaAnalisis.java
 *
 * Informacion:
 * Clase encargada de modelizar una prueba de análisis
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.io.Serializable;

public class PruebaAnalisis implements Serializable{
    private int Id;
    private String Comentario;

    private Paciente Paciente;
    private Analista Analista;

    public PruebaAnalisis() {
    }
    public PruebaAnalisis(String com, Paciente pac, Analista an){
        this.Comentario=com;
        this.Paciente = pac;
        this.Analista = an;
    }

    public int getId (){
        return Id;
    }

    public String getComentario (){
        return Comentario;
    }

    public Analista getAnalista (){
        return Analista;
    }

    public Paciente getPaciente (){
        return Paciente;
    }

    public void setId (int Id){
        this.Id=Id;
    }

    public void setComentario (String Comentario){
        this.Comentario=Comentario;
    }

    public void setPaciente (Paciente Paciente){
        this.Paciente=Paciente;
    }

    public void setAnalista (Analista Analista){
        this.Analista=Analista;
    }
}
