
/*
 * GestorFarmacia.java
 *
 * Informacion:
 * Clase encargada de operar con la farmacia
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package Controlador;

import CentroMedico.*;
import BaseDatos.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author nicolas
 */
public class GestorFarmacia {

   public boolean anadirMedicamento( String Nombre,String Descripcion, int ExistenciasMinimas, int StockActual){

        boolean exito;
        MedicamentoBD meBD= new MedicamentoBD();
        Medicamento me= new Medicamento();
        me= meBD.obtener(Nombre);

        if( me!=null){

            exito=false;
        }
         else{

            me = new Medicamento ( Nombre,Descripcion,ExistenciasMinimas,StockActual);
            meBD.almacenar(me);
            exito=true;
         }

         return exito;

    }

    public Medicamento consultarMedicamento( String Nombre){

        Medicamento Me = new Medicamento();
        MedicamentoBD meBD = new MedicaentoBD();

        Me = meBD.obtener(Nombre);

        return Me;
        // hace faltar irse a la interfaz y allí
        // hacer que si Me==null entonces el medicamento no existe
    }


   public boolean modificarMedicamento( String Nombre,String Descripcion, int ExistenciasMinimas, int StockActual){

       Medicamento Me= new Medicamento();
       MedicamentoBD meBD=new MedicamentoBD();
       Me= meBD.obtener(Nombre);

       if( Me==null)
           return false;
       else{
           Me.setNombre(Nombre);
           Me.setDescripcion(Descripcion);
           Me.setExistenciasMinimas(ExistenciasMinimas);
           Me.setStockActual(StockActual);
           meBD.actualizar(Me);

           return true;
       }

    }

    public boolean eliminarMedicamento( String Nombre){
       Medicamento Me= new Medicamento();
       MedicamentoBD meBD=new MedicamentoBD();
       Me= meBD.obtener(Nombre);
       if( Me != null){
        meBD.eliminar(Me);
        return true;
        }
      else
          return false;
    }


    public boolean anadirLoteMedicamento (String CodBarras,int Existencias, Date FechaCaducidad){

        LoteMedicamento Lo= null;
        LoteMedicamentoBD loBD = new LoteMedicamentoBD();
        MedicamentoBD meBD = new MedicamentoBD();
        Lo=loBD.obtener(CodBarras);

        if( Lo!=null)
            return false;

        else{
            LoteMedicamento lote = new LoteMedicamento(CodBarras,Existencias,FechaCaducidad);
            Medicamento Me = lote.getMedicamento();
            loBD.almacenar(lote);
            Me.anadirAlArray(lote);
            Me.actualizaStock(Existencias);
            meBD.almacenar(Me);
            return true; 

        }

        
    }



    public LoteMedicamento consultarLoteMedicamento (String CodBarras){


        LoteMedicamento Lo=null;
        Medicamento Me=null;

        Set<LoteMedicamento> lotes;

        LoteMedicamento Aux=null;
        lotes = Me.getLotesMedicamento();

        for( Iterator it = lotes.iterator(); it.hasNext();) {
	    Aux = (LoteMedicamento)it.next();
	    if( Aux.getCodBarras() == CodBarras){
                Lo = Aux;

            }
         }
         return Lo;
}

}

