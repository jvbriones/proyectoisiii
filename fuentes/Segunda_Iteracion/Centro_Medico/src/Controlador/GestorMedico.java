/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.*;
import CentroMedico.*;
import java.lang.String;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    public boolean realizarReceta(String Instrucciones, String JuicioDiagnostico,Set<Medicamento> medica, String Posologia, int Duracion, Date FechaFin, String paci, String medi) throws SQLException{
        Date fecha = new Date();
        PacBD pac = new PacBD();
        Paciente pacien;
        MedicoBD medBD = new MedicoBD();
        PersonalMedicoBD pm = new PersonalMedicoBD();
        Medico medic;
        pacien = pac.obtener(paci);
       // medic = medBD.obtener(medi);
        PersonalMedico m;
        m = pm.obtener(medi);
       // medic = (Medico)us.obtener(medi);
        re = new Receta(Instrucciones,JuicioDiagnostico, fecha, pacien, m);

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
        MedicamentoRecetado me = new MedicamentoRecetado(medica, Posologia, Duracion, FechaFin, false);
        System.out.println("Medicamento recetado: "+me.getMedicamento().getNombre());
        boolean fin;
        re.getMedicamentosRecetados().add(me);     

        return me;

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
