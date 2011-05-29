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
import java.util.Calendar.*;

/**
 * @version     1.2     27//2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 * modificado por Juan Cabrera
 */

public class Cita implements Serializable{

    private boolean Estado;
    private Date Fecha;
    private String Tipo;
    private Paciente Paciente;
    private PersonalMedico PersonalMedico;


    /********** Constructores **********/
    public Cita(boolean estado, Date fecha, String tipo, Paciente paciente, PersonalMedico pmedico){
        
        this.Estado=estado;
        this.Fecha=fecha;
        this.Tipo=tipo;
        this.Paciente = paciente;
        this.PersonalMedico = pmedico;

    }

    public Cita(Date fecha, Paciente paciente, PersonalMedico pmedico){

        this.Estado = true;
        this.Fecha = fecha;
        this.Paciente = paciente;
        this.PersonalMedico = pmedico;
        if(Fecha.getHours() < 16){
            this.Tipo = "Mañana";
        } else {
            if(Fecha.getHours() < 24)
                this.Tipo = "Tarde";
            else
                this.Tipo = "Noche";
        }
    }


    /********** Metodos Consultores **********/
     
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


    /********* Metodos Asignadores **********/

    public void setEstado(boolean Estado ){
        this.Estado=Estado;
    }

}