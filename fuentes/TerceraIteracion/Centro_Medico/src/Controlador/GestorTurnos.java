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
import BaseDatos.PersonalMedicoBD;
import CentroMedico.PersonalMedico;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorTurnos {

    public boolean altaTurno(String dni,String tipo,Date inicio,Date fin)throws SQLException {
        // MIguel.  Tipo es " mañana" "tarde " o "noche"

  
        PersonalMedicoBD personal= new PersonalMedicoBD();
        
        TurnoBD turbd = new TurnoBD();
        boolean bien=false;

        boolean existe_turno=false;
        boolean existe_personal=false;

          existe_turno=turbd.existeTurno(dni);
          existe_personal=personal.existePersonal(dni);
          

            if (existe_turno || !existe_personal){
                bien=false;
                
            }
             
           else{
             
                PersonalMedico personalmed = new PersonalMedico();
                personalmed=personal.obtener(dni);
                
                Turno tur=new Turno();
                
                tur.setDNI(dni);
                tur.setHoraFin(fin);
                tur.setHoraInicio(inicio);
                tur.setTipo(tipo);
                
                personalmed.setTurno(tur);
                
                personal.actualizar(personalmed);
                
                bien=true;
                }
        
        
        return bien;
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

            Turno tur= new Turno();
            bd_turno.obtener(Dni);
            
            bd_turno.eliminar(tur);
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

    public boolean modificarTurnoPersonal(String Dni,Date fechaInicio,Date fechaFin,String tipo) throws SQLException{
       boolean exito=false;
        
            PersonalMedico personal=new PersonalMedico();
        PersonalMedicoBD personalbd= new PersonalMedicoBD();
    
          
        personal=personalbd.obtener(Dni);
        
        if ( personal!= null){
            
        
            Turno tur=new Turno();
            tur.setDNI(Dni);
            tur.setHoraInicio(null);
            tur.setHoraFin(null);
            tur.setTipo(tipo);
        
            personal.setTurno(tur);
            
           personalbd.actualizar(personal);
        exito=true;
    }
        else exito=false;
        return exito;
    }

    public Turno consultarTurnoPersonal(String Dni) throws SQLException{
      Turno tur=null;
        PersonalMedicoBD personalbd= new PersonalMedicoBD();
        PersonalMedico personal= new PersonalMedico();
        
     
            personal=personalbd.obtener(Dni);
            
            if ( personal!=null ){
                System.out.println("El DNI Es de un PersonalMedico");

                if ( personal.getTurno()!=null){
                    tur=personal.getTurno();
                }
                
            }
            return tur;
            
    }

    //public ArrayList EstadisticasPersonalFecha(fecha){}
}
