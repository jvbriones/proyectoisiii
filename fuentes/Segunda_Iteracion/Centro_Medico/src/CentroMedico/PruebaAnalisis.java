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
    private PersonalMedico Pm;

    public PruebaAnalisis() {
    }
    public PruebaAnalisis(String com, Paciente pac, PersonalMedico pm){
        this.Comentario=com;
        this.Paciente = pac;
        this.Pm = pm;
    }

    public int getId (){
        return Id;
    }

    public String getComentario (){
        return Comentario;
    }

    public PersonalMedico getAnalista (){
        return Pm;
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

    public void setAnalista (PersonalMedico Analista){
        this.Pm=Analista;
    }
}
