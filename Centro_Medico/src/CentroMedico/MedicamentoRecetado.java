/**
 * MedicamentoRecetado.java
 *
 * Informacion:
 * Clase encargada de modelizar un medicamento recetado
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;

import java.util.Date;
import java.io.Serializable;

public class MedicamentoRecetado implements Serializable{
    private int Id;
    private String Posologia;
    private int Duracion;
    private Date FechaFin;
    private boolean Dispensado;

    private Medicamento Medicamento;

    public MedicamentoRecetado() {
    }

    public MedicamentoRecetado(Medicamento medica, String pos, int duracion, Date fechaFin, boolean disp){
        this.Medicamento = medica;
        this.Posologia = pos;
        this.Duracion = duracion;
        this.FechaFin = fechaFin;
        this.Dispensado = disp;
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

    public Medicamento getMedicamento (){
        return Medicamento;
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

    public void setMedicamento (Medicamento Medicamento){
        this.Medicamento=Medicamento;
    };
}
