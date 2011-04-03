/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author zerosk8
 */
public class GestorTurnos {
    GestorTurnos(){

    }

    public String altaTurno(String tipo)throws SQLException {
        String exito=new String();
        turnoBD bd_turno=new turnoBD();
        boolean existe;
        
        existe=bd_turno.existeTurno(tipo);

        if(!existe){
            bd_turno.altaTurno(tipo);
            exito="Se creó un Turno de tipo "+tipo;
        }
        else{
            exito="Ya existe un Turno del tipo "+tipo;
        }

        return exito;
    }

    // ESTA FUNCION NO FUNCIONA, YA QUE "existeTurno" PARA "turnoBD" SOLO
    // ESTA IMPLEMENTADA PARA PASARLE UN "tipo" DE TURNO, Y AQUI, LE
    // ESTAMOS PASANDO UN DNI
    public String bajaTurno(String Dni)throws SQLException {
        boolean existe;
        String existeSalida=new String();
        turnoBD bd_turno=new turnoBD();

        existe=bd_turno.existeTurno(Dni);

        if(existe){
           boolean puedo=bd_turno.puedoBorrarTurno(Dni);

           if(puedo){
               bd_turno.borraTurno(Dni);
               existeSalida="El turno del usuario identificado por "+Dni+" se dió de baja";
            }
            else{
               existeSalida="No se puede borrar el turno";
            }
        }
        else{
            existeSalida="No existen turnos para ese usuario";
        }
        
        return existeSalida;
    }

    public String asignarTurnoPersonal(String Dni,Date fechaInicio,Date fechaFin,String tipo){
        String exito=new String();
        GestorPacientes gestorPac=new GestorPacientes();

        

        return exito;
    }

    public String modificarTurnoPersonal(Dni,fechaInicio,fechaFin,tipo){
        String exito=new String();

        return exito;
    }

    public Turno consultarTurnoPersonal(Dni){

    }

    public ArrayList EstadisticasPersonalFecha(fecha){

    }
}
