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

import BaseDatos.CitaBD;
import BaseDatos.PacienteBD;
import java.sql.SQLException;
import CentroMedico.Usuario;
import CentroMedico.Paciente;
import CentroMedico.Cita;

import java.util.*;


/**
 * @version     1.2     29/05/2011
 * @author      Sub_Equipo2
 */


public class GestorCitas {

    public GestorCitas(){}

    public Cita ObtenerCita(int id) throws SQLException{
        GestorPacientes gstpac = new GestorPacientes();
        CitaBD cita = new CitaBD();

        return cita.obtener(id);
    }

    public void CancelarCita(String dni)throws SQLException{

        CitaBD citabd = new CitaBD();
        //citabd.Eliminar(this.ObtenerCita(dni));
    }

    public ArrayList ObtenerListaCitasAnalista() throws SQLException{
        return new ArrayList();
    }

    public ArrayList ObtenerListaCitasRadiologo() throws SQLException{
        return new ArrayList();
    }

    public ArrayList<Cita> VerCitas(String dnipac) throws SQLException{

        PacienteBD pacBD = new PacienteBD();        
        Paciente pac = pacBD.obtener(dnipac);
        CitaBD citaBD = new CitaBD();        
        ArrayList<Cita> citas = citaBD.VerCitas(pac);

        return citas;

    }


    /** DE AQUI HACIA ABAJO NO SE HAN IMPLEMENTADO LOS METODOS **/


    public String AltaCita(String Dni) throws SQLException{
    /*
        CitasBD citasbd = new CitasBD();

        if(citasbd.ExisteCita(Dni)){
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

        */
        return "datos";
    }

    public String AltaCitaOnline(String Dni) throws SQLException{
        return "";
    }

    public String CancelarCitaOnline(Usuario usu) throws SQLException{
    /*
        CitasBD bd_citas=new CitasBD();

        String Dni=new String();
        Dni=usu.getDNI();

        boolean existe;
        existe=bd_citas.ExisteCita(Dni);

        if(!existe) {
            return "No existe Ninguna cita con ese "+Dni;
        }

        Cita cita=null;
        cita=bd_citas.ObtenerCita(Dni);

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
        bd_citas.Almacenar(cita);

       return "Cita cancelada";*/
        return "";
    }

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
