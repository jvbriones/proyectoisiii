/*
 * GestorUsuarios.java
 *
 * Informacion:
 * Clase encargada de operar con los usuarios
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package Controlador;

import BaseDatos.EnfermedadBD;
import BaseDatos.PacienteBD;
import BaseDatos.RecetaBD;
import BaseDatos.PruebaAnalisisBD;
import BaseDatos.PruebaRadiologiaBD;
import CentroMedico.Enfermedad;
import CentroMedico.Paciente;
import CentroMedico.PruebaAnalisis;
import CentroMedico.PruebaRadiologia;
import CentroMedico.Receta;
import Interfaz.InformacionError;
import Interfaz.InformacionExito;
import java.sql.SQLException;
import java.util.*;
import javax.swing.DefaultListModel;


/**
 * @version     1.1     02/06/2011
 * @author      Sub_Equipo2, Sub_Equipo3
 */

public class GestorPacientes {

   public boolean altaPaciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Telefono, Date FecNac, String LugarNac, byte[] Foto, String TipoUsuario) throws SQLException {
        boolean existe;
        PacienteBD bd_paciente = new PacienteBD();
        String Datos = new String();

        existe=bd_paciente.existePaciente(Dni);

        if(!existe) {
            String pas=new String();
            pas=generarContraseña();
            Paciente paciente=new Paciente(Dni, Nombre, Apellidos, Direccion, Email, pas, Telefono, FecNac, LugarNac, Foto);
            bd_paciente.almacenar(paciente);

            Datos = "Usuario Introducido con Éxito";
        }
        else {
            Datos = "Usuario ya Existe";
        }

        return existe;

    }

   private String generarContraseña() {
        String numeros = "0123456789";
	String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String minusculas = "abcdefghijklmnopqrstuvwxyz";
        int tama=8;

        String contrasena = "";

        for (int i = 0; i < tama; i++) {
                contrasena+=((numeros+mayusculas+minusculas).charAt((int)(Math.random() * (numeros+mayusculas+minusculas).length())));
        }

        return contrasena;
    }
    
   public Paciente obtenerPaciente(String Dni) throws SQLException{
    
        PacienteBD pac = new PacienteBD();
        Paciente p= new Paciente();

        System.out.println("antes de obtener paciente");
        
        p = pac.obtener(Dni);
        return p;
        
        
    }

   public boolean modificarPaciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email, String Pass,String Telefono, Date FecNac, String LugarNac, byte[] Foto ) throws SQLException {
        boolean exito;
        PacienteBD bd_paciente=new PacienteBD();
        Paciente paciente=bd_paciente.obtener(Dni);
        paciente.actualizar(Dni, Nombre, Apellidos, Direccion, Email,Pass,Telefono, FecNac, LugarNac, Foto);
        bd_paciente.actualizar(paciente);
        return true;
}

   public ArrayList<Enfermedad> consultarInfoClinicaPaciente(String DNIPaciente) throws SQLException{
       PacienteBD PacBD = new PacienteBD();
         ArrayList<Enfermedad> enf=null;
           
       boolean existe=PacBD.existePaciente(DNIPaciente);
       String mensaje="";
       if (!existe) {
            System.out.println(mensaje);
            enf=null;
          new InformacionError().setVisible(true);
       }
       else{
       
           EnfermedadBD enfermedad = new EnfermedadBD();
         
          enf= enfermedad.ObtenerEnfermedades(DNIPaciente);
       }
       return enf;
           
       }
          
   public Set<Enfermedad> consultarInformacionClinica(String DNIPaciente) throws SQLException{
       Set<Enfermedad> enf=null;
       
        EnfermedadBD enfermedad = new EnfermedadBD();
          // enf= enfermedad.ObtenerEnfermedades(DNIPaciente);
     
       return enf;
           
       }
   
   public ArrayList<Receta> obtenerRecetas(String dni) throws SQLException{
       ArrayList<Receta> recetas = null;
       RecetaBD receta = new RecetaBD();
  
       
        recetas = receta.obtenerRecetas(dni);
     
       return recetas;
           
       }

   public ArrayList<ArrayList<String> > obtenerPruebas(String dni) throws SQLException{

       PruebaAnalisisBD pruebaAnaBD = new PruebaAnalisisBD();
       ArrayList<PruebaAnalisis> pan = pruebaAnaBD.obtenerPruebasAnalisis(dni);

       PruebaRadiologiaBD pruebaRadioBD = new PruebaRadiologiaBD();
       ArrayList<PruebaRadiologia> pra = pruebaRadioBD.obtenerPruebasRadiologia(dni);
       
       ArrayList< ArrayList<String> > Pruebas = new ArrayList<ArrayList<String> >();
       ArrayList<String> pruebasAnalisis = new ArrayList<String>();

       PruebaAnalisis pa;
       for(int i = 0; i < pan.size(); i++){
           pa = (PruebaAnalisis) pan.get(i);
           if(pa.isAcceso()){
               int id = pa.getId();
               pruebasAnalisis.add(String.valueOf(id));
               pruebasAnalisis.add("Analisis");
           }
       }
       if(!pruebasAnalisis.isEmpty())
        Pruebas.add(pruebasAnalisis);

       ArrayList<String> pruebasRadiologia = new ArrayList<String>();

       PruebaRadiologia pr;
       for(int i = 0; i < pra.size(); i++){
           pr = (PruebaRadiologia) pra.get(i);
           if(pr.isAcceso()){
               int id = pr.getId();
               pruebasRadiologia.add(String.valueOf(id));
               pruebasRadiologia.add("Radiologia");
           }
       }

      if(!pruebasRadiologia.isEmpty())
        Pruebas.add(pruebasRadiologia);

       return Pruebas;
   }

   public Receta seleccionarReceta(int idReceta) throws SQLException{
 
       RecetaBD recetabd= new RecetaBD();
       
       Receta receta=recetabd.obtenerReceta(idReceta);
     
       return receta;
           
       }
   
   public ArrayList<ArrayList > obtenerPruebas2(String dni) throws SQLException{
   
   
      PruebaAnalisisBD pabd=new PruebaAnalisisBD();
        PruebaRadiologiaBD prbd=new PruebaRadiologiaBD();
        ArrayList<PruebaAnalisis> pan=pabd.obtenerPruebasAnalisis(dni);
        ArrayList<PruebaRadiologia> pra=prbd.obtenerPruebasRadiologia(dni);
        ArrayList<ArrayList> pruebas=new ArrayList<ArrayList>();
        ArrayList pruebasAnalisis=new ArrayList();
        ArrayList pruebasRadiologia=new ArrayList();
        PruebaAnalisis pa;
        PruebaRadiologia pr;
        int id;
        for(Iterator itPan=pan.iterator();itPan.hasNext();){
            pa=(PruebaAnalisis) itPan.next();
            id=pa.getId();
            pruebasAnalisis.add(pa);
        }
        pruebas.add(pruebasAnalisis);
         for(Iterator itPra=pra.iterator();itPra.hasNext();){
            pr=(PruebaRadiologia) itPra.next();
            id=pr.getId();
            pruebasRadiologia.add(pr);
        }
        pruebas.add(pruebasRadiologia);
        return pruebas;
   
   
   }

}
