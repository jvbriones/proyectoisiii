/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package centro_medico;

import java.util.*;
import java.awt.*;

/**
 *
 * @author José Peso Buendía
 */
public class Paciente {

    private String nombre;
    private String apellidos;
    private String dni;
    private String contrasena;
    private String domicilio;
    private int telefono;
    private String email;
    private Date fecha_nac;
    private String lugar_nac;
    private Image foto;

    private Cita cita;

    public Paciente (){
        dni=null;
        apellidos=null;
        dni=null;
        contrasena=null;
        domicilio=null;
        telefono=0;
        email=null;
        fecha_nac=null;
        lugar_nac=null;
        foto=null;
        cita=null;
    }
    
    public Paciente (String n, String a, String d, String c, String domi, int t, String e, Date fn, String ln, Image f){

        dni=n;
        apellidos=a;
        dni=d;
        contrasena=c;
        domicilio=domi;
        telefono=t;
        email=e;
        fecha_nac=fn;
        lugar_nac=ln;
        foto=f;
        cita=null;
    }

    public ArrayList ConsultarPaciente (String dni) {
        
        Paciente paciente = BuscarPaciente(dni);

        ArrayList datos;
        datos=paciente.GetDatosPersonales();

        return datos;

    }

    public Paciente BuscarPaciente(String dni) throws PacienteException{
    
    }

    public ArrayList GetDatosPersonales() {

    }

    public String AltaPaciente (String n, String d, int t, String domi){

        String cod=almacenarPaciente(n, d, t, domi);

        return cod;

    }
}
