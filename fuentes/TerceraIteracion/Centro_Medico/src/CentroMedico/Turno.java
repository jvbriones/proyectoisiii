/*
 * Turno.java
 *
 * Informacion:
 * Clase encargada de modelizar los Turnos
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
 * modificado por Juan Carlos Bermúdez
 */
public class Turno implements Serializable{

    private String dni;
    private Date fechaInicio;
    private Date fechaFin;
    private String Tipo;

    /*
     *
     * Constructores
     *
     */

    public Turno() {
    }

    public Turno(String dni, String tipo, Date fechaInicio, Date fechaFin){

        this.dni=dni;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.Tipo=tipo;
    }

    /*
     *
     * Metodos Consultores
     *
     */

    public String getDni(){
        return dni;
    }

    public Date getfechaInicio(){
        return  fechaInicio;
     }

    public Date getfechaFin(){
        return fechaFin;
    }

    public String getTipo(){
        return Tipo;
    }

    /*
     *
     * Metodos Asignadores
     *
     */

    public void setDni(String dni){
        this.dni=dni;
    }

    public void setFechaInicio(Date FechaInicio){
        this.fechaInicio=FechaInicio;
     }

    public void setFechaFin(Date fechaFin){
        this.fechaFin=fechaFin;
    }

    public void setTipo(String Tipo){
        this.Tipo=Tipo;
    }

    public void actualizar(String dni,String tipo, Date fechainicio, Date fechafin) {
  
        this.Tipo=tipo;
        this.dni=dni;
        this.fechaInicio=fechainicio;
        this.fechaFin=fechafin;
        
        
    }
}