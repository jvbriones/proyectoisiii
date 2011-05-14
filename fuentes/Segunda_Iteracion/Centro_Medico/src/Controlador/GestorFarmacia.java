
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


        System.out.println(Nombre);
        MedicamentoBD meBD=new MedicamentoBD();
        Set<Medicamento> me=null;
        Medicamento Medica = new Medicamento();
        me = meBD.obtenerTodosMedicamentos();
        ArrayList li = new ArrayList();
        for( Iterator it = me.iterator(); it.hasNext();) {
             Medica = (Medicamento)it.next();
            
	    
              if(Medica.getNombre().regionMatches(0, Nombre, 0, Nombre.length())) {
                 //System.out.println ( Medica.getNombre() +" aqui" );
                 li.add(Medica);
                 
                }
            
            
        }
        return li;

    }

    public Set<Receta> consultarResumenRecetas(String Dni) throws SQLException{
        ArrayList resumenRecetas = new ArrayList();
        GestorPacientes pacien = new GestorPacientes();
        Paciente pac = new Paciente();
        RecetaBD recetas = new RecetaBD();
        Receta rec = null;
        Set<Receta> almacenRecetas = null;
        boolean fin = false;
        Medico doc = null;

        pac = pacien.obtenerPaciente(Dni);

        System.out.println("1");

        if(pac == null){
            System.out.println("El paciente no existe");
            return almacenRecetas;

        }


        else{
            System.out.println("2");
            almacenRecetas = recetas.obtenerRecetasPaciente(Dni);
System.out.println("3");
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
             }
             * */
System.out.println("4");

            return almacenRecetas;
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
            ArrayList<ArrayList> aux2 = new ArrayList();

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

            aux2.add(datosReceta);
            aux2.add(datosMedicamentos);

            return aux2;



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
           // rBD.actualizar(rec);//no puedo coger rec de la función anterior ya que es local a la función
            //la anterior linea ha sido comentada por Nicolás


            




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
                  
                   Date fechaCad = lote.getFechaCaducidad();
                if( fechaActual.after(fechaCad)){
                    nExistencias +=lote.getExistencias();


                    
                    loteBD.eliminar(lote); // 
                    medica.actualizaStock(-nExistencias); // actualiza el stock del medicamento
                    StockActual-=nExistencias;//actualizamos stock
                    meBD.actualizar(medica);
                }
            }
            

           if( StockMinimoPermitido < StockActual){
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

