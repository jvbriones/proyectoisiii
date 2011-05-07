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
public class LoteMedicamento implements Serializable{
    private String CodBarras;
    private int Existencias;
    private Date FechaCaducidad;

    private Medicamento Medicamento;

    public LoteMedicamento() {
    }

    public void decrementarExistencias(int Num){
        this.Existencias = this.Existencias - Num;
    }

    public LoteMedicamento( String CodBarras, int Existencias, Date FechaCaducidad){

        this.CodBarras= CodBarras;
        this.Existencias= Existencias;
        this.FechaCaducidad=FechaCaducidad;
       
    }


    public String getCodBarras (){
        return CodBarras;
    }

    public int getExistencias (){
        return Existencias;
    }

    public Date getFechaCaducidad (){
        return FechaCaducidad;
    }


    public Medicamento getMedicamento (){
        return Medicamento;
    }

    public String getNOMBRE_MEDICAMENTO (){
        return Medicamento.getNombre();
    }


    public void setCodBarras (String CodBarras){
        this.CodBarras=CodBarras;
    }

    public void setExistencias (int Existencias){
        this.Existencias=Existencias;
    }

    public void setFechaCaducidad (Date FechaCaducidad){
        this.FechaCaducidad=FechaCaducidad;
    }

    public void setMedicamento (Medicamento Medicamento){
        this.Medicamento=Medicamento;
    }
    public void setNOMBRE_MEDICAMENTO (String Nombre){
        this.Medicamento.setNombre(Nombre);
    }
}
