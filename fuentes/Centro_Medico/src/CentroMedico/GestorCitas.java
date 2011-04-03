/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

import java.sql.SQLException;

/**
 *
 * @author zerosk8
 */
public class GestorCitas {
    
    public String alta_cita(String Dni) throws SQLException{
        String datosCita=new String();
        citasBD bd_citas=new citasBD();
        boolean existe;

        existe=bd_citas.existeCita(Dni);

        if(!existe){
            PacBD bd_paciente=new PacBD();
            Paciente paciente;

            paciente=bd_paciente.obtenerPaciente(Dni);
            
            if(paciente==null)
        }
        else{
            datosCita="El paciente ya tiene una cita asignada";
        }

        return datosCita;
    }

    public void setFecha(fecha){
    }

    public String alta_citaonline(){
    }

    public String cancelarCitaOnline(){
    }

    public String cancelarCita(Dni){
    }

    public String mostrarErrorCita(){
    }

    public String ConsultarCita(Dni){
    }

    public String MostrarErrorPaciente(){
    }

    public String ConsultarCitaOnline(){
    }

    public boolean ModificarCita(Dni){
    }

    public boolean ModificarCitaOnline(){
    }

    //public Arraylist EstadisticasCitas(fecha_inicio,fecha_fin){}
}
