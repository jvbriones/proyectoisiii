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

/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */

public class Turno {

    private String DNI;
    private Date FechaIni;
    private Date FechaEnd;
    private String TipoTurno;

    /*
     *
     * Constructores
     *
     */

    public Turno(String DNI, Date FechaIni, Date FechaEnd, String TipoTurno){

        this.DNI=DNI;
        this.FechaIni=FechaIni;
        this.FechaEnd=FechaEnd;
        this.TipoTurno=TipoTurno;

    }

    /*
     *
     * Metodos Consultores
     *
     */

    String getDni(){
        return DNI;
    }

    Date getFechaInicio(){
        return  FechaIni;
     }

    Date getFechaFin(){
        return FechaEnd;
    }

    String getTipoTurno(){
        return TipoTurno;
    }

    /*
     *
     * Metodos Asignadores
     *
     */

    void setDni(String DNI){
        this.DNI=DNI;
    }

    void setFechaInicio(Date FechaIni){
        this.FechaIni=FechaIni;
     }

    void getFechaFin(Date FechaEnd){
        this.FechaEnd=FechaEnd;
    }

    void getTipoTurno(String TipoTurno){
        this.TipoTurno=TipoTurno;
    }


}