/*
 * GestorUsuarios.java
 *
 * Informacion:
 * Clase encargada de operar con las citas de los usuarios
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package Controlador;

import BaseDatos.PacBD;
import CentroMedico.Paciente;
import BaseDatos.citasBD;
import java.sql.SQLException;

/**
 * @version     1.0    03/04/2011
 * @author      Sub_Equipo1
 */

// Esta clase está sin terminar
public class GestorCitas {

    // GestorCitas NO DEBE COMUNICARSE DIRECTAMENTE CON LA CLASE PacienteBD
    // SINO QUE DEBERIA COMUNICARSE CON GestorPacientes, Y ESTE CON PacienteBD
    public String alta_cita(String Dni) throws SQLException{
        String datosCita=new String();
        citasBD bd_citas=new citasBD();
        boolean existe;

        existe=bd_citas.existeCita(Dni);

        if(!existe){
            PacBD bd_paciente=new PacBD();
            Paciente paciente;

            paciente=bd_paciente.obtenerPaciente(Dni);
            
            if(paciente==null){
                datosCita="No existe el paciente";
            }
            else{
                // Faltan cosas
            }
        }
        else{
            datosCita="El paciente ya tiene una cita asignada";
        }

        return datosCita;
    }

//    public void setFecha(fecha){
//    }

//    public String alta_citaonline(){
//    }

    public String cancelarCitaOnline() throws SQLException{

        citasBD bd_citas=new citasBD();

        String Dni=new String();
        Dni=user.getDni();

        boolean existe;
        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe Ninguna cita con ese "+Dni;
        }

        Cita cita=new Cita();
        cita=bd_citas.obtenerCita(Dni);

        Date fecha=new Date();
        fecha=cita.getFecha();

        //no se como se hace

        cita.setEstado(false);
        bd_citas.almacenarCita(cita);
        //falta
    }

    public String cancelarCita(String Dni) throws SQLException{

        citasBD bd_citas=new citasBD();

        boolean existe;
        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe Ninguna cita con ese "+Dni;
        }

        Cita cita=new Cita();
        cita=bd_citas.obtenerCita(Dni);

        Date fecha=new Date();
        fecha=cita.getFecha();

        //no se como se hace

        cita.setEstado(False);
        bd_citas.almacenarCita(cita);
        //falta

    }

//    public String mostrarErrorCita(){
//    }

    public String ConsultarCita(String Dni) throws SQLException{

        citasBD bd_citas=new citasBD();
        PacBD bd_pac=new PacBD();

        String datos=new String();
        boolean existe;
        existe=bd_pac.existePaciente(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe el Paciente";
        }

        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe Ninguna Cita asociada al dni";
        }

        Cita cita=new Cita();
        cita=bd_citas.obtenerCita(Dni);

        String DniM=new String();
        DniM=cita.getDniMedico();
        Date fecha=new Date();
        fecha=cita.getFecha();

        datos="Para este "+Dni+" no hay una cita con el Medico "+DniM+" y Fecha "+fecha;
        return datos;

    }

//    public String MostrarErrorPaciente(){
//    }

    public String ConsultarCitaOnline() throws SQLException{

        citasBD bd_citas=new citasBD();
        PacBD bd_pac=new PacBD();

        String datos=new String();

        String Dni=new String();
        Dni=user.getDni();

        boolean existe;
        existe=bd_pac.existePaciente(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe el Paciente";
        }

        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            this.mostrarErrorCita();
            return "No existe Ninguna Cita asociada al dni";
        }

        Cita cita=new Cita();
        cita=bd_citas.obtenerCita(Dni);

        String DniM=new String();
        DniM=cita.getDniMedico();
        Date fecha=new Date();
        fecha=cita.getFecha();

        datos="Para este "+Dni+" no hay una cita con el Medico "+DniM+" y Fecha "+fecha;
        return datos;

    }

//    public boolean ModificarCita(Dni){
//    }

//    public boolean ModificarCitaOnline(){
//    }

    //public Arraylist EstadisticasCitas(fecha_inicio,fecha_fin){}
}
