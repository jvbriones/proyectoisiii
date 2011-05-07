/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.PacBD;
import CentroMedico.Cita;
import CentroMedico.Medicamento;
import CentroMedico.MedicamentoRecetado;
import CentroMedico.Paciente;
import CentroMedico.Receta;
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
        }

    }

    public boolean realizarReceta(String Instrucciones, String JuicioDiagnostico){
        Date fecha = new Date();
        Receta re = new Receta(Instrucciones,JuicioDiagnostico, fecha);

        ArrayList medicamentos;
        boolean fin = false;
        Set<MedicamentoRecetado> medRec;
        MedicamentoRecetado aux;

        medRec = re.getMedicamentosRecetados();



        for( Iterator it = medRec.iterator(); it.hasNext();) {
	    aux = (MedicamentoRecetado)it.next();
            //recetarMedicamento(nomMed,posologia, duracion, fFin);
        }

    }

    public void guardarVolante(String Volante){
        //Implementación en la 3ª iteración
    }

    public Cita solicitarCitaPrueba(String Dni, String TipoPrueba) throws SQLException{

        PacBD pBD = new PacBD();
        Paciente paciente = null;

        paciente = pBD.obtenerPaciente(Dni);
        if(TipoPrueba == "sangre" || TipoPrueba == "orina"){
            paciente.asignarCita(cita);
            
        }
    }

}
