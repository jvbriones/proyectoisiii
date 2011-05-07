
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
        MedicamentoBD meBD= null;
        Medicamento me;
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

        Medicamento Me;
        MedicamentoBD meBD = null; 

        Me = meBD.obtener(Nombre);

        return Me;
        // hace faltar irse a la interfaz y allí
        // hacer que si Me==null entonces el medicamento no existe
    }


   public boolean modificarMedicamento( String Nombre,String Descripcion, int ExistenciasMinimas, int StockActual){

       Medicamento Me;
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
       Medicamento Me;
       MedicamentoBD meBD=null;
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
        LoteMedicamentoBD loBD = null;
        MedicamentoBD meBD = null;
        Lo=loBD.obtener(CodBarras);

        if( Lo!=null)
            return false;

        else{
            LoteMedicamento lote = new LoteMedicamento(CodBarras,Existencias,FechaCaducidad);
            Medicamento Me = lote.getMedicamento();
            // LLAMAR A JAVI, FALTA AÑADIR
            loBD.almacenar(lote);
            Me.anadirAlArray(lote);
            Me.actualizaStock(Existencias);
            meBD.almacenar(Me);
            return true;

          




        }

        
    }



    public LoteMedicamento consultarLoteMedicamento (String CodBarras, Medicamento me){
        LoteMedicamento Lo=null;
        Medicamento Me=me;

        Set<LoteMedicamento> lotes;

        LoteMedicamento Aux=null;
        lotes = Me.getLotesMedicamento();

        for( Iterator it = lotes.iterator(); it.hasNext();) {
	    Aux = (LoteMedicamento)it.next();
	    if( Aux.getCodBarras().equals(CodBarras)){
                Lo = Aux;

            }
         }
         return Lo;
    }


    public boolean modificarLoteMedicamento( String CodBarras,int Existencias, Date FechaCaducidad,Medicamento me ){

        LoteMedicamentoBD loBD = null;
        LoteMedicamento Lo= null;
        Medicamento Me= me;
        MedicamentoBD meBD=null;


        Lo= loBD.obtener(CodBarras);

        if( Lo!= null)
            return false;

        else{

            Lo.setCodBarras(CodBarras);
            Lo.setExistencias(Existencias);
            Lo.setFechaCaducidad(FechaCaducidad);
            Me.actualizaStock(Existencias);
            Me.actualizaLote(CodBarras);
            loBD.almacenar(Lo);
            meBD.almacenar(Me);

            return true;
        }

    }
    
    public boolean eliminarLoteMedicamento ( String CodBarras, Medicamento me){
        
         Medicamento Me =me;
         MedicamentoBD meBD=null;
         LoteMedicamentoBD loBD= null; 
         LoteMedicamento Lo = this.consultarLoteMedicamento(CodBarras,Me);
         if( Lo == null)
             return false; 
         else{
             int Existencias = Lo.getExistencias();
             Me.actualizaLote(CodBarras);
             Me.actualizaStock(-Existencias);//aquí debe restar las existencias
             Me.eliminarLote(CodBarras);


             loBD.almacenar(Lo); // tengo mis dudas porque loBD es nulo
             meBD.almacenar(Me);
             return true;
        }
    }

    public Set buscarMedicamento( String Nombre ){


        MedicamentoBD meBD=null;
        Set<Medicamento> me=null;

        me = meBD.obtenerTodosMedicamentos();
        return me;

    }

    public ArrayList comprobarStockMedicamentos(){

        Date fechaActual=new Date();
        MedicamentoBD meBD = new MedicamentoBD();
        Medicamento medica= new Medicamento(); 
        LoteMedicamentoBD loteBD = new LoteMedicamentoBD();
        LoteMedicamento lote = new LoteMedicamento();
        Set<Medicamento> me;
        ArrayList<LoteMedicamento> lotesMedica=new ArrayList();

        ArrayList<ArrayList < String > > li = new ArrayList();
        ArrayList< String> Atributos = new ArrayList();
        me= meBD.obtenerTodosMedicamentos();

        for( Iterator it = me.iterator(); it.hasNext();) {
	   medica = (Medicamento)it.next();
	   String nombre =medica.getNombre();
           int StockMinimoPermitido = medica.getExistenciasMinimas();
           medica.setExistenciasMinimas(0);
           lote = loteBD.obtener(nombre);// como obtener de aquí un array cuando en el diseñoo aparece un array?
           lotesMedica.add(lote);
           Date fechaCad = lote.getFechaCaducidad();
           if( fechaActual.before(fechaCad)){
               Atributos.add(nombre);
               Atributos.add(String.valueOf(StockMinimoPermitido));
               Atributos.add(String.valueOf(medica.getExistenciasMinimas()));
               li.add(Atributos);
            }

               lote.getExistencias();
                      
         }





    }


}

