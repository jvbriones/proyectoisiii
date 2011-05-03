
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

import CentroMedico.Medicamento;
import BaseDatos.MedicamentoBD;
import BaseDatos.personalBD;
import java.sql.SQLException;
import java.util.Date;

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

}



