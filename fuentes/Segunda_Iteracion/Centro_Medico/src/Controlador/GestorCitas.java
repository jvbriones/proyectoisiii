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
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

// Esta clase está sin terminar
public class GestorCitas {

    // GestorCitas NO DEBE COMUNICARSE DIRECTAMENTE CON LA CLASE PacienteBD
    // SINO QUE DEBERIA COMUNICARSE CON GestorPacientes, Y ESTE CON PacienteBD
    public String alta_cita(String Dni) throws SQLException{
        String datosCita=new String();
        CitasBD bd_citas=new CitasBD();
        boolean existe;

        existe=bd_citas.existeCita(Dni);

        if(!existe){
            PacBD bd_paciente=new PacBD();
            Paciente paciente;

            paciente=bd_paciente.obtener(Dni);
            
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

    public String cancelarCitaOnline(Usuario usu) throws SQLException{

        CitasBD bd_citas=new CitasBD();

        String Dni=new String();
        Dni=usu.getDNI();

        boolean existe;
        existe=bd_citas.existeCita(Dni);

        if(!existe) {
            //this.mostrarErrorCita();
            return "No existe Ninguna cita con ese "+Dni;
        }

        Cita cita=null;
        cita=bd_citas.obtenerCita(Dni);

        Date fecha=null;
        fecha=cita.getFecha();

        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);   //dia del mes
        int mes = calendar.get(Calendar.MONTH);
        mes=mes+1;//mes, de 0 a 11
        int anio = calendar.get(Calendar.YEAR);  //año


        // desde la interfaz se manda un mensaje por pantalla para eliminar la cita
        // si dice que si, se viene aquí de nuevo, y se hace las operaciones del DS
        // si dice que no, desde la interfaz, se finaliza la operacion.






      

        cita.setEstado(false);
        bd_citas.almacenarCita(cita);


       return " cita cancelada";
    }

    /*
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

    //public Arraylist EstadisticasCitas(fecha_inicio,fecha_fin){}*/
}
