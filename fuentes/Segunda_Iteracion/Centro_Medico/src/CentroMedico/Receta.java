/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author José Peso Buendía
 * modificado por Juan Carlos
 */
public class Receta {
    private int Id;
    private String Instrucciones;
    private String JuicioDiagnostico;
    private Date Fecha;

    private Medico Medi;
    private Paciente Paci;
    private Set <MedicamentoRecetado> MedicamentosRecetados = new HashSet<MedicamentoRecetado>(0);

    public Receta() {
    }

    public Receta(String Instrucciones) {
        this.Instrucciones = Instrucciones;
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