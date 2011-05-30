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

    private int Id;
    private boolean Estado;
    private Date Fecha;
    private String Tipo;
    private String DNIPaciente;
    private String DNIMedico;


    /********** Constructores **********/
    public Cita(boolean estado, Date fecha, String tipo, String DNIpaciente, String DNImedico){
        
        this.Estado=estado;
        this.Fecha=fecha;
        this.Tipo=tipo;
        this.DNIPaciente = DNIpaciente;
        this.DNIMedico = DNImedico;

    }

    public Cita(Date fecha, String DNIpaciente, String DNImedico){

        this.Estado = true;
        this.Fecha = fecha;
        this.DNIPaciente = DNIpaciente;
        this.DNIMedico = DNImedico;
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

    public String getDNIPaciente(){
        return DNIPaciente;
    }

    public String getDNIMedico(){
        return  DNIMedico;
    }

    public boolean isEstado() {
        return Estado;
    }

    public int getId() {
        return Id;
    }


    /********* Metodos Asignadores **********/

    public void setEstado(boolean Estado ){
        this.Estado=Estado;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setDNIPaciente(String DNIPaciente) {
        this.DNIPaciente = DNIPaciente;
    }

    public void setDNIMedico(String DNIMedico) {
        this.DNIMedico = DNIMedico;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

}