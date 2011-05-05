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
public class LoteMedicamento {
    private String CodBarras;
    private int Existencias;
    private Date FechaCaducidad;

    private Medicamento Medicamento;


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
}
