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


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */

public class Cita {

    private boolean Estado;
    private Date Fecha;
    private String Tipo;

    private Paciente Paci;
    private PersonalMedico Perso;

    /*
     *
     * Constructores
     *
     */
    
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
        return Paci;
    }

    public PersonalMedico getPersonalMedico(){
        return  Perso;
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

    public void setPaciente(Paciente Paci){
        this.Paci=Paci;
    }

    public void setPersonalMedico( PersonalMedico Perso){
        this.Perso=Perso;
    }
}