/*
 * GestorTurnos.java
 *
 * Informacion:
 * Clase encargada de operar con los turno establecidos en el centro medico y asignados al personal
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package Controlador;

import CentroMedico.Turno;
import BaseDatos.TurnoBD;
import BaseDatos.personalBD;
import CentroMedico.Personal;
import CentroMedico.PersonalMedico;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorTurnos {
    
    public String altaTurno(String tipo,String Dni)throws SQLException {
        // MIguel.  Tipo es " mañana" "tarde " o "noche"

         String exito=new String();
        personalBD perb= new personalBD();
        Personal per= new Personal();

        per = perb.obtener(Dni);

        if (per==null) System.out.println("No se puede asignar el Turno porque el Personal no Existe");
        else{

            boolean tiene_turno=false;

            // Miguel. Falta esta tiene_turno=per.tiene_turno();

            if ( tiene_turno) exito="Ya existe un Turno del tipo "+tipo;
            else{
                TurnoBD bd_turno=new TurnoBD();
                bd_turno.altaTurno(tipo,Dni);
                exito="Se creó un Turno de tipo "+tipo;
                }
        }
        
        return exito;
    }

    // ESTA FUNCION NO FUNCIONA, YA QUE "existeTurno" EN "turnoBD" SOLO
    // ESTA IMPLEMENTADA PARA PASARLE UN "tipo" DE TURNO, Y AQUI, LE
    // ESTAMOS PASANDO UN DNI   MIguel. Ya si!
    
    public String bajaTurno(String Dni)throws SQLException {
        boolean existe;
        String existeSalida=new String();
        TurnoBD bd_turno=new TurnoBD();

        existe=bd_turno.existeTurno(Dni);

        if(existe){

            bd_turno.borraTurno(Dni);
               existeSalida="El turno del usuario identificado por "+Dni+" se dió de baja";
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
            TurnoBD bd_turno=new TurnoBD();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            
           //  Miguel. Falta Este bd_turno.asignaTurno(Dni,fechaInicio,fechaFin,tipo);
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
            TurnoBD bd_turno=new TurnoBD();
            // Esta variable es necesario tenerla para convertir tipo "Date" a String
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

          // Miguel. Falta Este bd_turno.modificaTurno(Dni,fechaInicio,fechaFin,tipo);
            exito="El turno asignado al usuario "+Dni+" es "+tipo+" con esta fecha ";
            exito+=sdf.format(fechaInicio);
        }
        else{
            exito="No existe ningún usuario con dni "+Dni;
        }

        return exito;
    }

    public String consultarTurnoPersonal(String Dni) throws SQLException{
        String exito=new String();
        GestorPersonal gestorPers=new GestorPersonal();
        boolean existe;

        existe=gestorPers.existePersonal(Dni);

        if(existe){
            TurnoBD bd_turno=new TurnoBD();
            boolean existe2;

            existe2=bd_turno.existeTurno(Dni);

            if(existe2){
                Turno turno;
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                
                turno=bd_turno.obtener(Dni);
//                String fechaI=new String(sdf.format(turno.getFechaInicio()));
  //              String tipo=new String(turno.getTipoTurno());
    //            String fechaF=new String(sdf.format(turno.getFechaFin()));

       //         exito="El turno es desde el día "+fechaI+" hasta "+fechaF;
         //       exito+=", del tipo "+tipo;
            }
            else{
                exito="El usuario "+Dni+" no tiene ningun turno asignado";
            }
        }
        else{
            exito="No existe ningún usuario con dni "+Dni;
        }
        
        return exito;
    }

    //public ArrayList EstadisticasPersonalFecha(fecha){}
}
