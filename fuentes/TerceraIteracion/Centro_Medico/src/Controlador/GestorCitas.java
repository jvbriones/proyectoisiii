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
import BaseDatos.CitasBD;
import java.sql.SQLException;
import CentroMedico.Usuario;
import CentroMedico.Cita;

import java.util.*;


/**
 * @version     1.2     29/05/2011
 * @author      Sub_Equipo2
 */

// Esta clase está sin terminar
// GestorCitas NO DEBE COMUNICARSE DIRECTAMENTE CON LA CLASE PacienteBD
// SINO QUE DEBERIA COMUNICARSE CON GestorPacientes, Y ESTE CON PacienteBD
public class GestorCitas {

    public GestorCitas(){}

    /* FUNCION SIN TERMINAR
     * Alta cita. Crea una nueva cita.
     * @param Dni, identificador del paciente del que se va a crear una cita.
     * @return Mensaje de respuesta con el resultado de la operación.
     */
    public String AltaCita(String Dni) throws SQLException{

        CitasBD citasbd = new CitasBD();
//      PacBD pacientebd = new PacBD();

        if(citasbd.existeCita(Dni)){
            //Ya existe una cita para este Paciente
            //Mostrar la cita?
            return "Ya existe una cita para este Paciente";
        }else{
            GestorPacientes gpac = new GestorPacientes();
            if(gpac.obtenerPaciente(Dni) == null){
                //Alta paciente
                //Dar de alta al paciente?
            }else{
                
            }
            PacBD pacientebd = new PacBD();
            Paciente paciente = pacientebd.obtener(Dni);
        }

        
        return "datos";
    }

    /*  FUNCION SIN TERMINAR
     *  AltaCita
     */
    public String AltaCitaOnline(String Dni) throws SQLException{
        return "";
    }

    /*
     * Cancelar cita
     * @param dni, Identificacion del paciente que quiere cancelar la cita
     */
    public void CancelarCita(String dni)throws SQLException{
        CitasBD citabd = new CitasBD();
        citabd.eliminar(this.obtenerCita(dni));
    }

    //Este metodo no hará falta
    public String CancelarCitaOnline(Usuario usu) throws SQLException{

        CitasBD bd_citas=new CitasBD();

        String Dni=new String();
        Dni=usu.getDNI();

        boolean existe;
        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            return "No existe Ninguna cita con ese "+Dni;
        }

        Cita cita=null;
        cita=bd_citas.obtenerCita(Dni);

        Date fecha = null;
        fecha = cita.getFecha();
        int dia = fecha.getDay();
        int mes = fecha.getMonth();
        ++mes;//mes, de 0 a 11
        int anio = fecha.getYear();

        // desde la interfaz se manda un mensaje por pantalla para eliminar la cita
        // si dice que si, se viene aquí de nuevo, y se hace las operaciones del DS
        // si dice que no, desde la interfaz, se finaliza la operacion.

        cita.setEstado(false);
        bd_citas.almacenar(cita);

       return "Cita cancelada";
    }

    /*
     * Obtener Cita
     * @param dni, Identificacion del paciente del que se obtiene la cita.
     * @return Objeto 'Cita', si no existe la cita devuelve un objeto 'null'
     */
    public Cita ObtenerCita(String dni) throws SQLException{
        CitasBD cita = new CitasBD();

        return cita.obtenerCita(dni);
    }

    /* HAY QUE MODIFICARLO
     * ExisteCita
     */
    public boolean ExisteCita(Date fecha){
        return true;
    }


    public String ConsultarCita(String Dni) throws SQLException{
    /*
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
        */
        return "";
    }

//    public String MostrarErrorPaciente(){
//    }

    public String ConsultarCitaOnline() throws SQLException{
    /*
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
        */
        return "";
    }
    
}
