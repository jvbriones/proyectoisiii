
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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import org.hibernate.*;

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
        
    }


   public boolean modificarMedicamento( Medicamento Me){

     
       MedicamentoBD meBD=new MedicamentoBD();
      


          if( Me!=null){
        meBD.actualizar(Me);
           return true;
       }
       else{


            return false;
       }

    }

    public boolean eliminarMedicamento( Medicamento Me){
       
       MedicamentoBD meBD=new MedicamentoBD();
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

       if( Me != null){
        meBD.eliminar(Me);

        return true;
        }
      else{
          Connection con = session.close();
          return false;
      }
    }


    public boolean anadirLoteMedicamento (String CodBarras,int Existencias, Date FechaCaducidad,Medicamento Me){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();



        LoteMedicamento Lo=new LoteMedicamento();
        LoteMedicamentoBD loBD = new LoteMedicamentoBD();
        MedicamentoBD meBD = new MedicamentoBD();
        Lo=loBD.obtener(CodBarras);



        if( Lo!=null)
            return false;

        else{
            LoteMedicamento lote = new LoteMedicamento(CodBarras,Existencias,FechaCaducidad);
            lote.setMedicamento(Me);

         
            loBD.almacenar(lote);
            Me.anadirAlArray(lote);
            Me.actualizaStock(Existencias);
            meBD.actualizar(Me);
            return true;

          




        }

        
    }



    public LoteMedicamento consultarLoteMedicamento (String CodBarras, Medicamento Me){
        LoteMedicamento Lo=new LoteMedicamento();
        LoteMedicamento Aux=new LoteMedicamento();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Set<LoteMedicamento> lotes = Me.getLotesMedicamento();
        for( Iterator it = lotes.iterator(); it.hasNext();) {
	    Aux = (LoteMedicamento)it.next();
            //System.out.println(Aux.getCodBarras());
	    if( Aux.getCodBarras().equals(CodBarras))
                Lo = Aux;
                
            else{
                System.out.println("el lote no existe");
            }
         }
         Connection con = session.close();
         

         return Lo;
    }


    public boolean modificarLoteMedicamento(LoteMedicamento Lo,Medicamento Me){

        LoteMedicamentoBD loBD = new LoteMedicamentoBD();
        MedicamentoBD meBD=new MedicamentoBD();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
    

            Me.actualizaStock(Lo.getExistencias());
            loBD.actualizar(Lo);
            meBD.actualizar(Me);
            
            
            return true;

        

    }
    
    public boolean eliminarLoteMedicamento ( LoteMedicamento Lo,Medicamento Me){
        
       
         MedicamentoBD meBD=new MedicamentoBD();
         LoteMedicamentoBD loBD= new LoteMedicamentoBD();
     
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

         if( Lo == null)
             return false; 
         else{
             
             int Existencias = Lo.getExistencias();
             Me.actualizaStock(-Existencias);//aquí debe restar las existencias
             //Me.eliminarLote(Lo.getCodBarras());
             meBD.actualizar(Me);
             loBD.eliminar(Lo);
             System.out.println(Lo.getCodBarras());
             
             
             return true;
        }
    }

    public ArrayList buscarMedicamento( String Nombre ){

        MedicamentoBD meBD=new MedicamentoBD();
        Set<Medicamento> me=null;
        Medicamento Medica = new Medicamento();
        me = meBD.obtenerTodosMedicamentos();
        ArrayList li = new ArrayList();
        for( Iterator it = me.iterator(); it.hasNext();) {
             Medica = (Medicamento)it.next();
              if(Medica.getNombre().regionMatches(0, Nombre, 0, Nombre.length())) {
                 li.add(Medica);
                }
        }
        return li;

    }

    public Set<Receta> consultarResumenRecetas(String Dni) throws SQLException{
        ArrayList resumenRecetas = new ArrayList();
        GestorPacientes pacien = new GestorPacientes();

                    System.out.println("EL DNI ES DE:" +Dni);

        Paciente pac = new Paciente();
        RecetaBD recetas = new RecetaBD();
        Receta rec = null;
        Set<Receta> almacenRecetas = null;
        boolean fin = false;
        Medico doc = null;

        pac = pacien.obtenerPaciente(Dni);


        if(pac == null){
            System.out.println("El paciente no existe");
            return almacenRecetas;

        }


        else{
            almacenRecetas = recetas.obtenerRecetasPaciente(Dni);
            /*for( Iterator it = almacenRecetas.iterator(); it.hasNext();) {
                rec = (Receta)it.next();
                System.out.println("Receta: "+ rec.getJuicioDiagnostico());
                ArrayList aux = new ArrayList();

                aux.add(rec.getFecha());
                doc = rec.getMedi();
                aux.add(doc);
                aux.add(doc.getNombre());
                aux.add(doc.getApellidos());
                aux.add(rec.getId());
                resumenRecetas.add(aux);
             }*/
             

            return almacenRecetas;
        }
    }

    public Receta mostrarReceta(int idReceta){


            Receta rec = null;
            RecetaBD recetas = new RecetaBD();
            Medicamento med = null;
            System.out.println("mostrar receta");

            rec = recetas.obtener(idReceta);
            System.out.println("receta "+ rec.getId());


            /*datosReceta.add(rec.getFecha());
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

            aux2.add(datosReceta);
            aux2.add(datosMedicamentos);*/

            return rec;



        }

    public void dispensarMedicamentos(Set<String> ListaCodBarras, Receta rece){
        String codBarras;
        LoteMedicamentoBD loteBD = new LoteMedicamentoBD();
        LoteMedicamento lote = null;
        Medicamento med = new Medicamento();
        MedicamentoBD mBD = new MedicamentoBD();
        String nombre;
        RecetaBD rBD = new RecetaBD();
        MedicamentoRecetado  medRed = null;
        Set<MedicamentoRecetado> sMedRed;
        MedicamentoRecetadoBD mRBD = new MedicamentoRecetadoBD();

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
            System.out.println("dispensar medicamento");
            med = lote.getMedicamento();
            System.out.println("Descripcion:"+med.getDescripcion());
 
            med.actualizaStock(-1);
            System.out.println("Stock despues: "+med.getStockActual());
            mBD.actualizar(med);
            System.out.println("4");
            nombre = med.getNombre();
            System.out.println("5");
            //medRed = mRBD.obtener(nombre);
            //medRed.setDispensado(true);
            System.out.println("rece: "+ rece.getId());
            sMedRed = rece.getMedicamentosRecetados();
            for(Iterator it2 = sMedRed.iterator(); it2.hasNext();){
                medRed = (MedicamentoRecetado) it2.next();
                if(lote.getNombre().equals(medRed.getMedicamento().getNombre())){
                    medRed.setDispensado(true);
                }
            }
            rBD.actualizar(rece);
            

        }
    }

    public ArrayList comprobarStockMedicamentos(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();

        Date fechaActual=new Date(); // fecha
        MedicamentoBD meBD = new MedicamentoBD();
        Medicamento medica= new Medicamento(); 
        LoteMedicamentoBD loteBD = new LoteMedicamentoBD();
        LoteMedicamento lote = new LoteMedicamento();
        Set<Medicamento> me;
        Set<LoteMedicamento> lotesMedica=new HashSet<LoteMedicamento>(0);
        String nombreLo;
        ArrayList<ArrayList < String > > li = new ArrayList();
        ArrayList< String> Atributos = new ArrayList();
        me= meBD.obtenerTodosMedicamentos(); // array con todos los medicamentos

        
   
       
        for( Iterator it = me.iterator(); it.hasNext();) {
	   medica = (Medicamento)it.next();
	   String nombre =medica.getNombre();
           int StockMinimoPermitido = medica.getExistenciasMinimas();
           int StockActual = medica.getStockActual();
           int nExistencias=0;
           medica=meBD.obtener(nombre); // avisar a diseño 
          lotesMedica=medica.getLotesMedicamento();
          Atributos = new ArrayList();
          

          for( Iterator itLo=lotesMedica.iterator();itLo.hasNext();){ // eliminar lotes caducados
                 
                   lote = (LoteMedicamento)itLo.next();// como obtener de aquí un array cuando en el diseñoo aparece un array?
                   nombreLo=lote.getCodBarras();
                   System.out.println(StockMinimoPermitido + " hola");

                   Date fechaCad = lote.getFechaCaducidad();
                if( fechaActual.after(fechaCad)){
                    nExistencias +=lote.getExistencias();


                    
                    loteBD.eliminar(lote); // 
                    medica.actualizaStock(-nExistencias); // actualiza el stock del medicamento
                    StockActual-=nExistencias;//actualizamos stock
                    meBD.actualizar(medica);
                }
            }
            

           if( StockMinimoPermitido > StockActual){
                   System.out.println(nombre);
                   
                   Atributos.add(nombre);
                   Atributos.add(String.valueOf(StockActual)); //avisar a Javi por este cambio.
                   Atributos.add(String.valueOf(StockMinimoPermitido));
                   li.add(Atributos);
                 

           }
       
                      
         }
   
         return li;



    }


}

