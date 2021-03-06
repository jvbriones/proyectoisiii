/*
 * Cita.java
 *
 * Informacion:
 * Clase encargada de modelizar las Citas
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.util.*;
import java.io.Serializable;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */

public class Cita implements Serializable{

    private boolean Estado;
    private Date Fecha;
    private String Tipo;

    private Paciente Paciente;
    private PersonalMedico PersonalMedico;

    /*
     *
     * Constructores
     *
     */

    public Cita() {
        this.Fecha = new Date(0);
    }

    public Cita(Date Fecha, boolean Estado, String Tipo){
        this.Fecha=Fecha;
        this.Estado=Estado;
        this.Tipo=Tipo;
    }
    
    /*
     *
     * Metodos Consultores
     *
     */
    public Date getFecha(){
        return Fecha;
    }
    
    public boolean getEstado(){
        return Estado;
    }

    public String getTipo(){
        return Tipo;
    }

    public Paciente getPaciente(){
        return Paciente;
    }

    public PersonalMedico getPersonalMedico(){
        return  PersonalMedico;
    }

    /*
      *
      * Metodos Asignadores
      *
      */

    public void setFecha(Date Fecha){
        this.Fecha=Fecha;
    }

    public void setEstado(boolean Estado ){
        this.Estado=Estado;
    }

    public void setTipo(String Tipo){
        this.Tipo=Tipo;
    }

    public void setPaciente(Paciente Paciente){
        this.Paciente=Paciente;
    }

    public void setPersonalMedico( PersonalMedico PersonalMedico){
        this.PersonalMedico=PersonalMedico;
    }
}