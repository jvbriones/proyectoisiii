/*
 * GestorTurnos.java
 *
 * Informacion:
 * Clase encargada de operar con los turno establecidos en el centro medico en asignados al personal.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @version     1.0     03/04/2011
 * @author      Sub_Equipo1
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

    // ESTA FUNCION NO FUNCIONA, YA QUE "existeTurno" EN "turnoBD" SOLO
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

    public String asignarTurnoPersonal(String Dni,Date fechaInicio,Date fechaFin,String tipo) throws SQLException{
        String exito=new String();
        GestorPersonal gestorPers=new GestorPersonal();
        boolean existe;

        existe=gestorPers.existePersonal(Dni);

        if(existe){
            turnoBD bd_turno=new turnoBD();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            
            bd_turno.asignaTurno(Dni,fechaInicio,fechaFin,tipo);
            exito="El turno asignado al usuario "+Dni+" es "+tipo+" con esta fecha ";
            exito+=sdf.format(fechaInicio);
        }
        else{
            exito="No existe ningún usuario con dni "+Dni;
        }

        return exito;
    }

    public String modificarTurnoPersonal(String Dni,Date fechaInicio,Date fechaFin,String tipo) throws SQLException{
        String exito=new String();
        GestorPersonal gestorPers=new GestorPersonal();
        boolean existe;

        existe=gestorPers.existePersonal(Dni);

        if(existe){
            turnoBD bd_turno=new turnoBD();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

            bd_turno.modificaTurno(Dni,fechaInicio,fechaFin,tipo);
            exito="El turno asignado al usuario "+Dni+" es "+tipo+" con esta fecha ";
            exito+=sdf.format(fechaInicio);
        }
        else{
            exito="No existe ningún usuario con dni "+Dni;
        }

        return exito;
    }

    public Turno consultarTurnoPersonal(String Dni){
        
    }

    //public ArrayList EstadisticasPersonalFecha(fecha){}
}
