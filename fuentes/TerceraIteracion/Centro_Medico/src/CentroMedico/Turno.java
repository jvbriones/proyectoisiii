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

    private String DNI;
    private Date HoraInicio;
    private Date HoraFin;
    private String Tipo;

    /*
     *
     * Constructores
     *
     */

    public Turno() {
    }

    public Turno(String DNI, Date HoraInicio, Date HoraFin, String Tipo){

        this.DNI=DNI;
        this.HoraInicio=HoraInicio;
        this.HoraFin=HoraFin;
        this.Tipo=Tipo;
    }

    /*
     *
     * Metodos Consultores
     *
     */

    public String getDNI(){
        return DNI;
    }

    public Date getHoraInicio(){
        return  HoraInicio;
     }

    public Date getHoraFin(){
        return HoraFin;
    }

    public String getTipo() {
        return Tipo;
    }


    /*
     *
     * Metodos Asignadores
     *
     */

    public void setDNI(String DNI){
        this.DNI=DNI;
    }

    public void setHoraInicio(Date HoraInicio){
        this.HoraInicio=HoraInicio;
     }

    public void setHoraFin(Date HoraFin){
        this.HoraFin=HoraFin;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

}