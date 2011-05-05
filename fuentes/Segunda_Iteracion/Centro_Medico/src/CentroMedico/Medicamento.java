/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author pope
 */
public class Medicamento {
    private String Nombre;
    private String Descripcion;
    private int ExistenciasMinimas;
    private int StockActual;

    private Set<LoteMedicamento> LotesMedicamento = new HashSet<LoteMedicamento>(0);

    public Medicamento(String Nombre, String Descripcion, int ExistenciasMinimas, int StockActual){

        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
        this.ExistenciasMinimas=ExistenciasMinimas;
        this.StockActual=StockActual;
    }



    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getExistenciasMinimas() {
        return ExistenciasMinimas;
    }

    public int getStockActual() {
        return StockActual;
    }

    public Set<LoteMedicamento> getLotesMedicamento() {
        return LotesMedicamento;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setExistenciasMinimas(int ExistenciasMinimas) {
        this.ExistenciasMinimas = ExistenciasMinimas;
    }

    public void setStockActual(int stockActual) {
        this.StockActual = stockActual;
    }

    public void setLotesMedicamento(Set <LoteMedicamento> LotesMedicamento) {
        this.LotesMedicamento = LotesMedicamento;
    }

    public void anadirAlArray( LoteMedicamento Lote){

         LotesMedicamento.add(Lote);

    }

    public void actualizaStock( int Existencias){

        int Totales;
        Totales = this.getStockActual() + Existencias;
        this.setStockActual(Totales);
    }


   public void actualizaLote(String CodBarras){




   }
}
