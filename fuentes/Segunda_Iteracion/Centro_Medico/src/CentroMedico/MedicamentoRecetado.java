/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author pope
 */
public class MedicamentoRecetado implements Serializable{
    private int Id;
    private String Posologia;
    private int Duracion;
    private Date FechaFin;
    private boolean Dispensado;

    private Medicamento Med;

    public MedicamentoRecetado() {
    }

    public int getId (){
        return Id;
    };

    public String getPosologia (){
        return Posologia;
    };

    public int getDuracion (){
        return Duracion;
    };

    public Date getFechaFin (){
        return FechaFin;
    };

    public boolean getDispensado (){
        return Dispensado;
    };

    public Medicamento getMed (){
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

    public void setFechaFin ( Date FechaFin){
        this.FechaFin=FechaFin;
    };

    public void setDispensado (boolean Dispensado){
        this.Dispensado=Dispensado;
    };

    public void setMed (Medicamento Med){
        this.Med=Med;
    };
}
