/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.CitaBD;
import BaseDatos.PacienteBD;
import BaseDatos.PruebaAnalisisBD;
import BaseDatos.PruebaRadiologiaBD;
import BaseDatos.RecetaBD;
import CentroMedico.Cita;
import CentroMedico.Enfermedad;
import CentroMedico.Medicamento;
import CentroMedico.MedicamentoRecetado;
import CentroMedico.Paciente;
import CentroMedico.PersonalMedico;
import CentroMedico.PruebaAnalisis;
import CentroMedico.PruebaRadiologia;
import CentroMedico.Receta;
import java.lang.String;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author pantic
 */
public class GestorMedico {
    Receta re = null;

    public void atenderPaciente(String Dni) throws SQLException{
        GestorPacientes pacientes = new GestorPacientes();
        Paciente pac = new Paciente();

        pac = pacientes.obtenerPaciente(Dni);//En el diseño pone operación obtener pero no tiene sentido, se referirá a esta operación

        if(pac != null){
            //se elige entre solicitar una cita o recetar un medicamento
            //operacion guardar volante para la 3ª iteración
        }

    }

    /*
     * He creado una operación que no aparece en el diagrama de clases pero que si aparece en
     * el de diseño, he tenido que modificarle el atributo que se le pasa de nombreMedicamento(String)
     * por uno llamado medica de tipo Medicamento para poder implementar dicha función.
     * En cuanto al return he tenido que poner true por defecto porque no existe la operación de agregar
     * en la clase RecetaBD y he tenido que usar almacenar que es la más parecida pero como es una función
     * void y no devuelve nada no puedo hacer return exito como especifica el diseño. Todo esto ya ha sido
     * comunicado al equipo de diseño para su corrección.
     *
     */

    public boolean realizarReceta(String Instrucciones, String JuicioDiagnostico,Set<Medicamento> medica, String Posologia, int Duracion, Date FechaFin){
        Date fecha = new Date();
        re = new Receta(Instrucciones,JuicioDiagnostico, fecha);

        ArrayList medicamentos;
        Set<MedicamentoRecetado> medRec;
        Medicamento aux;
        Medicamento med = null;
        boolean exito;
        RecetaBD rBD = new RecetaBD();
        MedicamentoRecetado me;




        for( Iterator it = medica.iterator(); it.hasNext();) {
	    med = (Medicamento)it.next();
            System.out.println(med.getNombre());
            me = this.recetarMedicamento(med, Posologia, Duracion, FechaFin);
        }
        
        rBD.almacenar(re);


        return true;

    }

    public MedicamentoRecetado recetarMedicamento(Medicamento medica, String Posologia, int Duracion, Date FechaFin){
        MedicamentoRecetado me = new MedicamentoRecetado(medica, Posologia, Duracion, FechaFin, true);
        re.getMedicamentosRecetados().add(me);

        return me;

    }
    public boolean anadirEnfermedad(String Nombre,String Tipo, Date FechaDet,String Descripcion,String Volante,Paciente Paci){

        
        PacienteBD pac=new PacienteBD();
        Enfermedad enfe = new Enfermedad(Nombre,Tipo,FechaDet,Descripcion,Volante);
        Paci.anadirEnfermedad(enfe);
        pac.actualizar(Paci);
        return true;

    }
    public boolean modificarEnfermedad(Enfermedad enfe,Paciente paciente){

          Set<Enfermedad> enfermedades= paciente.getEnfermedades();
          PacienteBD pac_BD = new PacienteBD();
      for( Iterator it = enfermedades.iterator(); it.hasNext();){

          Enfermedad aux= (Enfermedad)it.next();
          if( aux.getId() == enfe.getId())
                aux=enfe;
      }

      pac_BD.actualizar(paciente);

      return true; 
        
    }
    public HashMap<String,ArrayList<String>> consultarHistorialPacientes(String dniMedico) throws SQLException{
        HashMap<String,ArrayList<String>> histo= new HashMap<String,ArrayList<String>>();
        ArrayList<String> Atributos=new ArrayList<String>();
        CitaBD citabd=new CitaBD();
        PacienteBD pacbd=new PacienteBD();
        Set<Cita> Citas=citabd.ObtenerTodasCitas();
        Cita ci;
        String dniMedicoCita;
        String dniPaciente;
        Paciente paci;
        for(Iterator itCi=Citas.iterator();itCi.hasNext();){
            ci=(Cita) itCi.next();
            dniMedicoCita=ci.getDNIMedico();
            if(dniMedicoCita.equals(dniMedico)){
                dniPaciente=ci.getDNIPaciente();
                paci=pacbd.obtener(dniPaciente);
                Atributos.add(paci.getNombre());
                Atributos.add(paci.getApellidos());
                //Atributos.add(paci.getEmail());
                histo.put(dniPaciente, Atributos);
            }
        }
        return histo;

    }
    public ArrayList<ArrayList> consultarHistorialPruebasPaciente( String dniPaciente) throws SQLException{
        PruebaAnalisisBD pabd=new PruebaAnalisisBD();
        PruebaRadiologiaBD prbd=new PruebaRadiologiaBD();
        ArrayList<PruebaAnalisis> pan=pabd.obtenerPruebasAnalisis(dniPaciente);
        ArrayList<PruebaRadiologia> pra=prbd.obtenerPruebasRadiologia(dniPaciente);
        ArrayList<ArrayList> pruebas=new ArrayList<ArrayList>();
        ArrayList pruebasAnalisis=new ArrayList();
        ArrayList pruebasRadiologia=new ArrayList();
        PruebaAnalisis pa;
        PruebaRadiologia pr;
        int id;
        for(Iterator itPan=pan.iterator();itPan.hasNext();){
            pa=(PruebaAnalisis) itPan.next();
            id=pa.getId();
            pruebasAnalisis.add(id);
        }
        pruebas.add(pruebasAnalisis);
         for(Iterator itPra=pra.iterator();itPra.hasNext();){
            pr=(PruebaRadiologia) itPra.next();
            id=pr.getId();
            pruebasRadiologia.add(id);
        }
        pruebas.add(pruebasRadiologia);
        return pruebas;
    }
/*
    public void guardarVolante(String Volante){
        //Implementación en la 3ª iteración
    }
    //comentado por Nicolás
   // public Cita solicitarCitaPrueba(String Dni, String TipoPrueba) throws SQLException{

        PacBD pBD = new PacBD();
        Paciente paciente = null;

        paciente = pBD.obtenerPaciente(Dni);
        if(TipoPrueba == "sangre" || TipoPrueba == "orina"){
            paciente.asignarCita(cita);//¿De donde sale cita? Un paciente no tiene la operación asignarCita
            //No puedo seguir programando porque no tiene sentido nada del diagrama
            
        }
    }
*/
}
