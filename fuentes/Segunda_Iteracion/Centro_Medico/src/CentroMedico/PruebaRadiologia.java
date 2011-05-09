/**
 * PruebaRadiologia.java
 *
 * Informacion:
 * Clase encargada de modelizar una prueba de radiología
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.io.Serializable;

public class PruebaRadiologia implements Serializable{
    private int Id;
    private String Comentario;

    private Paciente Paciente;
    private Radiologo Radiologo;

    public PruebaRadiologia() {
    }

    public PruebaRadiologia(String com){
        this.Comentario=com;
    }


    public int getId(){
        return Id;
    }

    public String getComentario(){
        return Comentario;
    }

    public Paciente getPaciente(){
        return Paciente;
    }

    public Radiologo getRadiologo() {
        return Radiologo;
    }

    public void setId(int Id){
        this.Id=Id;
    }

    public void setComentario(String Comentario){
        this.Comentario=Comentario;
    }

    public void setPaciente(Paciente Paciente){
        this.Paciente=Paciente;
    }

    public void setRadiologo(Radiologo Radiologo) {
        this.Radiologo = Radiologo;
    }

}
