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
 * @author      Sub_Equipo2
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

    public String getDni(){
        return DNI;
    }

    public Date getFechaInicio(){
        return  FechaIni;
     }

    public Date getFechaFin(){
        return FechaEnd;
    }

    public String getTipoTurno(){
        return TipoTurno;
    }

    /*
     *
     * Metodos Asignadores
     *
     */

    public void setDni(String DNI){
        this.DNI=DNI;
    }

    public void setFechaInicio(Date FechaIni){
        this.FechaIni=FechaIni;
     }

    public void getFechaFin(Date FechaEnd){
        this.FechaEnd=FechaEnd;
    }

    public void getTipoTurno(String TipoTurno){
        this.TipoTurno=TipoTurno;
    }


}