/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

/**
 *
 * @author pope
 */
public class PruebaAnalisis {
    private int Id;
    private String Comentario;

    private Paciente Paciente;

    public int getId (){
        return Id;
    }

    public String getComentario (){
        return Comentario;
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
}
