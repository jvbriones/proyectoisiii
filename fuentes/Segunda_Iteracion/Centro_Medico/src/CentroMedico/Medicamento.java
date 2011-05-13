/**
 * Medicamento.java
 *
 * Informacion:
 * Clase encargada de modelizar un medicamento
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;

import BaseDatos.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import org.hibernate.*;

public class Medicamento implements Serializable{
    private String Nombre;
    private String Descripcion;
    private int ExistenciasMinimas;
    private int StockActual;

    private Set<LoteMedicamento> LotesMedicamento = new HashSet<LoteMedicamento>(0);

    public Medicamento() {
    }

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

         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

      
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



   public void eliminarLote( String CodBarras){

       LoteMedicamento Lo=null;


        for( Iterator it = LotesMedicamento.iterator(); it.hasNext();) {
             Lo = (LoteMedicamento)it.next();
             if( Lo.getCodBarras().equals(CodBarras))
                    it.remove();

         }

    }

  
}
