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
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */

public class Cita {

    private boolean Estado;
    private Date Fecha;
    private String DNIPac;
    private String DNIMed;

    /*
     *
     * Constructores
     *
     */
    
    public Cita(String DniPac, String DniMec, Date Fecha, boolean Estado){

        this.DNIPac=DniPac;
        this.DNIMed=DniMec;
        this.Fecha=Fecha;
        this.Estado=Estado;

    }

    public Cita(String DniPac, String DniMec, Date Fecha){

        this.DNIPac=DniPac;
        this.DNIMed=DniMec;
        this.Fecha=Fecha;
        this.Estado=true;
    }
    
    /*
     *
     * Metodos Consultores
     *
     */

    String getDniPaciente(){
        return DNIPac;
    }

    String getDniMedico(){
        return  DNIMed;
     }

    Date getFecha(){
        return Fecha;
    }
    
    boolean getEstado(){
        return Estado;
    }

     /*
      *
      * Metodos Asignadores
      *
      */

    void setEstado(boolean Estado){
        this.Estado=Estado;
    }


}