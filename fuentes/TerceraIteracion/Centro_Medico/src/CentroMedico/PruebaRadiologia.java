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
    private boolean Acceso;
    
    private Paciente Paciente;
    private PersonalMedico Radiologo;

    public PruebaRadiologia() {
    }

    public PruebaRadiologia(String com, Paciente Pac, PersonalMedico Rad){
        this.Comentario=com;
        this.Paciente = Pac;
        this.Radiologo=Rad;

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

    public PersonalMedico getRadiologo() {
        return Radiologo;
    }

    public boolean isAcceso() {
        return Acceso;
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

     public void setRadiologo(PersonalMedico Radiologo) {
        this.Radiologo = Radiologo;
    }

    public void setAcceso(boolean Acceso) {
        this.Acceso = Acceso;
    }


}
