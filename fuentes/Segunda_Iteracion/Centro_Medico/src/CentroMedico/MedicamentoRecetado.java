/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

import java.util.Date;
/**
 *
 * @author pope
 */
public class MedicamentoRecetado {
    private int Id;
    private String Posologia;
    private int Duracion;
    private Date FechaFin;
    private boolean Dispensado;

    private Medicamento Med;

    public int getId (){
        return Id;
    };

    public String getPosologia (){
        return Posologia;
    };

    public int getDuracion (){
        return Duracion;
    };

    public Date getDate (){
        return FechaFin;
    };

    public Medicamento getMedicamento (){
        return Med;
    };

    public void setId (int Id){
        this.Id = Id;
    };

    public void setPosologia (String Posologia){
        this.Posologia=Posologia;
    };

    public void setDuracion ( int Duracion){
        this.Duracion=Duracion;
    };

    public void setDate ( Date FechaFin){
        this.FechaFin=FechaFin;
    };

    public void setMedicamento (Medicamento Med){
        this.Med=Med;
    };
}
