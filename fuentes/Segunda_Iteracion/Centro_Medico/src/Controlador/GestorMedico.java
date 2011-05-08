/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.PacBD;
import BaseDatos.RecetaBD;
import CentroMedico.Cita;
import CentroMedico.Medicamento;
import CentroMedico.MedicamentoRecetado;
import CentroMedico.Paciente;
import CentroMedico.Receta;
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

    public boolean realizarReceta(String Instrucciones, String JuicioDiagnostico){
        Date fecha = new Date();
        Receta re = new Receta(Instrucciones,JuicioDiagnostico, fecha);

        ArrayList medicamentos;
        Set<MedicamentoRecetado> medRec;
        MedicamentoRecetado aux;
        Medicamento med = null;
        boolean exito;
        RecetaBD rBD = new RecetaBD();
        MedicamentoRecetado me;

        medRec = re.getMedicamentosRecetados();



        for( Iterator it = medRec.iterator(); it.hasNext();) {
	    aux = (MedicamentoRecetado)it.next();
            med = aux.getMed();
            me = this.recetarMedicamento(med, aux.getPosologia(), aux.getDuracion(), aux.getFechaFin());
        }

        rBD.almacenar(re);// No existe la operación agregar por eso uso almacenar pero no me devuelve un bool

        return true;

    }

    public MedicamentoRecetado recetarMedicamento(Medicamento medica, String Posologia, int Duracion, Date FechaFin){
        MedicamentoRecetado me = new MedicamentoRecetado(medica, Posologia, Duracion, FechaFin, true);
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
