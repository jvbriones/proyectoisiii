/**
 * LoteMedicamento.java
 *
 * Informacion:
 * Clase encargada de modelizar un lote de un medicamento
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Date;
import java.io.Serializable;

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

    public String getNombre (){
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
