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
    private String Id;
    private String Comentario;

    private Paciente Paci;

    public String getId (){
        return Id;
    }

    public String getComentario (){
        return Comentario;
    }

    public Paciente getPaciente (){
        return Paci;
    }

    public void setId (String Id){
        this.Id=Id;
    }

    public void setComentario (String Comentario){
        this.Comentario=Comentario;
    }

    public void setPaciente (Paciente Paci){
        this.Paci=Paci;
    }
}
