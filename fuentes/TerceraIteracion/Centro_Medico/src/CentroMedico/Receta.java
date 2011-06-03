/**
 * Receta.java
 *
 * Informacion:
 * Clase encargada de modelizar una receta
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author José Peso Buendía
 * modificado por Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

public class Receta implements Serializable{
    private int Id;
    private String Instrucciones;
    private String JuicioDiagnostico;
    private Date Fecha;

    private Medico Medi;
    private Paciente Paci;
    private Set <MedicamentoRecetado> MedicamentosRecetados = null;//new HashSet<MedicamentoRecetado>(0);

    public Receta() {
    }

    public Receta(String Instrucciones) {
        this.Instrucciones = Instrucciones;
    }

    public Receta(String Ins, String JD, Date F){
        
        this.JuicioDiagnostico = JD;
        this.Instrucciones = Ins;
        this.Fecha = F;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getId() {
        return Id;
    }

    public String getInstrucciones() {
        return Instrucciones;
    }

    public String getJuicioDiagnostico() {
        return JuicioDiagnostico;
    }

    public Medico getMedi() {
        return Medi;
    }

    public Paciente getPaci() {
        return Paci;
    }

    public Set<MedicamentoRecetado > getMedicamentosRecetados() {
        if(MedicamentosRecetados.isEmpty())
            return null;
        return MedicamentosRecetados;
        
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    private void setId(int Id) {
        this.Id = Id;
    }

    public void setInstrucciones(String Instrucciones) {
        this.Instrucciones = Instrucciones;
    }

    public void setJuicioDiagnostico(String JuicioDiagnostico) {
        this.JuicioDiagnostico = JuicioDiagnostico;
    }

    public void setMedi(Medico Medi) {
        this.Medi=Medi;
    }

    public void setPaci(Paciente Paci) {
        this.Paci=Paci;
    }

    public void setMedicamentosRecetados(Set <MedicamentoRecetado> MedRec) {
        this.MedicamentosRecetados = MedRec;
    }

}