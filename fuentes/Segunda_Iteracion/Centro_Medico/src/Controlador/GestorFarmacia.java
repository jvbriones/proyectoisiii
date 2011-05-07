
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
        MedicamentoBD meBD = new MedicamentoBD();

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

        LoteMedicamento Lo=new LoteMedicamento();
        LoteMedicamentoBD loBD = new LoteMedicamentoBD();
        MedicamentoBD meBD = new MedicamentoBD();
        Lo=loBD.obtener(CodBarras);

        if( Lo!=null)
            return false;

        else{
            LoteMedicamento lote = new LoteMedicamento(CodBarras,Existencias,FechaCaducidad);
            Medicamento Me = lote.getMedicamento();

            if(Me==null){
                System.out.println("Hola");
            }
            loBD.almacenar(lote);
            Me.anadirAlArray(lote);
            Me.actualizaStock(Existencias);
            meBD.actualizar(Me);
            return true;

          




        }

        
    }



    public LoteMedicamento consultarLoteMedicamento (String CodBarras, Medicamento me){
        LoteMedicamento Lo=new LoteMedicamento();
        Medicamento Me=me;

        Set<LoteMedicamento> lotes;

        LoteMedicamento Aux=new LoteMedicamento();
        lotes = Me.getLotesMedicamento();

        if( lotes != null)
            System.out.println("mal");

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

    public ArrayList consultarResumenRecetas(String Dni) throws SQLException{
        ArrayList resumenRecetas = new ArrayList();
        GestorPacientes pacien = new GestorPacientes();
        Paciente pac = new Paciente();
        RecetaBD recetas = new RecetaBD();
        Receta rec = null;
        Set<Receta> almacenRecetas;
        boolean fin = false;
        Medico doc = null;

        pac = pacien.obtenerPaciente(Dni);


        if(pac == null){
            System.out.println("El paciente no existe");
            return resumenRecetas;

        }

        else{

            almacenRecetas = recetas.obtenerRecetasPaciente(Dni);

            for( Iterator it = almacenRecetas.iterator(); it.hasNext();) {
                rec = (Receta)it.next();
                ArrayList aux = new ArrayList();

                aux.add(rec.getFecha());
                doc = rec.getMedi();
                aux.add(doc);
                aux.add(doc.getNombre());
                aux.add(doc.getApellidos());
                resumenRecetas.add(aux);
             }

            return resumenRecetas;
        }
    }

    public ArrayList mostrarReceta(int idReceta){

            ArrayList datosReceta = new ArrayList();
            ArrayList datosMedicamentos = new ArrayList();
            Set<MedicamentoRecetado> recetados = null;
            Receta rec = null;
            RecetaBD recetas = new RecetaBD();
            Medicamento med = null;
            MedicamentoRecetado medRed = new MedicamentoRecetado();

            rec = recetas.obtener(idReceta);

            datosReceta.add(rec.getFecha());
            datosReceta.add(rec.getInstrucciones());
            datosReceta.add(rec.getJuicioDiagnostico());
            recetados.add((MedicamentoRecetado) rec.getMedicamentosRecetados());

            for( Iterator it = recetados.iterator(); it.hasNext();){
                medRed = (MedicamentoRecetado)it.next();
                med = medRed.getMed();
                ArrayList aux = new ArrayList();

                aux.add(med.getNombre());
                aux.add(medRed.getPosologia());
                aux.add(medRed.getDuracion());
                aux.add(medRed.getFechaFin());
                aux.add(medRed.getDispensado());
                aux.add(med.getStockActual());

                datosMedicamentos.add(aux);

            }

            return datosReceta; //también hay que devolver los datos de medicamentos no es posible devolver dos arrays



        }

    public void dispensarMedicamentos(ArrayList<String> ListaCodBarras){
        String codBarras;
        LoteMedicamentoBD loteBD = new LoteMedicamentoBD();
        LoteMedicamento lote = null;
        Medicamento med = new Medicamento();
        MedicamentoBD mBD = new MedicamentoBD();
        String nombre;
        RecetaBD rBD = new RecetaBD();

        for( Iterator it = ListaCodBarras.iterator(); it.hasNext();){
            codBarras = (String)it.next();
            lote = loteBD.obtener(codBarras);
            lote.decrementarExistencias(1);
            if(lote.getExistencias()==0){
                loteBD.eliminarLote(codBarras);//En el diseño usa eliminar pero pasa como atributo codBarras al que le pertenece la función eliminarLote

            }

            else{
                loteBD.actualizar(lote);
            }

            med = lote.getMedicamento();
            med.actualizaStock(1);
            mBD.actualizar(med);
            nombre = med.getNombre();
            Set<MedicamentoRecetado> recetados;
            MedicamentoRecetado medRed = null;
            //No hay ninguna función que se llame obtenerMedicamentoRecetado en MedicamentoRecetado
            medRed.setDispensado(true);
            rBD.actualizar(rec);//no puedo coger rec de la función anterior ya que es local a la función

            




        }
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
        me= meBD.obtenerTodosMedicamentos(); // array con todos los medicamentos

        for( Iterator it = me.iterator(); it.hasNext();) {
	   medica = (Medicamento)it.next();
	   String nombre =medica.getNombre();
           int StockMinimoPermitido = medica.getExistenciasMinimas();
           int StockActual = medica.getStockActual();
           medica.setExistenciasMinimas(0);
           for( Iterator itMe=me.iterator();it.hasNext();){

                   lote = loteBD.obtener(nombre);// como obtener de aquí un array cuando en el diseñoo aparece un array?
                   lotesMedica.add(lote);
                   Date fechaCad = lote.getFechaCaducidad();
                if( fechaActual.before(fechaCad)){
                 //nExistencias = getExistencias(lote)
                    loteBD.eliminar(lote);
                   // medica.actualizaStock(Nexistencias);
                }
            }


           if( StockMinimoPermitido < StockActual){
                   Atributos.add(nombre);
                   Atributos.add(String.valueOf(StockMinimoPermitido));
                   Atributos.add(String.valueOf(medica.getExistenciasMinimas()));
                   li.add(Atributos);

           }
       
                      
         }

         return li;



    }


}

